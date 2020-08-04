package ru.meretskiy.manual;

import java.io.*;

public class StreamFileDemo {

    public static void main(String[] args) {

        //byteOutInFile();

        try (OutputStream out =
                     new BufferedOutputStream(new FileOutputStream("demoFile2.txt"))) {
            for (int i = 0; i < 1000; i++) {
                out.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream in =
                new BufferedInputStream(new FileInputStream("demoFile2.txt"))) {
            int x;
            while ((x = in.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void byteOutInFile() {
        byte[] outData = "Java ".getBytes();
        try (FileOutputStream out = new FileOutputStream("demoFile.txt", true)) {
            out.write(outData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
