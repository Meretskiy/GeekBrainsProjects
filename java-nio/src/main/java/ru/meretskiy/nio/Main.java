package ru.meretskiy.nio;

import java.io.RandomAccessFile;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Main {
    public static void main(String[] args) throws Exception {
        RandomAccessFile src = new RandomAccessFile("test-nio1/1.txt", "rw");
        FileChannel srcChannel = src.getChannel();

        RandomAccessFile dst = new RandomAccessFile("test-nio1/2.txt", "rw");
        FileChannel dstChannel = dst.getChannel();

        long position = 0;
        long length = srcChannel.size();

        dstChannel.transferFrom(srcChannel, position, length);

//        DatagramChannel datagramChannel;
//        SocketChannel socketChannel;
//        ServerSocketChannel serverSocketChannel;
    }
}
