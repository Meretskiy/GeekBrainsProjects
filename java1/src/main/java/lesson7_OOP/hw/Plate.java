package lesson7_OOP.hw;

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
