package lesson1.hw;

public class Treadmill implements Trials{

    private double distance;

    public Treadmill() {
        distance = Math.random()*2500 + 100;
    }

    @Override
    public void info() {
        System.out.printf("Distance: %.0fm\n", distance);
    }

    @Override
    public boolean action(Participant n) {
        boolean isDone;
        if (n.getMaxMove() > distance) {
            isDone = true;
            System.out.printf("The participant %s ran a distance %.0fm!\n", n.getName(), distance);
        } else {
            isDone = false;
            System.out.printf("The participant %s did not run the distance %.0fm!\n", n.getName(), distance);
        }

        return isDone;
    }
}
