package homework09;

public class Cat implements Participant{

    private String name;
    private double maxMove;
    private double maxJump;

    public Cat(String name) {
        this.name = name;
        maxMove = Math.random()*1000 + 500;
        maxJump = Math.random()*2 + 0.5;
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
        System.out.printf("Cat %s is moving ...\n", name);
    }

    @Override
    public void jump() {
        System.out.printf("Cat %s is jumping ...\n", name);
    }
}
