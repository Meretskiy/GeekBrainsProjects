package lesson1.hw;

public class Human extends Participant implements Movable, Jumping{

    public Human(String name) {
        super(name);
        setMaxMove(Math.random()*1000 + 1000);
        setMaxJump(Math.random()*1 + 0.4);
    }

    @Override
    public void move() {
        System.out.printf("Human %s is moving ...\n", getName());
    }

    @Override
    public void jump() {
        System.out.printf("Human %s is jumping ...\n", getName());
    }
}
