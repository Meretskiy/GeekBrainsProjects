package lesson1.lesson;

public class Archer extends AbstractUnit implements CombatUnit {
    public Archer(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(String.format("Archer[%s] is moving ...", name));
    }

    @Override
    public void attack() {
        System.out.println(String.format("Archer[%s] is attacking ...", name));
    }
}
