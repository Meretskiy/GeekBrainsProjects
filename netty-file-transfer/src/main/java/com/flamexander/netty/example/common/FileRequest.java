package com.flamexander.netty.example.common;

/*
    Серелизуемый класс с именем файла, по которому мы понимаем что клиент
    от нас хочет.
 */
public class FileRequest extends AbstractMessage {
    private String filename;

    public String getFilename() {
        return filename;
    }

    public FileRequest(String filename) {
        this.filename = filename;
    }
}
