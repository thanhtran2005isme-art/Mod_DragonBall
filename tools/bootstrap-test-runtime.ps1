$ErrorActionPreference = "Stop"

$root = Split-Path -Parent $PSScriptRoot
$lib = Join-Path $root "lib"
New-Item -ItemType Directory -Force -Path $lib | Out-Null

$microemu = Join-Path $lib "microemulator-2.0.4.jar"
if (-not (Test-Path $microemu)) {
    Write-Host "[bootstrap] Downloading MicroEmulator 2.0.4..."
    $url = "https://repo1.maven.org/maven2/org/microemu/microemulator/2.0.4/microemulator-2.0.4.jar"
    Invoke-WebRequest -UseBasicParsing -Uri $url -OutFile $microemu
}

if ((Get-Item $microemu).Length -lt 100000) {
    throw "microemulator-2.0.4.jar download looks invalid."
}

Write-Host "[bootstrap] Runtime ready: $microemu"
