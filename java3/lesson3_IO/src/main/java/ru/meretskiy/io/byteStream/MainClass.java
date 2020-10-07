package ru.meretskiy.io.byteStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainClass {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("1.txt")) {
            for (int i = 0; i < 20; i++) {
                out.write(65);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = "Test";
        byte[] bytes = str.getBytes();
        try (FileOutputStream out = new FileOutputStream("1.txt", false)) {
            for (int i = 0; i < 20; i++) {
                out.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
