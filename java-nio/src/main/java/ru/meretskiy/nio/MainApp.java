package ru.meretskiy.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("test-nio1", "test-nio2");
        path = path.resolve("3.txt");
        System.out.println(Files.exists(path));
        System.out.println(path);
        System.out.println(path.getFileName().toString());
        System.out.println(path.getName(path.getNameCount() - 1));
        //path.toFile();

        Files.write(Paths.get("out.txt"), new byte[]{65, 66, 67}, StandardOpenOption.CREATE);

        FileMessage fm = new FileMessage(Paths.get("demo.txt"));
        System.out.println(Arrays.toString(fm.getData()));


    }
}
