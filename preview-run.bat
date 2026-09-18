@echo off
setlocal EnableExtensions
cd /d "%~dp0"

call build.bat preview
if errorlevel 1 (
  echo [ERROR] Preview build failed.
  pause
  exit /b 1
)

java -jar "lib\microemulator-2.0.4.jar" "dist\HorizontalMenuPreview.jar"
