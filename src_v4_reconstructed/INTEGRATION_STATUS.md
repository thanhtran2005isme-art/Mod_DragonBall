# v4.0 integration status

## Completed

- Recovered current v4.0 menu owner: `nro.N`.
- Identified the current vertical menu methods and submenus.
- Recovered many original command IDs.
- Added horizontal scrolling tab UI source.
- Added grouped 2-column function catalog.
- Added command-key bridge design.
- Added a runnable standalone J2ME UI preview.
- Added `build.bat` / `build-run.bat`.

## Next technical step

The real game still enters the existing vertical `N.bt()` / panel flow.

To replace it safely we must patch the obfuscated v4.0 bytecode at three integration points:

1. menu-open entry point;
2. paint path;
3. keypad/touch update path.

The helper classes alone are not enough; they must be referenced by live game bytecode.

Until those hooks are in place, `build.bat mod` deliberately stops instead of producing a JAR that appears to be modified but still uses the old menu.
