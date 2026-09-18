@echo off
setlocal EnableExtensions
cd /d "%~dp0"

echo [run] Building the REAL Dragonboy250 game with the horizontal menu...
call build.bat mod
if errorlevel 1 (
  echo.
  echo [ERROR] Real game build failed.
  echo.
  pause
  exit /b 1
)

echo.
echo [OK] Patched game built:
echo   %CD%\dist\Dragonboy250-test.jar
echo.

set "REMOTER_DIR=%USERPROFILE%\Desktop\EmulatorRemoter"
if exist "%REMOTER_DIR%" (
  copy /Y "dist\Dragonboy250-test.jar" "%REMOTER_DIR%\Dragonboy250-test.jar" >nul
  if errorlevel 1 (
    echo [WARN] Could not copy the test JAR to:
    echo   %REMOTER_DIR%
  ) else (
    echo [OK] Copied for MicroEmulatorRemoter:
    echo   %REMOTER_DIR%\Dragonboy250-test.jar
    echo.
    echo In MicroEmulatorRemoter, set the Game field to:
    echo   %REMOTER_DIR%\Dragonboy250-test.jar
    echo then click Bat dau.
  )
) else (
  echo [INFO] EmulatorRemoter folder was not found automatically.
  echo In your emulator, browse to:
  echo   %CD%\dist\Dragonboy250-test.jar
)

echo.
pause
