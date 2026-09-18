using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using DragonController.Models;

namespace DragonController.Services;

internal sealed class AccountStore
{
    private static readonly byte[] Entropy =
        Encoding.UTF8.GetBytes("DragonController.AccountStore.v1");

    private readonly string _filePath;
    private readonly JsonSerializerOptions _jsonOptions = new()
    {
        WriteIndented = true
    };

    public AccountStore()
    {
        var root = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "DragonController");

        Directory.CreateDirectory(root);
        _filePath = Path.Combine(root, "accounts.json");
    }

    public string FilePath => _filePath;

    public IReadOnlyList<AccountProfile> Load()
    {
        if (!File.Exists(_filePath))
            return Array.Empty<AccountProfile>();

        try
        {
            var json = File.ReadAllText(_filePath, Encoding.UTF8);
            var rows = JsonSerializer.Deserialize<List<StoredAccount>>(json, _jsonOptions)
                       ?? new List<StoredAccount>();

            var result = new List<AccountProfile>(rows.Count);

            foreach (var row in rows)
            {
                if (string.IsNullOrWhiteSpace(row.Username))
                    continue;

                result.Add(new AccountProfile
                {
                    Id = row.Id,
                    Username = row.Username,
                    Password = Unprotect(row.PasswordProtected),
                    Server = string.IsNullOrWhiteSpace(row.Server) ? "Vũ trụ 1" : row.Server,
                    Note = row.Note ?? "",
                    AutoLogin = row.AutoLogin ?? true,
                    WindowSize = string.IsNullOrWhiteSpace(row.WindowSize) ? "1024×600" : row.WindowSize,
                    Status = "Off"
                });
            }

            return result;
        }
        catch
        {
            // Do not destroy a potentially recoverable account file.
            return Array.Empty<AccountProfile>();
        }
    }

    public void Save(IEnumerable<AccountProfile> accounts)
    {
        var rows = accounts
            .OrderBy(x => x.Id)
            .Select(x => new StoredAccount
            {
                Id = x.Id,
                Username = x.Username,
                PasswordProtected = Protect(x.Password),
                Server = x.Server,
                Note = x.Note,
                AutoLogin = x.AutoLogin,
                WindowSize = x.WindowSize
            })
            .ToList();

        var json = JsonSerializer.Serialize(rows, _jsonOptions);
        var temp = _filePath + ".tmp";

        File.WriteAllText(temp, json, new UTF8Encoding(false));
        File.Move(temp, _filePath, true);
    }

    private static string Protect(string value)
    {
        if (string.IsNullOrEmpty(value))
            return "";

        var raw = Encoding.UTF8.GetBytes(value);
        var protectedBytes = ProtectedData.Protect(
            raw,
            Entropy,
            DataProtectionScope.CurrentUser);

        return Convert.ToBase64String(protectedBytes);
    }

    private static string Unprotect(string value)
    {
        if (string.IsNullOrWhiteSpace(value))
            return "";

        try
        {
            var protectedBytes = Convert.FromBase64String(value);
            var raw = ProtectedData.Unprotect(
                protectedBytes,
                Entropy,
                DataProtectionScope.CurrentUser);

            return Encoding.UTF8.GetString(raw);
        }
        catch
        {
            return "";
        }
    }

    private sealed class StoredAccount
    {
        public int Id { get; set; }
        public string Username { get; set; } = "";
        public string PasswordProtected { get; set; } = "";
        public string Server { get; set; } = "";
        public string Note { get; set; } = "";
        public bool? AutoLogin { get; set; }
        public string WindowSize { get; set; } = "";
    }
}
