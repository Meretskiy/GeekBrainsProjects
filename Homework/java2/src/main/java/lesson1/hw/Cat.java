package lesson1.hw;

public class Cat extends Participant implements Movable, Jumping{

    public Cat(String name) {
        super(name);
        setMaxMove(Math.random()*1000 + 500);
        setMaxJump(Math.random()*2 + 0.5);
    }

    @Override
    public void move() {
        System.out.printf("Cat %s is moving ...\n", getName());
    }

    @Override
    public void jump() {
        System.out.printf("Cat %s is jumping ...\n", getName());
    }
}
