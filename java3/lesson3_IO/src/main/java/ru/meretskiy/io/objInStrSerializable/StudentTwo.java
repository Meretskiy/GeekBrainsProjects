package ru.meretskiy.io.objInStrSerializable;

import java.io.Serializable;

public class StudentTwo implements Serializable {
    int id;
    String name;
    Book book;
    //transient Book book;

    public StudentTwo(int id, String name, Book book) {
        this.id = id;
        this.name = name;
        this.book = book;
        System.out.println("!!!!!");
    }

    public void info() {
        System.out.println(id + " " + name + " " + book);
    }
}
