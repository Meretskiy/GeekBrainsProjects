package homework06;

public class Dog extends Animal {

    public Dog(String name) {

        super(name);
        setMaxRunLength(Math.random() * 200 + 400);
        setMaxSwimLength(Math.random() * 10 + 10);
        setMaxJumpHeight(Math.random() * 0.5 + 0.3);
    }

    public Dog(String name, double maxRunLength,
               double maxSwimLength, double maxJumpHeight) {

        super(name, maxRunLength, maxSwimLength, maxJumpHeight);
    }
}