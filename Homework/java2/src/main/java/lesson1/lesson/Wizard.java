package lesson1.lesson;

public class Wizard extends AbstractUnit implements CombatUnit {
    public Wizard(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(String.format("Wizard[%s] is moving ...", name));
    }

    @Override
    public void attack() {
        System.out.println(String.format("Wizard[%s] is attacking ...", name));
    }
}
