package lesson6;

public class Cat extends Animal {

    private int weight;

    public Cat(String name, String color, int age, int weight) {

        super(name, color, age);
        this.weight = weight;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("suks");
    }

    @Override
    public void jump() {
        System.out.println(name + " super jump!");
    }

    public void getWeight() {
        System.out.println("Weight is: " + weight);
    }
}
