package lesson6.lesson;

public class CombatGelicopter extends FlyMashine {

    private String name;
    private float fuel;
    private String weapon;

    public void fly() {
        System.out.println("CombatGelicopter!");
    }

    public void combat() {
        System.out.println("Attack");
    }
}
