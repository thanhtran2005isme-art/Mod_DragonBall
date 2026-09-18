namespace DragonController.Models;

public sealed class AccountProfile
{
    public int Id { get; set; }
    public string Username { get; set; } = "";
    public string Password { get; set; } = "";
    public string Server { get; set; } = "Vũ trụ 1";

    // Kept for backward compatibility with existing accounts.json files.
    // The UI now uses this column for Auto Login instead of notes.
    public string Note { get; set; } = "";

    public bool AutoLogin { get; set; } = true;
    public string AutoLoginText => AutoLogin ? "Bật" : "Tắt";

    public string WindowSize { get; set; } = "1024×600";

    // Runtime-only status. This is refreshed from the game process bridge and
    // is deliberately not persisted as account configuration.
    public string Status { get; set; } = "Off";

    public AccountProfile Clone() => (AccountProfile)MemberwiseClone();
}
