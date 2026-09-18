@echo off
setlocal
cd /d "%~dp0"

where dotnet >nul 2>nul || (
  echo [ERROR] .NET SDK was not found.
  echo Install .NET 10 SDK, then reopen VS Code.
  pause
  exit /b 1
)

for /f "tokens=1 delims=." %%V in ('dotnet --version') do set "DOTNET_MAJOR=%%V"
if not "%DOTNET_MAJOR%"=="10" (
  echo [ERROR] .NET 10 SDK is required for Dragon Controller.
  echo Current SDK:
  dotnet --version
  echo.
  echo Install .NET 10 SDK, then reopen VS Code.
  pause
  exit /b 1
)

dotnet build "controller\DragonController\DragonController.csproj" -c Debug
if errorlevel 1 (
  echo.
  echo [ERROR] Controller build failed.
  pause
  exit /b 2
)

echo.
echo [OK] Starting Dragon Controller...
dotnet run --project "controller\DragonController\DragonController.csproj" -c Debug
