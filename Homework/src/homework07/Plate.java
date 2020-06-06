package homework07;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int value) {
        if (value <= food) {
            food -= value;
            return true;
        }
        return false;
    }

    public void info() {
        System.out.println("Plate: " + food);
    }

    public void addFoodToPlate(int value) {
        food += value;
    }
}
