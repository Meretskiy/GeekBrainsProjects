package homework06;

public abstract class Animal {

    private final String name;
    private double maxRunLength;
    private double maxSwimLength;
    private double maxJumpHeight;
    protected static double runLength;
    protected static double swimLength;
    protected static double jumpHeight;

    public Animal(String name) {

        this.name = name;
    }

    public Animal(String name, double maxRunLength, double maxSwimLength,
                  double maxJumpHeight) {

        this.name = name;
        this.maxRunLength = maxRunLength;
        this.maxSwimLength = maxSwimLength;
        this.maxJumpHeight = maxJumpHeight;
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

        } else {

            System.out.println(name + " could not run that distance!");
        }
    }

    public void swim(double swimLength) {

        if (maxSwimLength > swimLength) {

            System.out.println(name + " was able to swim this distance!");

        } else {

            System.out.println(name + " could not swim that distance!");
        }
    }

    public void jump(double jumpHeight) {

        if (maxJumpHeight > jumpHeight) {

            System.out.println(name + " was able to jump over an barrier!");

        } else {

            System.out.println(name + " could not jump the barrier!");
        }
    }

    public void getInfo() {

        System.out.format("%s\nmax run length %.0f\nmax swim length %.1f\nmax jump " +
                "height %.1f\n", name, maxRunLength, maxSwimLength, maxJumpHeight);
    }
}
