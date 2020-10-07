package ru.meretskiy.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        File file = new File("test-io/1.txt");
        System.out.println(file.length());
        System.out.println(file.isDirectory());

        File file1 = new File("test-io/2.txt");
        System.out.println(file1.length());
        System.out.println(file1.exists());
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file1.length());
        System.out.println(file1.exists());
        System.out.println(file1.getParent());

        File file2 = new File("test-io");
        String[] str = file2.list();
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        String[] str1 = file2.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("1");
            }
        });
        System.out.println(Arrays.toString(str1));

        File file3 = new File("test-io/2");
        file3.mkdir();
        file3.renameTo(new File("test-io/3"));

        //file3.toPath();


    }
}
