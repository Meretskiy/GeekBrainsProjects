package ru.meretskiy.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class MainApp2 {
    public static void main(String[] args) throws Exception {
//        printFileIO();
//        printFileNIO();

        ByteBuffer buf = ByteBuffer.allocate(6);
        buf.put((byte) 65);
        buf.put((byte) 66);
        buf.put((byte) 67);
        buf.flip();
        System.out.println(buf.get());
        System.out.println(buf.get());
        System.out.println(buf.get());
//        System.out.println(buf.get());
        buf.rewind();
        System.out.println(buf.get());
    }

    private static void printFileIO() {
        int x = 0;
        try (InputStream in = new BufferedInputStream(new FileInputStream("test-nio1/1.txt"))) {
            while ((x = in.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFileNIO() {
        try (RandomAccessFile raf = new RandomAccessFile("test-nio1/1.txt", "rw")) {
            FileChannel channel = raf.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(4);

            int readed = channel.read(buf);
            while (readed != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char)buf.get());
                }
                buf.clear();
                readed = channel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
