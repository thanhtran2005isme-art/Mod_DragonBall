namespace DragonController.Models;

public sealed class GameServerInfo
{
    public string Name { get; init; } = "";
    public string Host { get; init; } = "";
    public int Port { get; init; }
    public byte Language { get; init; }
    public byte Meta1 { get; init; }
    public byte Meta2 { get; init; }
    public string SourcePath { get; init; } = "";

    public override string ToString() => Name;
}
