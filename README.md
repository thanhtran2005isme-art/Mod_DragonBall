# Dragonboy250 v4.0 — recovered reverse-engineering package

This package was generated from the uploaded `Dragonboy250 v4.0.jar`.

## What was recovered

- 225 Java/J2ME classes.
- 504 non-class resources.
- Complete `javap -p -c -s -constants` bytecode disassembly for all 225 classes.
- Annotated bytecode with decoded obfuscated strings inserted next to their call sites.
- 5,059 / 5,059 detected encrypted string calls decoded successfully.
- 2,746 unique decoded strings.
- Class index and feature-focused string index.
- Original resources and original JAR for reference.
- The string-decoder table and extraction tools used in the recovery.

## Important limitation

This JAR was obfuscated. Original class/method/local-variable names and source formatting were removed before distribution, and no useful source/debug metadata is present. Therefore an *identical copy of the original Java project* cannot be reconstructed from the JAR alone.

The `annotated_bytecode/` folder is the most faithful recovered program logic: it preserves every JVM instruction while adding the decrypted strings at their exact call sites. This is safer than pretending a decompiler can restore names that no longer exist.

## Where to start when adding features

1. Read `FEATURE_MAP.md`.
2. Search `analysis/feature_strings.csv` for the feature or command name.
3. Open the matching class under `annotated_bytecode/`.
4. For mod commands/configuration, inspect `h.txt` first.
5. For menu actions, inspect `N.txt`.
6. For packet/game data handling, inspect `aJ.txt`.
7. For gameplay rendering/input/state, inspect `aL.txt`.
8. For Xmap, inspect `i.txt` and `dp.txt`.

## Package layout

- `annotated_bytecode/` — full bytecode with decrypted string annotations.
- `bytecode/` — raw full bytecode disassembly.
- `analysis/decoded_strings.csv` — every decoded string call with class, method and bytecode PC.
- `analysis/decoded_strings_unique.txt` — unique decoded strings.
- `analysis/feature_strings.csv` — filtered strings relevant to Auto/Xmap/Boss/Skill/Item/Quest/etc.
- `analysis/class_index.csv` — class declarations and rough member/string counts.
- `analysis/resource_manifest.csv` — all recovered resources.
- `resources/` — original images/data/META-INF/etc., excluding `.class` files.
- `tools/` — string extraction/recovery utilities.
- `Dragonboy250 v4.0-original.jar` — unchanged uploaded JAR.

## Rebuilding

Because the distributed code is obfuscated and only J2ME APIs are referenced, a clean rebuild as maintainable Java source normally requires one of two approaches:

- use a Java bytecode decompiler locally, then repair compiler errors and map obfuscated symbols; or
- use a clean DragonBoy J2ME source baseline and port the recovered v4.0 mod behavior into named classes.

For adding one or several features, patching/rebuilding targeted classes is usually much faster than renaming and reconstructing all 225 classes first.
