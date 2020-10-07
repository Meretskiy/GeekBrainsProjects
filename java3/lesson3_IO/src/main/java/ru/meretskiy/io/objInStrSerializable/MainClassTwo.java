package ru.meretskiy.io.objInStrSerializable;

import java.io.*;

public class MainClassTwo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Book book = new Book("Jungle Book Part I");
        StudentTwo sto = new StudentTwo(1, "Sam", book);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stud2.ser"));
        oos.writeObject(sto);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stud2.ser"));
        StudentTwo sti = (StudentTwo) ois.readObject();
        sti.info();
        ois.close();
    }
}
