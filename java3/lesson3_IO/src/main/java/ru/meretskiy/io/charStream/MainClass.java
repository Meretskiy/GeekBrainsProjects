package ru.meretskiy.io.charStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainClass {
    public static void main(String[] args) {
        try (InputStreamReader isr =
                     new InputStreamReader(new FileInputStream("1.txt"), StandardCharsets.UTF_8)) {
            int x;
            while ((x = isr.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
