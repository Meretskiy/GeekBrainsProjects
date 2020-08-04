package lesson1.lesson;

public class Soldier extends AbstractUnit implements CombatUnit {
    public Soldier(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(String.format("Soldier[%s] is moving ...", name));
    }

    @Override
    public void attack() {
        System.out.println(String.format("Soldier[%s] is attacking ...", name));
    }
}
