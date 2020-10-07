package ru.meretskiy.io.objInStrSerializable;

import java.io.*;

public class MainClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1o = new Student(1, "Sam");
        Student s2o = new Student(1, "Ais");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stud.ser"));
        oos.writeObject(s1o);
        oos.writeObject(s2o);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stud.ser"));
        Student s1i = (Student) ois.readObject();
        Student s2i = (Student) ois.readObject();
        s1i.info();
        s2i.info();
        ois.close();
    }
}
