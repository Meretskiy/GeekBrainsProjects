package homework09;

public class Robot extends Participant implements Movable, Jumping{

    public Robot(String name) {
        super(name);
        setMaxMove(Math.random()*4000 + 2000);
        setMaxJump(Math.random()*2 + 1);
    }

    @Override
    public void move() {
        System.out.printf("Robot %s is moving ...\n", getName());
    }

    @Override
    public void jump() {
        System.out.printf("Robot %s is jumping ...\n", getName());
    }
}
