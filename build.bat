@echo off
setlocal EnableExtensions EnableDelayedExpansion
cd /d "%~dp0"

set "MODE=%~1"
if "%MODE%"=="" set "MODE=preview"

if /I "%MODE%"=="preview" goto :PREVIEW
if /I "%MODE%"=="mod" goto :MOD

echo Usage:
echo   build.bat preview
echo   build.bat mod
exit /b 2

:CHECK_JAVA
where java >nul 2>nul || (
  echo [ERROR] Java was not found in PATH.
  echo Install a JDK and restart VS Code.
  exit /b 10
)
where javac >nul 2>nul || (
  echo [ERROR] javac was not found in PATH. A JDK is required.
  exit /b 11
)
where jar >nul 2>nul || (
  echo [ERROR] jar.exe was not found in PATH. A JDK is required.
  exit /b 12
)
exit /b 0

:BOOTSTRAP
powershell -NoProfile -ExecutionPolicy Bypass -File "tools\bootstrap-test-runtime.ps1"
if errorlevel 1 exit /b 20
exit /b 0

:PREVIEW
call :CHECK_JAVA || exit /b !errorlevel!
call :BOOTSTRAP || exit /b !errorlevel!

echo [build] Cleaning preview output...
if exist "build\preview" rmdir /s /q "build\preview"
if not exist "build\preview" mkdir "build\preview"
if not exist "dist" mkdir "dist"

echo [build] Compiling horizontal menu preview...
javac -encoding UTF-8 -source 8 -target 8 ^
  -cp "lib\microemulator-2.0.4.jar" ^
  -d "build\preview" ^
  "src_preview\preview\MenuPreviewMidlet.java"
if errorlevel 1 exit /b 30

> "build\preview-manifest.mf" echo Manifest-Version: 1.0
>>"build\preview-manifest.mf" echo MIDlet-1: Dragonboy250 Menu Preview,,preview.MenuPreviewMidlet
>>"build\preview-manifest.mf" echo MIDlet-Name: Dragonboy250 Menu Preview
>>"build\preview-manifest.mf" echo MIDlet-Vendor: Mod_DragonBall
>>"build\preview-manifest.mf" echo MIDlet-Version: 0.1.0
>>"build\preview-manifest.mf" echo MicroEdition-Configuration: CLDC-1.1
>>"build\preview-manifest.mf" echo MicroEdition-Profile: MIDP-2.0

if exist "dist\HorizontalMenuPreview.jar" del /q "dist\HorizontalMenuPreview.jar"
jar cfm "dist\HorizontalMenuPreview.jar" "build\preview-manifest.mf" -C "build\preview" .
if errorlevel 1 exit /b 31

echo.
echo [OK] Built: dist\HorizontalMenuPreview.jar
echo [INFO] This tests the new horizontal/grouped UI only.
echo.
exit /b 0

:MOD
call :CHECK_JAVA || exit /b !errorlevel!

echo [build] Checking v4 integration status...
if not exist "src_v4_reconstructed\nro\N.java" (
  echo.
  echo [NOT READY] The real v4.0 N.class hook has not been reconstructed yet.
  echo build.bat will NOT create a fake Dragonboy250-test.jar that behaves exactly like v4.0.
  echo.
  echo Use:
  echo   build-run.bat
  echo to test the horizontal menu UI preview now.
  echo.
  exit /b 40
)

echo [ERROR] v4 integration source exists but the final compile/preverify pipeline
echo has not been enabled yet.
exit /b 41
