package ru.meretskiy.nio;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileMessage implements Serializable {
    private static final long serialVersionUID = 214098383244814697L;

    private String filename;
    private long length;
    private byte[] data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFilename() {
        return filename;
    }

    public long getLength() {
        return length;
    }

    public byte[] getData() {
        return data;
    }

    public FileMessage(Path path) {
        if (Files.isDirectory(path)) {
            throw new RuntimeException("This Directory!!!");
        }
        try {
            this.filename = path.getFileName().toString();
            this.length = Files.size(path);
            this.data = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException("Unable to create file message from: " + path.toString());
        }
    }
}
