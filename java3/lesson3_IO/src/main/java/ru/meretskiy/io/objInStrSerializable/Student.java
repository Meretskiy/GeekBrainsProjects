package ru.meretskiy.io.objInStrSerializable;

import java.io.Serializable;

public class Student extends Human implements Serializable {
    private static final long serialVersionUID = 2687582694009063932L;

    private int id;
    private String name;

    public Student() {
        super(1);
        System.out.println("!!!!!");
    }

    public Student(int id, String name) {
        super(1);
        this.id = id;
        this.name = name;
        System.out.println("!!!!!");
    }

    public void info() {
        System.out.println(id + " " + name + " " + humanField);
    }
}
