package ru.meretskiy.homework09;

public class Human implements Participant{

    private String name;
    private double maxMove;
    private double maxJump;

    public Human(String name) {
        this.name = name;
        maxMove = Math.random()*1000 + 1000;
        maxJump = Math.random()*1 + 0.4;
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
        System.out.printf("Human %s is moving ...\n", name);
    }

    @Override
    public void jump() {
        System.out.printf("Human %s is jumping ...\n", name);
    }
}
