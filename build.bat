@echo off
setlocal EnableExtensions EnableDelayedExpansion
cd /d "%~dp0"

set "MODE=%~1"
if "%MODE%"=="" set "MODE=mod"

if /I "%MODE%"=="preview" goto :PREVIEW
if /I "%MODE%"=="mod" goto :MOD

echo Usage:
echo   build.bat mod
echo   build.bat preview
exit /b 2

:CHECK_JAVA
where javac >nul 2>nul && where jar >nul 2>nul && where java >nul 2>nul && exit /b 0

if defined JAVA_HOME if exist "%JAVA_HOME%\bin\javac.exe" (
  set "PATH=%JAVA_HOME%\bin;%PATH%"
  echo [java] Using JAVA_HOME: %JAVA_HOME%
  exit /b 0
)

for /d %%D in (
  "%ProgramFiles%\Eclipse Adoptium\jdk-*"
  "%ProgramFiles%\Java\jdk-*"
  "%ProgramFiles%\Microsoft\jdk-*"
  "%ProgramFiles%\Zulu\zulu-*"
  "%LocalAppData%\Programs\Eclipse Adoptium\jdk-*"
) do (
  if exist "%%~fD\bin\javac.exe" (
    set "JAVA_HOME=%%~fD"
    set "PATH=%%~fD\bin;!PATH!"
    echo [java] Auto-detected JDK: %%~fD
    exit /b 0
  )
)

echo.
echo [ERROR] A full JDK was not found.
echo Install JDK 17, reopen VS Code, then retry.
echo.
exit /b 11

:BOOTSTRAP
powershell -NoProfile -ExecutionPolicy Bypass -File "tools\bootstrap-test-runtime.ps1"
if errorlevel 1 exit /b 20
exit /b 0

:FIND_ORIGINAL
set "ORIGINAL_JAR="
for %%F in (
  "Dragonboy250 v4.0.jar"
  "Dragonboy250 v4.0-original.jar"
  "lib\Dragonboy250 v4.0.jar"
  "lib\Dragonboy250 v4.0-original.jar"
) do (
  if not defined ORIGINAL_JAR if exist "%%~F" set "ORIGINAL_JAR=%%~fF"
)
exit /b 0

:MOD
call :CHECK_JAVA || exit /b !errorlevel!
call :BOOTSTRAP || exit /b !errorlevel!
call :FIND_ORIGINAL

if not defined ORIGINAL_JAR (
  echo.
  echo [ERROR] Original Dragonboy250 v4.0 JAR was not found.
  echo.
  echo Copy your original file into this project as either:
  echo   Dragonboy250 v4.0.jar
  echo or:
  echo   lib\Dragonboy250 v4.0.jar
  echo.
  echo Then run build-run.bat again.
  echo.
  exit /b 40
)

echo [mod] Original JAR: !ORIGINAL_JAR!

if exist "build\mod" rmdir /s /q "build\mod"
if exist "build\patcher" rmdir /s /q "build\patcher"
if not exist "build\mod" mkdir "build\mod"
if not exist "build\patcher" mkdir "build\patcher"
if not exist "dist" mkdir "dist"

echo [mod] Compiling horizontal menu runtime...
javac -encoding UTF-8 -source 8 -target 8 ^
  -cp "!ORIGINAL_JAR!;lib\microemulator-2.0.4.jar" ^
  -d "build\mod" ^
  "src_v4_reconstructed\nro\ModHorizontalRuntime.java"
if errorlevel 1 exit /b 41

echo [mod] Compiling bytecode patcher...
javac ^
  --add-exports java.base/jdk.internal.org.objectweb.asm=ALL-UNNAMED ^
  -d "build\patcher" ^
  "tools\PatchJar.java"
if errorlevel 1 exit /b 42

echo [mod] Patching original game...
java ^
  --add-exports java.base/jdk.internal.org.objectweb.asm=ALL-UNNAMED ^
  -cp "build\patcher" ^
  PatchJar ^
  "!ORIGINAL_JAR!" ^
  "build\mod\nro\ModHorizontalRuntime.class" ^
  "dist\Dragonboy250-test.jar"
if errorlevel 1 exit /b 43

jar tf "dist\Dragonboy250-test.jar" | findstr /C:"nro/ModHorizontalRuntime.class" >nul
if errorlevel 1 (
  echo [ERROR] Patched runtime class is missing from output JAR.
  exit /b 44
)

echo.
echo [OK] Real game test JAR built:
echo   dist\Dragonboy250-test.jar
echo.
echo The game remains intact. When the old MENU HUNG HERO entry opens,
echo N.bt() is redirected to the horizontal overlay.
echo.
exit /b 0

:PREVIEW
call :CHECK_JAVA || exit /b !errorlevel!
call :BOOTSTRAP || exit /b !errorlevel!

if exist "build\preview" rmdir /s /q "build\preview"
if not exist "build\preview" mkdir "build\preview"
if not exist "dist" mkdir "dist"

echo [preview] Compiling standalone menu preview...
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
echo [OK] Standalone preview built: dist\HorizontalMenuPreview.jar
echo.
exit /b 0
