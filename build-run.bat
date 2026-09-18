@echo off
setlocal EnableExtensions
cd /d "%~dp0"

echo [run] Building the REAL Dragonboy250 game with the horizontal menu...
call build.bat mod
if errorlevel 1 (
  echo.
  echo [ERROR] Real game build failed.
  echo This script no longer falls back to the standalone menu preview.
  echo.
  pause
  exit /b 1
)

echo [run] Starting patched Dragonboy250 game...
java -jar "lib\microemulator-2.0.4.jar" "dist\Dragonboy250-test.jar"
if errorlevel 1 (
  echo.
  echo [ERROR] MicroEmulator could not start the patched game.
  echo You can open dist\Dragonboy250-test.jar with your current J2ME emulator.
  pause
  exit /b 2
)
