package ru.meretskiy.homework06_OOP;

public class Cat extends Animal {

    public Cat(String name) {

        super(name);
        setMaxRunLength(Math.random() * 200 + 100);
        setMaxSwimLength(0);
        setMaxJumpHeight(Math.random() * 1.5 + 1);
    }

    public Cat(String name, double maxRunLength,
               double maxSwimLength, double maxJumpHeight) {

        super(name, maxRunLength, maxSwimLength, maxJumpHeight);
    }


}
