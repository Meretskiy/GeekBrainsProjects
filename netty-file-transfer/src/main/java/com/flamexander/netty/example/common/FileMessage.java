package com.flamexander.netty.example.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/*
    Посылка с данными файла. Должно быть имя и данные. Возможно создавать по указанному пути
 */
public class FileMessage extends AbstractMessage {
    private String filename;
    private byte[] data;

    public String getFilename() {
        return filename;
    }

    public byte[] getData() {
        return data;
    }

    public FileMessage(Path path) throws IOException {
        filename = path.getFileName().toString(); //из пути выдергиваем имя файла
        //readAllBytes использовать только для заведомо маленьких файлов, он все подгрузит в оперативку
        data = Files.readAllBytes(path);//в данные мы заливаем байтовый массив со всеми байтами файла по данному пути
    }
}
