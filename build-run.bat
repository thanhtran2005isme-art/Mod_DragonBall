@echo off
setlocal EnableExtensions
cd /d "%~dp0"

call build.bat preview
if errorlevel 1 (
  echo.
  echo [ERROR] Preview build failed.
  pause
  exit /b 1
)

echo [run] Starting MicroEmulator...
java -jar "lib\microemulator-2.0.4.jar" "dist\HorizontalMenuPreview.jar"
if errorlevel 1 (
  echo.
  echo [ERROR] MicroEmulator could not start the preview JAR.
  echo You can still open dist\HorizontalMenuPreview.jar with your current J2ME emulator.
  pause
  exit /b 2
)
