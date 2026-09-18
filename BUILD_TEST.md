# Build / test workflow

The project now has the requested one-command test layout:

```text
Mod_DragonBall/
├── src_v4_reconstructed/
├── src_preview/
├── lib/
├── build/
├── dist/
├── build.bat
└── build-run.bat
```

## Right now: test the new menu UI

Run from VS Code terminal:

```bat
build-run.bat
```

The script automatically downloads MicroEmulator 2.0.4 on first use, compiles the standalone J2ME preview and opens it.

Output:

```text
dist\HorizontalMenuPreview.jar
```

This preview is intentionally separated from the real game so the horizontal layout, grouping, keypad navigation and touch targets can be tested immediately.

## Real Dragonboy250 v4.0 JAR

```bat
build.bat mod
```

is intentionally blocked until the reconstructed hook for the original obfuscated `nro.N.class` exists. We do **not** generate a misleading JAR that still shows the old vertical menu.

The final pipeline will be:

```text
original v4.0 JAR
 + reconstructed menu classes
 + patched N hook / paint / input
              ↓
     dist\Dragonboy250-test.jar
              ↓
        J2ME emulator
```

## Controls in preview

- Left / Right: change horizontal group.
- Down or OK: enter the group's 2-column grid.
- Up / Down: change grid row.
- Left / Right: change grid column.
- Up from first row: return to the tab bar.
- Touch/click: select tab or function.

## First-run requirements

Only a normal JDK is needed for the preview. Check:

```bat
java -version
javac -version
```

The real CLDC/MIDP device build will additionally need a Java ME preverification toolchain; desktop emulator testing can proceed before that.
