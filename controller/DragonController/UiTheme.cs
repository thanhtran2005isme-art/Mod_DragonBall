using System.Drawing.Drawing2D;

namespace DragonController;

internal static class UiTheme
{
    public static readonly Color Page = Color.FromArgb(251, 248, 241);
    public static readonly Color Header = Color.FromArgb(245, 222, 167);
    public static readonly Color Border = Color.FromArgb(207, 156, 70);
    public static readonly Color BorderSoft = Color.FromArgb(223, 191, 133);
    public static readonly Color Accent = Color.FromArgb(174, 82, 22);
    public static readonly Color AccentDark = Color.FromArgb(156, 35, 12);
    public static readonly Color ButtonSoft = Color.FromArgb(238, 210, 151);
    public static readonly Color Text = Color.FromArgb(91, 50, 19);
    public static readonly Color White = Color.FromArgb(255, 253, 248);
    public static readonly Color Green = Color.FromArgb(45, 130, 70);
    public static readonly Color Gray = Color.FromArgb(120, 120, 120);

    public static GraphicsPath RoundedRect(Rectangle bounds, int radius)
    {
        var path = new GraphicsPath();
        var d = radius * 2;
        path.AddArc(bounds.X, bounds.Y, d, d, 180, 90);
        path.AddArc(bounds.Right - d, bounds.Y, d, d, 270, 90);
        path.AddArc(bounds.Right - d, bounds.Bottom - d, d, d, 0, 90);
        path.AddArc(bounds.X, bounds.Bottom - d, d, d, 90, 90);
        path.CloseFigure();
        return path;
    }
}

internal class RoundedPanel : Panel
{
    public int Radius { get; set; } = 10;
    public Color BorderColor { get; set; } = UiTheme.Border;
    public int BorderWidth { get; set; } = 1;

    public RoundedPanel()
    {
        DoubleBuffered = true;
        BackColor = UiTheme.White;
        ResizeRedraw = true;
    }

    protected override void OnPaint(PaintEventArgs e)
    {
        base.OnPaint(e);
        e.Graphics.SmoothingMode = SmoothingMode.AntiAlias;
        var rect = new Rectangle(0, 0, Width - 1, Height - 1);
        using var path = UiTheme.RoundedRect(rect, Radius);
        using var pen = new Pen(BorderColor, BorderWidth);
        e.Graphics.DrawPath(pen, path);
    }

    protected override void OnResize(EventArgs eventargs)
    {
        base.OnResize(eventargs);
        if (Width <= 0 || Height <= 0) return;
        using var path = UiTheme.RoundedRect(new Rectangle(0, 0, Width, Height), Radius);
        Region = new Region(path);
    }
}

internal class FlatRoundButton : Button
{
    public int Radius { get; set; } = 9;
    public Color NormalColor { get; set; } = UiTheme.ButtonSoft;
    public Color HoverColor { get; set; } = Color.FromArgb(247, 224, 178);
    public Color PressedColor { get; set; } = Color.FromArgb(225, 179, 105);
    public Color BorderColor { get; set; } = UiTheme.Border;

    private bool _hover;
    private bool _pressed;

    public FlatRoundButton()
    {
        FlatStyle = FlatStyle.Flat;
        FlatAppearance.BorderSize = 0;
        BackColor = Color.Transparent;
        ForeColor = UiTheme.Text;
        Font = new Font("Segoe UI", 9F, FontStyle.Bold);
        Cursor = Cursors.Hand;
        DoubleBuffered = true;
    }

    protected override void OnMouseEnter(EventArgs e) { _hover = true; Invalidate(); base.OnMouseEnter(e); }
    protected override void OnMouseLeave(EventArgs e) { _hover = false; _pressed = false; Invalidate(); base.OnMouseLeave(e); }
    protected override void OnMouseDown(MouseEventArgs mevent) { _pressed = true; Invalidate(); base.OnMouseDown(mevent); }
    protected override void OnMouseUp(MouseEventArgs mevent) { _pressed = false; Invalidate(); base.OnMouseUp(mevent); }

    protected override void OnPaint(PaintEventArgs pevent)
    {
        pevent.Graphics.SmoothingMode = SmoothingMode.AntiAlias;
        var rect = new Rectangle(0, 0, Width - 1, Height - 1);
        using var path = UiTheme.RoundedRect(rect, Radius);
        var fill = _pressed ? PressedColor : (_hover ? HoverColor : NormalColor);
        using var brush = new SolidBrush(fill);
        using var pen = new Pen(BorderColor);
        pevent.Graphics.FillPath(brush, path);
        pevent.Graphics.DrawPath(pen, path);

        TextRenderer.DrawText(
            pevent.Graphics,
            Text,
            Font,
            rect,
            ForeColor,
            TextFormatFlags.HorizontalCenter | TextFormatFlags.VerticalCenter | TextFormatFlags.EndEllipsis);
    }
}

internal sealed class NavButton : FlatRoundButton
{
    public bool Active { get; set; }

    protected override void OnPaint(PaintEventArgs pevent)
    {
        NormalColor = Active ? UiTheme.White : UiTheme.Header;
        BorderColor = Active ? UiTheme.White : UiTheme.Header;
        base.OnPaint(pevent);
    }
}
