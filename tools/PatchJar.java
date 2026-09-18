import java.io.*;
import java.util.Enumeration;
import java.util.jar.*;
import jdk.internal.org.objectweb.asm.*;

public final class PatchJar {
    private static final String RUNTIME = "nro/ModHorizontalRuntime";

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: PatchJar <input.jar> <runtime.class> <output.jar>");
            System.exit(2);
        }

        File in = new File(args[0]);
        File runtimeClass = new File(args[1]);
        File out = new File(args[2]);

        if (!in.isFile()) throw new FileNotFoundException(in.toString());
        if (!runtimeClass.isFile()) throw new FileNotFoundException(runtimeClass.toString());
        if (out.getParentFile() != null) out.getParentFile().mkdirs();

        byte[] runtime = normalizeToJ2ME(readAll(new FileInputStream(runtimeClass)));
        boolean patchedN = false;
        boolean patchedCanvas = false;

        JarFile jf = new JarFile(in);
        Manifest mf = jf.getManifest();
        JarOutputStream jos = mf == null
                ? new JarOutputStream(new FileOutputStream(out))
                : new JarOutputStream(new FileOutputStream(out), mf);

        try {
            Enumeration<JarEntry> en = jf.entries();

            while (en.hasMoreElements()) {
                JarEntry e = en.nextElement();
                String name = e.getName();

                if (name.equalsIgnoreCase("META-INF/MANIFEST.MF")) continue;
                if (name.equals(RUNTIME + ".class")) continue;

                InputStream is = jf.getInputStream(e);
                byte[] data = readAll(is);
                is.close();

                if (name.equals("nro/N.class")) {
                    data = patchN(data);
                    patchedN = true;
                } else if (name.equals("nro/aE.class")) {
                    data = patchCanvas(data);
                    patchedCanvas = true;
                }

                JarEntry ne = new JarEntry(name);
                ne.setTime(e.getTime());
                jos.putNextEntry(ne);
                if (!e.isDirectory()) jos.write(data);
                jos.closeEntry();
            }

            JarEntry re = new JarEntry(RUNTIME + ".class");
            jos.putNextEntry(re);
            jos.write(runtime);
            jos.closeEntry();
        } finally {
            try { jos.close(); } catch (Exception ignored) {}
            try { jf.close(); } catch (Exception ignored) {}
        }

        if (!patchedN || !patchedCanvas) {
            out.delete();
            throw new IllegalStateException("Required classes not found. N=" + patchedN + " aE=" + patchedCanvas);
        }

        System.out.println("[patch] N.bt() now opens the horizontal menu overlay");
        System.out.println("[patch] aE.paint/key/touch now feed the horizontal menu");
        System.out.println("[patch] Output: " + out.getAbsolutePath());
    }

    private static byte[] patchN(byte[] input) {
        final boolean[] found = new boolean[1];
        ClassReader cr = new ClassReader(input);
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);

        ClassVisitor cv = new ClassVisitor(Opcodes.ASM8, cw) {
            public MethodVisitor visitMethod(int access, String name, String desc, String sig, String[] ex) {
                if (name.equals("bt") && desc.equals("()V")) {
                    found[0] = true;
                    return null;
                }
                return super.visitMethod(access, name, desc, sig, ex);
            }

            public void visitEnd() {
                MethodVisitor mv = super.visitMethod(Opcodes.ACC_PUBLIC, "bt", "()V", null, null);
                mv.visitCode();
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, RUNTIME, "open", "()V", false);
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(0, 1);
                mv.visitEnd();
                super.visitEnd();
            }
        };

        cr.accept(cv, 0);
        if (!found[0]) throw new IllegalStateException("N.bt() not found");
        return cw.toByteArray();
    }

    private static byte[] patchCanvas(byte[] input) {
        final boolean[] paint = new boolean[1];
        final boolean[] key = new boolean[1];

        ClassReader cr = new ClassReader(input);
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);

        ClassVisitor cv = new ClassVisitor(Opcodes.ASM8, cw) {
            public MethodVisitor visitMethod(int access, String name, String desc, String sig, String[] ex) {
                MethodVisitor base = super.visitMethod(access, name, desc, sig, ex);

                if (name.equals("paint") && desc.equals("(Ljavax/microedition/lcdui/Graphics;)V")) {
                    paint[0] = true;
                    return new MethodVisitor(Opcodes.ASM8, base) {
                        public void visitInsn(int opcode) {
                            if (opcode == Opcodes.RETURN) {
                                super.visitVarInsn(Opcodes.ALOAD, 1);
                                super.visitMethodInsn(
                                        Opcodes.INVOKESTATIC,
                                        RUNTIME,
                                        "paint",
                                        "(Ljavax/microedition/lcdui/Graphics;)V",
                                        false
                                );
                            }
                            super.visitInsn(opcode);
                        }
                    };
                }

                if (name.equals("keyPressed") && desc.equals("(I)V")) {
                    key[0] = true;
                    return new MethodVisitor(Opcodes.ASM8, base) {
                        public void visitCode() {
                            super.visitCode();
                            Label original = new Label();
                            super.visitVarInsn(Opcodes.ILOAD, 1);
                            super.visitMethodInsn(Opcodes.INVOKESTATIC, RUNTIME, "onKeyPressed", "(I)Z", false);
                            super.visitJumpInsn(Opcodes.IFEQ, original);
                            super.visitInsn(Opcodes.RETURN);
                            super.visitLabel(original);
                        }
                    };
                }

                if (name.equals("e") && desc.equals("(II)V")) {
                    return new MethodVisitor(Opcodes.ASM8, base) {
                        public void visitCode() {
                            super.visitCode();
                            Label original = new Label();
                            super.visitVarInsn(Opcodes.ILOAD, 1);
                            super.visitVarInsn(Opcodes.ILOAD, 2);
                            super.visitMethodInsn(Opcodes.INVOKESTATIC, RUNTIME, "onPointerPressed", "(II)Z", false);
                            super.visitJumpInsn(Opcodes.IFEQ, original);
                            super.visitInsn(Opcodes.RETURN);
                            super.visitLabel(original);
                        }
                    };
                }

                if ((name.equals("d") || name.equals("f")) && desc.equals("(II)V")) {
                    return new MethodVisitor(Opcodes.ASM8, base) {
                        public void visitCode() {
                            super.visitCode();
                            Label original = new Label();
                            super.visitMethodInsn(Opcodes.INVOKESTATIC, RUNTIME, "consumePointer", "()Z", false);
                            super.visitJumpInsn(Opcodes.IFEQ, original);
                            super.visitInsn(Opcodes.RETURN);
                            super.visitLabel(original);
                        }
                    };
                }

                return base;
            }
        };

        cr.accept(cv, 0);

        if (!paint[0] || !key[0]) {
            throw new IllegalStateException("aE paint/keyPressed not found");
        }

        return cw.toByteArray();
    }

    private static byte[] normalizeToJ2ME(byte[] input) {
        ClassReader cr = new ClassReader(input);
        ClassWriter cw = new ClassWriter(0);

        ClassVisitor cv = new ClassVisitor(Opcodes.ASM8, cw) {
            public void visit(int version, int access, String name, String sig, String superName, String[] interfaces) {
                super.visit(Opcodes.V1_1, access, name, sig, superName, interfaces);
            }

            public MethodVisitor visitMethod(int access, String name, String desc, String sig, String[] ex) {
                MethodVisitor mv = super.visitMethod(access, name, desc, sig, ex);
                return new MethodVisitor(Opcodes.ASM8, mv) {
                    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
                    }
                };
            }
        };

        cr.accept(cv, ClassReader.SKIP_FRAMES);
        return cw.toByteArray();
    }

    private static byte[] readAll(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[16384];
        int n;

        while ((n = in.read(buf)) >= 0) {
            out.write(buf, 0, n);
        }

        return out.toByteArray();
    }
}
