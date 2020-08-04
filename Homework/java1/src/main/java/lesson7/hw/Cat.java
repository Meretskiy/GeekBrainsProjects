package lesson7.hw;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public void eat(Plate plate) {
        if (!satiety) {
            if (plate.decreaseFood(appetite)) {
                satiety = true;
            }
        }
    }

    public void getSatiety() {
        System.out.println(String.format("%s satiety is %s", name, satiety));
    }
}
