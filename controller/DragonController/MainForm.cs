using System.ComponentModel;
using DragonController.Models;

namespace DragonController;

public sealed class MainForm : Form
{
    private readonly List<AccountProfile> _accounts = new();
    private readonly BindingList<AccountProfile> _visibleAccounts = new();

    private readonly Panel _content = new();
    private readonly Dictionary<string, NavButton> _navButtons = new();

    private DataGridView _grid = null!;
    private TextBox _txtSearch = null!;
    private TextBox _txtUsername = null!;
    private TextBox _txtPassword = null!;
    private TextBox _txtNote = null!;
    private TextBox _txtSize = null!;
    private ComboBox _cmbServer = null!;
    private ComboBox _cmbSort = null!;
    private CheckBox _chkShowPassword = null!;
    private Label _lblSummary = null!;

    private int _nextId = 1;

    public MainForm()
    {
        Text = "Dragon Controller";
        StartPosition = FormStartPosition.CenterScreen;
        MinimumSize = new Size(900, 560);
        Size = new Size(1080, 650);
        BackColor = UiTheme.Page;
        Font = new Font("Segoe UI", 9F);
        Icon = SystemIcons.Application;

        BuildShell();
        ShowTab("Tài khoản");
        SeedPreviewAccount();
    }

    private void BuildShell()
    {
        var header = new Panel
        {
            Dock = DockStyle.Top,
            Height = 50,
            BackColor = UiTheme.Header,
            Padding = new Padding(8, 8, 8, 6)
        };
        Controls.Add(header);

        var tabs = new[] { "Tài khoản", "Điều khiển", "Cài đặt mặc định", "Cài đặt phím tắt" };
        var x = 8;
        foreach (var tab in tabs)
        {
            var width = tab switch
            {
                "Tài khoản" => 95,
                "Điều khiển" => 100,
                "Cài đặt mặc định" => 145,
                _ => 140
            };

            var button = new NavButton
            {
                Text = tab,
                Bounds = new Rectangle(x, 7, width, 34),
                Radius = 13,
                Font = new Font("Segoe UI", 9F, FontStyle.Bold)
            };
            button.Click += (_, _) => ShowTab(tab);
            header.Controls.Add(button);
            _navButtons[tab] = button;
            x += width + 4;
        }

        var theme = new Label
        {
            Text = "☀",
            AutoSize = false,
            Width = 40,
            Height = 34,
            TextAlign = ContentAlignment.MiddleCenter,
            Font = new Font("Segoe UI Symbol", 16F),
            ForeColor = Color.FromArgb(244, 151, 37),
            Anchor = AnchorStyles.Top | AnchorStyles.Right,
            Location = new Point(ClientSize.Width - 48, 7)
        };
        header.Controls.Add(theme);

        var language = new Label
        {
            Text = "VI",
            AutoSize = false,
            Width = 35,
            Height = 34,
            TextAlign = ContentAlignment.MiddleCenter,
            Font = new Font("Segoe UI", 9F, FontStyle.Bold),
            ForeColor = UiTheme.Text,
            Anchor = AnchorStyles.Top | AnchorStyles.Right,
            Location = new Point(ClientSize.Width - 85, 7)
        };
        header.Controls.Add(language);

        header.Resize += (_, _) =>
        {
            theme.Left = header.ClientSize.Width - 48;
            language.Left = header.ClientSize.Width - 85;
        };

        _content.Dock = DockStyle.Fill;
        _content.Padding = new Padding(8);
        _content.BackColor = UiTheme.Page;
        Controls.Add(_content);
        _content.BringToFront();
    }

    private void ShowTab(string tab)
    {
        foreach (var pair in _navButtons)
        {
            pair.Value.Active = pair.Key == tab;
            pair.Value.Invalidate();
        }

        _content.SuspendLayout();
        _content.Controls.Clear();

        if (tab == "Tài khoản")
            BuildAccountsTab();
        else if (tab == "Điều khiển")
            BuildPlaceholder("Điều khiển nhiều client", "Tab này sẽ chứa bảng client đang online, chọn nhóm và broadcast lệnh mod tới nhiều tab game.");
        else if (tab == "Cài đặt mặc định")
            BuildPlaceholder("Cài đặt mặc định", "Profile mặc định cho cửa sổ game, server, kích thước, Auto Login, Auto Reconnect và nhóm tài khoản.");
        else
            BuildPlaceholder("Cài đặt phím tắt", "Global hotkey cho đăng nhập, chọn nhóm, Auto Nhặt, Tàn Sát, Xmap và các lệnh điều khiển nhanh.");

        _content.ResumeLayout();
    }

    private void BuildAccountsTab()
    {
        var root = new TableLayoutPanel
        {
            Dock = DockStyle.Fill,
            ColumnCount = 2,
            RowCount = 1,
            BackColor = UiTheme.Page,
            Padding = new Padding(0)
        };
        root.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 72F));
        root.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 28F));
        _content.Controls.Add(root);

        var listCard = new RoundedPanel
        {
            Dock = DockStyle.Fill,
            Margin = new Padding(0, 0, 8, 0),
            Padding = new Padding(2),
            Radius = 11
        };
        root.Controls.Add(listCard, 0, 0);

        var editorCard = new RoundedPanel
        {
            Dock = DockStyle.Fill,
            Margin = new Padding(0),
            Padding = new Padding(10),
            Radius = 11
        };
        root.Controls.Add(editorCard, 1, 0);

        BuildAccountGrid(listCard);
        BuildAccountEditor(editorCard);
    }

    private void BuildAccountGrid(Control parent)
    {
        var container = new Panel { Dock = DockStyle.Fill, BackColor = UiTheme.White };
        parent.Controls.Add(container);

        _lblSummary = new Label
        {
            Dock = DockStyle.Bottom,
            Height = 28,
            Padding = new Padding(8, 0, 0, 0),
            TextAlign = ContentAlignment.MiddleLeft,
            ForeColor = UiTheme.Gray,
            BackColor = UiTheme.White
        };
        container.Controls.Add(_lblSummary);

        _grid = new DataGridView
        {
            Dock = DockStyle.Fill,
            BackgroundColor = UiTheme.White,
            BorderStyle = BorderStyle.None,
            GridColor = Color.FromArgb(230, 220, 202),
            RowHeadersVisible = false,
            AllowUserToAddRows = false,
            AllowUserToDeleteRows = false,
            AllowUserToResizeRows = false,
            MultiSelect = true,
            SelectionMode = DataGridViewSelectionMode.FullRowSelect,
            AutoGenerateColumns = false,
            ReadOnly = true,
            ColumnHeadersHeight = 34,
            RowTemplate = { Height = 31 },
            EnableHeadersVisualStyles = false
        };

        _grid.ColumnHeadersDefaultCellStyle.BackColor = UiTheme.Header;
        _grid.ColumnHeadersDefaultCellStyle.ForeColor = UiTheme.Text;
        _grid.ColumnHeadersDefaultCellStyle.Font = new Font("Segoe UI", 8.5F, FontStyle.Bold);
        _grid.ColumnHeadersDefaultCellStyle.SelectionBackColor = UiTheme.Header;
        _grid.ColumnHeadersDefaultCellStyle.Alignment = DataGridViewContentAlignment.MiddleLeft;
        _grid.DefaultCellStyle.BackColor = UiTheme.White;
        _grid.DefaultCellStyle.ForeColor = UiTheme.Text;
        _grid.DefaultCellStyle.SelectionBackColor = Color.FromArgb(255, 238, 197);
        _grid.DefaultCellStyle.SelectionForeColor = UiTheme.Text;

        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "ID", DataPropertyName = nameof(AccountProfile.Id), Width = 52 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "T.khoản", DataPropertyName = nameof(AccountProfile.Username), FillWeight = 28, AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "M.chủ", DataPropertyName = nameof(AccountProfile.Server), Width = 105 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "G.chú", DataPropertyName = nameof(AccountProfile.Note), FillWeight = 28, AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "K.thước", DataPropertyName = nameof(AccountProfile.WindowSize), Width = 92 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "T.thái", DataPropertyName = nameof(AccountProfile.Status), Width = 90 });

        _grid.DataSource = _visibleAccounts;
        _grid.SelectionChanged += (_, _) => LoadSelectedAccount();
        _grid.CellDoubleClick += (_, e) =>
        {
            if (e.RowIndex >= 0 && SelectedAccount() is { } account)
                RequestLogin(account);
        };

        container.Controls.Add(_grid);
        _grid.BringToFront();
        UpdateSummary();
    }

    private void BuildAccountEditor(Control parent)
    {
        var layout = new TableLayoutPanel
        {
            Dock = DockStyle.Fill,
            ColumnCount = 2,
            RowCount = 14,
            BackColor = UiTheme.White,
            Padding = new Padding(0),
            AutoScroll = true
        };
        layout.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 52));
        layout.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 48));
        parent.Controls.Add(layout);

        _txtSearch = MakeTextBox();
        _txtSearch.TextChanged += (_, _) => ApplyFilter();
        AddFullField(layout, 0, "Tìm kiếm", _txtSearch);

        _txtUsername = MakeTextBox();
        AddFullField(layout, 1, "Tên tài khoản", _txtUsername);

        var passwordPanel = new Panel { Dock = DockStyle.Fill, Height = 42, BackColor = UiTheme.White };
        _txtPassword = MakeTextBox();
        _txtPassword.UseSystemPasswordChar = true;
        _txtPassword.Dock = DockStyle.Fill;
        _chkShowPassword = new CheckBox
        {
            Dock = DockStyle.Right,
            Width = 28,
            Text = "",
            Appearance = Appearance.Button,
            FlatStyle = FlatStyle.Flat,
            TextAlign = ContentAlignment.MiddleCenter,
            BackColor = UiTheme.White
        };
        _chkShowPassword.FlatAppearance.BorderColor = UiTheme.BorderSoft;
        _chkShowPassword.CheckedChanged += (_, _) => _txtPassword.UseSystemPasswordChar = !_chkShowPassword.Checked;
        passwordPanel.Controls.Add(_txtPassword);
        passwordPanel.Controls.Add(_chkShowPassword);
        AddFullField(layout, 2, "Mật khẩu", passwordPanel);

        _cmbServer = MakeComboBox();
        for (var i = 1; i <= 20; i++) _cmbServer.Items.Add($"Vũ trụ {i}");
        _cmbServer.SelectedIndex = 0;

        var import = MakeButton("+ TỆP");
        import.Click += (_, _) => ImportAccounts();
        AddSplitField(layout, 3, "Máy chủ", _cmbServer, import);

        _txtNote = MakeTextBox();
        _txtSize = MakeTextBox();
        _txtSize.Text = "1024×600";
        AddSplitField(layout, 4, "Ghi chú", _txtNote, _txtSize, "K.thước");

        var add = MakeButton("Thêm", accent: true);
        var edit = MakeButton("Sửa");
        add.Click += (_, _) => AddAccount();
        edit.Click += (_, _) => EditAccount();
        AddButtonPair(layout, 5, add, edit);

        var login = MakeButton("Đăng nhập", accent: true);
        var hide = MakeButton("Ẩn taskbar");
        login.Click += (_, _) =>
        {
            if (SelectedAccount() is { } account) RequestLogin(account);
            else MessageBox.Show(this, "Hãy chọn một tài khoản trước.", "Dragon Controller", MessageBoxButtons.OK, MessageBoxIcon.Information);
        };
        hide.Click += (_, _) => MessageBox.Show(this, "Nút này sẽ nối vào WindowManager ở bước sau.", "Dragon Controller");
        AddButtonPair(layout, 6, login, hide);

        _cmbSort = MakeComboBox();
        _cmbSort.Items.AddRange(new object[] { "Mặc định", "Tài khoản", "Máy chủ", "Trạng thái" });
        _cmbSort.SelectedIndex = 0;
        _cmbSort.SelectedIndexChanged += (_, _) => ApplyFilter();

        var sort = MakeButton("Sắp xếp");
        sort.Click += (_, _) => ApplyFilter();
        AddSplitField(layout, 7, "", _cmbSort, sort);

        var close = MakeButton("Đóng");
        var closeAll = MakeButton("Đóng tất cả", danger: true);
        close.Click += (_, _) => SetSelectedStatus("Offline");
        closeAll.Click += (_, _) =>
        {
            foreach (var account in _accounts) account.Status = "Offline";
            ApplyFilter();
        };
        AddButtonPair(layout, 8, close, closeAll);

        var delete = MakeButton("Xóa", danger: true);
        delete.Click += (_, _) => DeleteSelected();
        layout.Controls.Add(delete, 0, 9);
        layout.SetColumnSpan(delete, 2);
        delete.Dock = DockStyle.Fill;
        delete.Margin = new Padding(0, 4, 0, 2);

        var hint = new Label
        {
            Text = "Mẹo: double-click tài khoản để mở game và đăng nhập tự động.",
            Dock = DockStyle.Fill,
            ForeColor = UiTheme.Gray,
            Padding = new Padding(2, 10, 2, 0),
            AutoSize = false
        };
        layout.Controls.Add(hint, 0, 10);
        layout.SetColumnSpan(hint, 2);

        for (var row = 0; row < layout.RowCount; row++)
            layout.RowStyles.Add(new RowStyle(SizeType.AutoSize));
    }

    private void BuildPlaceholder(string title, string detail)
    {
        var card = new RoundedPanel
        {
            Dock = DockStyle.Fill,
            Padding = new Padding(28),
            Radius = 12
        };
        _content.Controls.Add(card);

        var heading = new Label
        {
            Dock = DockStyle.Top,
            Height = 48,
            Text = title,
            Font = new Font("Segoe UI", 16F, FontStyle.Bold),
            ForeColor = UiTheme.Text
        };
        card.Controls.Add(heading);

        var body = new Label
        {
            Dock = DockStyle.Top,
            Height = 80,
            Text = detail,
            Font = new Font("Segoe UI", 10F),
            ForeColor = UiTheme.Gray
        };
        card.Controls.Add(body);
        body.BringToFront();
    }

    private static TextBox MakeTextBox() => new()
    {
        BorderStyle = BorderStyle.FixedSingle,
        BackColor = UiTheme.White,
        ForeColor = UiTheme.Text,
        Font = new Font("Segoe UI", 9F),
        Dock = DockStyle.Fill,
        Margin = new Padding(0)
    };

    private static ComboBox MakeComboBox() => new()
    {
        DropDownStyle = ComboBoxStyle.DropDownList,
        FlatStyle = FlatStyle.Flat,
        BackColor = UiTheme.White,
        ForeColor = UiTheme.Text,
        Dock = DockStyle.Fill,
        Font = new Font("Segoe UI", 9F)
    };

    private static FlatRoundButton MakeButton(string text, bool accent = false, bool danger = false)
    {
        var button = new FlatRoundButton
        {
            Text = text,
            Height = 34,
            Dock = DockStyle.Fill,
            Margin = new Padding(0, 3, 0, 3)
        };

        if (accent)
        {
            button.NormalColor = UiTheme.Accent;
            button.HoverColor = Color.FromArgb(195, 102, 35);
            button.PressedColor = Color.FromArgb(145, 61, 14);
            button.BorderColor = UiTheme.Accent;
            button.ForeColor = Color.White;
        }

        if (danger)
        {
            button.NormalColor = UiTheme.AccentDark;
            button.HoverColor = Color.FromArgb(180, 48, 22);
            button.PressedColor = Color.FromArgb(125, 24, 8);
            button.BorderColor = UiTheme.AccentDark;
            button.ForeColor = Color.White;
        }

        return button;
    }

    private static void AddFullField(TableLayoutPanel layout, int row, string label, Control control)
    {
        var host = FieldHost(label, control);
        layout.Controls.Add(host, 0, row);
        layout.SetColumnSpan(host, 2);
    }

    private static void AddSplitField(TableLayoutPanel layout, int row, string leftLabel, Control left, Control right, string rightLabel = "")
    {
        var leftHost = FieldHost(leftLabel, left);
        var rightHost = string.IsNullOrWhiteSpace(rightLabel) ? right : FieldHost(rightLabel, right);
        layout.Controls.Add(leftHost, 0, row);
        layout.Controls.Add(rightHost, 1, row);
        leftHost.Margin = new Padding(0, 2, 4, 2);
        rightHost.Margin = new Padding(4, 2, 0, 2);
        right.Dock = DockStyle.Fill;
    }

    private static void AddButtonPair(TableLayoutPanel layout, int row, Control left, Control right)
    {
        layout.Controls.Add(left, 0, row);
        layout.Controls.Add(right, 1, row);
        left.Margin = new Padding(0, 3, 4, 3);
        right.Margin = new Padding(4, 3, 0, 3);
    }

    private static Control FieldHost(string label, Control control)
    {
        var host = new Panel { Height = 54, Dock = DockStyle.Top, BackColor = UiTheme.White, Padding = new Padding(0, 14, 0, 0) };
        var caption = new Label
        {
            Text = label,
            AutoSize = true,
            BackColor = UiTheme.White,
            ForeColor = UiTheme.Accent,
            Font = new Font("Segoe UI", 8F),
            Location = new Point(8, 1)
        };
        control.Dock = DockStyle.Fill;
        host.Controls.Add(control);
        host.Controls.Add(caption);
        caption.BringToFront();
        return host;
    }

    private AccountProfile? SelectedAccount()
    {
        if (_grid.SelectedRows.Count == 0) return null;
        return _grid.SelectedRows[0].DataBoundItem as AccountProfile;
    }

    private IEnumerable<AccountProfile> SelectedAccounts()
    {
        foreach (DataGridViewRow row in _grid.SelectedRows)
            if (row.DataBoundItem is AccountProfile account)
                yield return account;
    }

    private void LoadSelectedAccount()
    {
        var account = SelectedAccount();
        if (account is null) return;

        _txtUsername.Text = account.Username;
        _txtPassword.Text = account.Password;
        _txtNote.Text = account.Note;
        _txtSize.Text = account.WindowSize;
        _cmbServer.SelectedItem = account.Server;
        if (_cmbServer.SelectedIndex < 0) _cmbServer.Text = account.Server;
        UpdateSummary();
    }

    private void AddAccount()
    {
        var username = _txtUsername.Text.Trim();
        if (username.Length == 0)
        {
            MessageBox.Show(this, "Tên tài khoản không được để trống.", "Dragon Controller", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            _txtUsername.Focus();
            return;
        }

        if (_accounts.Any(x => string.Equals(x.Username, username, StringComparison.OrdinalIgnoreCase)))
        {
            MessageBox.Show(this, "Tài khoản này đã tồn tại.", "Dragon Controller", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            return;
        }

        _accounts.Add(new AccountProfile
        {
            Id = _nextId++,
            Username = username,
            Password = _txtPassword.Text,
            Server = _cmbServer.Text,
            Note = _txtNote.Text.Trim(),
            WindowSize = NormalizeSize(_txtSize.Text),
            Status = "Offline"
        });

        ClearEditor();
        ApplyFilter();
    }

    private void EditAccount()
    {
        var account = SelectedAccount();
        if (account is null)
        {
            MessageBox.Show(this, "Hãy chọn tài khoản cần sửa.", "Dragon Controller");
            return;
        }

        account.Username = _txtUsername.Text.Trim();
        account.Password = _txtPassword.Text;
        account.Server = _cmbServer.Text;
        account.Note = _txtNote.Text.Trim();
        account.WindowSize = NormalizeSize(_txtSize.Text);
        ApplyFilter();
    }

    private void DeleteSelected()
    {
        var selected = SelectedAccounts().Distinct().ToList();
        if (selected.Count == 0) return;

        var answer = MessageBox.Show(
            this,
            $"Xóa {selected.Count} tài khoản đã chọn?",
            "Dragon Controller",
            MessageBoxButtons.YesNo,
            MessageBoxIcon.Warning);

        if (answer != DialogResult.Yes) return;

        foreach (var account in selected) _accounts.Remove(account);
        ApplyFilter();
    }

    private void SetSelectedStatus(string status)
    {
        foreach (var account in SelectedAccounts()) account.Status = status;
        ApplyFilter();
    }

    private void RequestLogin(AccountProfile account)
    {
        account.Status = "Starting";
        ApplyFilter();

        MessageBox.Show(
            this,
            $"Đã tạo yêu cầu mở game cho:\n\n{account.Username} • {account.Server}\n\nBước tiếp theo sẽ nối nút này với GameLauncher + RemoteBridge để tự mở client và tự đăng nhập.",
            "Dragon Controller",
            MessageBoxButtons.OK,
            MessageBoxIcon.Information);
    }

    private void ApplyFilter()
    {
        if (_grid is null || _txtSearch is null) return;

        var query = _txtSearch.Text.Trim();
        IEnumerable<AccountProfile> filtered = _accounts;

        if (query.Length > 0)
        {
            filtered = filtered.Where(x =>
                ContainsIgnoreCase(x.Username, query) ||
                ContainsIgnoreCase(x.Server, query) ||
                ContainsIgnoreCase(x.Note, query) ||
                ContainsIgnoreCase(x.Status, query));
        }

        filtered = _cmbSort?.SelectedItem?.ToString() switch
        {
            "Tài khoản" => filtered.OrderBy(x => x.Username),
            "Máy chủ" => filtered.OrderBy(x => x.Server).ThenBy(x => x.Username),
            "Trạng thái" => filtered.OrderBy(x => x.Status).ThenBy(x => x.Username),
            _ => filtered.OrderBy(x => x.Id)
        };

        _visibleAccounts.RaiseListChangedEvents = false;
        _visibleAccounts.Clear();
        foreach (var account in filtered) _visibleAccounts.Add(account);
        _visibleAccounts.RaiseListChangedEvents = true;
        _visibleAccounts.ResetBindings();

        UpdateSummary();
    }

    private void ImportAccounts()
    {
        using var dialog = new OpenFileDialog
        {
            Filter = "Text files (*.txt)|*.txt|All files (*.*)|*.*",
            Title = "Nhập danh sách tài khoản"
        };

        if (dialog.ShowDialog(this) != DialogResult.OK) return;

        var added = 0;
        foreach (var raw in File.ReadAllLines(dialog.FileName))
        {
            var line = raw.Trim();
            if (line.Length == 0 || line.StartsWith("#")) continue;

            var parts = line.Split('|');
            var username = parts.ElementAtOrDefault(0)?.Trim() ?? "";
            if (username.Length == 0 || _accounts.Any(x => string.Equals(x.Username, username, StringComparison.OrdinalIgnoreCase)))
                continue;

            _accounts.Add(new AccountProfile
            {
                Id = _nextId++,
                Username = username,
                Password = parts.ElementAtOrDefault(1)?.Trim() ?? "",
                Server = parts.ElementAtOrDefault(2)?.Trim() is { Length: > 0 } server ? server : "Vũ trụ 1",
                Note = parts.ElementAtOrDefault(3)?.Trim() ?? "",
                WindowSize = "1024×600",
                Status = "Offline"
            });
            added++;
        }

        ApplyFilter();
        MessageBox.Show(this, $"Đã thêm {added} tài khoản.", "Dragon Controller");
    }

    private void ClearEditor()
    {
        _txtUsername.Clear();
        _txtPassword.Clear();
        _txtNote.Clear();
        _txtSize.Text = "1024×600";
        _cmbServer.SelectedIndex = 0;
    }

    private void UpdateSummary()
    {
        if (_lblSummary is null) return;
        var running = _accounts.Count(x => !string.Equals(x.Status, "Offline", StringComparison.OrdinalIgnoreCase));
        var selected = _grid?.SelectedRows.Count ?? 0;
        _lblSummary.Text = $"Tổng: {_accounts.Count}   •   Đang chạy: {running}   •   Đã chọn: {selected}   •   Double-click để đăng nhập";
    }

    private static bool ContainsIgnoreCase(string source, string value) =>
        source?.IndexOf(value, StringComparison.OrdinalIgnoreCase) >= 0;

    private static string NormalizeSize(string value)
    {
        var clean = value.Trim().Replace('x', '×').Replace('X', '×');
        return clean.Length == 0 ? "1024×600" : clean;
    }

    private void SeedPreviewAccount()
    {
        _accounts.Add(new AccountProfile
        {
            Id = _nextId++,
            Username = "0977128039",
            Password = "",
            Server = "Vũ trụ 15",
            Note = "",
            WindowSize = "1024×600",
            Status = "Offline"
        });
        ApplyFilter();
    }
}
