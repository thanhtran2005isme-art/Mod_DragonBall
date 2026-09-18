package nro;

import java.io.*;

public class Message {
    public byte command;
    private ByteArrayOutputStream byteArrayOutputStream = null;
    private DataOutputStream write = null;
    private DataInputStream read = null;

    public Message() {
    }

    public Message(byte command) {
        this.command = command;
        this.byteArrayOutputStream = new ByteArrayOutputStream(1024);
        this.write = new DataOutputStream(this.byteArrayOutputStream);
    }

    public Message(byte command, byte[] var2) {
        this.command = command;
        ByteArrayInputStream array = new ByteArrayInputStream(var2);
        this.read = new DataInputStream(array);
    }

    public byte[] getData() {
        return this.byteArrayOutputStream.toByteArray();
    }

    public int readInt() throws IOException {
        return this.read.readInt();
    }

    public DataInputStream reader() {
        return this.read;
    }

    public DataOutputStream writer() {
        return this.write;
    }

    public void cleanup() {
        try {
            if (this.read != null) {
                this.read.close();
            }
            if (this.write != null) {
                this.write.close();
            }
        } catch (IOException exception) {
            ResLog.a(exception.getMessage());
        }

    }
}
