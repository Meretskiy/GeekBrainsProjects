package lesson6_OOP.hw;

public class Dog extends Animal {

    public Dog(String name) {

        super(name);
        setMaxRunLength(Math.random() * 200 + 400);
        setMaxSwimLength(Math.random() * 10 + 10);
        setMaxJumpHeight(Math.random() * 0.5 + 0.3);
    }
}
