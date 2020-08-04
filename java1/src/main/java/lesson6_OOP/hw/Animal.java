package lesson6_OOP.hw;

public class Animal {

    private final String name;
    private double maxRunLength;
    private double maxSwimLength;
    private double maxJumpHeight;
    public static double runLength;
    public static double swimLength;
    public static double jumpHeight;
    public int countPoints = 0;

    public Animal(String name) {

        this.name = name;
    }

    public void setMaxRunLength(double maxRunLength) {

        this.maxRunLength = maxRunLength;
    }

    public void setMaxSwimLength(double maxSwimLength) {

        this.maxSwimLength = maxSwimLength;
    }

    public void setMaxJumpHeight(double maxJumpHeight) {

        this.maxJumpHeight = maxJumpHeight;
    }

    public void run(double runLength) {

        if (maxRunLength > runLength) {

            System.out.println(name + " was able to run a distance!");
            countPoints++;

        } else {

            System.out.println(name + " could not run that distance!");
        }
    }

    public void swim(double swimLength) {

        if (maxSwimLength > swimLength) {

            System.out.println(name + " was able to swim this distance!");
            countPoints++;

        } else {

            System.out.println(name + " could not swim that distance!");
        }
    }

    public void jump(double jumpHeight) {

        if (maxJumpHeight > jumpHeight) {

            System.out.println(name + " was able to jump over an barrier!");
            countPoints++;

        } else {

            System.out.println(name + " could not jump the barrier!");
        }
    }

    public void startCompetition() {

        info();
        run(runLength);
        swim(swimLength);
        jump(jumpHeight);
        System.out.println("Points: " + countPoints);

        if (countPoints < 2) {

            System.out.println(name + " is out of competition...");

        } else {

            System.out.println(name + " went to the next round! Congratulations!");
        }

        System.out.println("-------------------------------------");
    }

    public void info() {

        System.out.format("%s\nmax run length %.0f\nmax swim length %.1f\nmax jump " +
                "height %.1f\n", name, maxRunLength, maxSwimLength, maxJumpHeight);
    }
}
