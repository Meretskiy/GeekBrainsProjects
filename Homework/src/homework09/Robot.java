package homework09;

public class Robot implements Participant{

    private String name;
    private double maxMove;
    private double maxJump;

    public Robot(String name) {
        this.name = name;
        maxMove = Math.random()*4000 + 2000;
        maxJump = Math.random()*2 + 1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getMaxMove() {
        return maxMove;
    }

    @Override
    public double getMaxJump() {
        return maxJump;
    }

    @Override
    public void move() {
        System.out.printf("Robot %s is moving ...\n", name);
    }

    @Override
    public void jump() {
        System.out.printf("Robot %s is jumping ...\n", name);
    }
}
