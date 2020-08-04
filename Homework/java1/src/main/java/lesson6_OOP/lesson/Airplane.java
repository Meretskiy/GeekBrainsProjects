package lesson6_OOP.lesson;

public class Airplane extends FlyMashine{

    private String name;
    private float fuel;

    public Airplane(String name) {
        super(name);
    }

    public Airplane() {
        super();
    }

    public void fly() {
        System.out.println("Airpline!");
    }
}
