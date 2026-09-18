# Test inside the real Dragonboy250 game

The previous `build-run.bat` launched a standalone MIDlet preview. That was useful for layout testing, but it did **not** contain the game.

The branch now has a bytecode patch pipeline for the original v4.0 JAR.

## One-time setup

Copy the original game JAR into the project using one of these paths:

```text
Mod_DragonBall\Dragonboy250 v4.0.jar
```

or:

```text
Mod_DragonBall\lib\Dragonboy250 v4.0.jar
```

The original JAR is gitignored and is never overwritten.

## Build and run the actual game

```bat
build-run.bat
```

It now:

1. compiles `ModHorizontalRuntime.java`;
2. converts that class back to the CLDC-era class-file version used by the game;
3. patches `nro.N.bt()` so the existing mod-menu entry opens the horizontal overlay;
4. patches `nro.aE.paint/key/touch` so the menu is drawn over the live game and receives input;
5. writes `dist\Dragonboy250-test.jar`;
6. launches that patched game.

The original JAR remains unchanged.

## Standalone preview

If you only want the old UI-only preview:

```bat
preview-run.bat
```

## Current limitations

Some horizontal menu cells still have command ID `-1` because their exact old dispatcher IDs have not yet been verified. Those cells render but intentionally do nothing until their original v4.0 action is mapped.

The already verified actions use the original `N.a(int,Object)` dispatcher, so feature logic is preserved rather than reimplemented.


## Compact layout update

The in-game overlay no longer fills the gameplay area.

It is now a compact bottom strip:
- top row: horizontally scrollable feature groups;
- second row: horizontally scrollable actions for the selected group;
- total overlay height: about 82 logical pixels;
- gameplay remains visible above the menu.

This matches the requested compact horizontal style more closely.
