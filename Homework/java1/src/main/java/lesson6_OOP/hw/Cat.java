package lesson6_OOP.hw;

public class Cat extends Animal {

    public Cat(String name) {

        super(name);
        setMaxRunLength(Math.random() * 200 + 100);
        setMaxSwimLength(0);
        setMaxJumpHeight(Math.random() * 1.5 + 1);
    }


}
