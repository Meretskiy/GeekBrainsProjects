package homework09;

public abstract class Participant {
    private String name;
    private double maxMove;
    private double maxJump;

    public Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMaxMove(double maxMove) {
        this.maxMove = maxMove;
    }

    public double getMaxMove() {
        return maxMove;
    }

    public void setMaxJump(double maxJump) {
        this.maxJump = maxJump;
    }

    public double getMaxJump() {
        return maxJump;
    }

    public void info() {
        System.out.printf("Name is: %s, max move distance: %.0fm, " +
                "max jump height: %.2fm\n",name, maxMove, maxJump);
    }
}
