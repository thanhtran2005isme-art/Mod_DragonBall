namespace DragonController.Models;

public sealed class AccountProfile
{
    public int Id { get; set; }
    public string Username { get; set; } = "";
    public string Password { get; set; } = "";
    public string Server { get; set; } = "Vũ trụ 1";
    public string Note { get; set; } = "";
    public string WindowSize { get; set; } = "1024×600";
    public string Status { get; set; } = "Offline";

    public AccountProfile Clone() => (AccountProfile)MemberwiseClone();
}
