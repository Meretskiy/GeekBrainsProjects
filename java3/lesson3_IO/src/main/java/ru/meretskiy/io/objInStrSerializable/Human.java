package ru.meretskiy.io.objInStrSerializable;

import java.io.Serializable;

public class Human implements Serializable {
    int humanField = 5;

    public Human() {
    }

    public Human(int humanField) {
        this.humanField = humanField;
    }
}
