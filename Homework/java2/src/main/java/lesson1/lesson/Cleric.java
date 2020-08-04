package lesson1.lesson;

public class Cleric extends AbstractUnit implements Healer {
    public Cleric(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.printf("Cleric[%s] is moving ...\n", name);
    }

    public void heal() {
        System.out.printf("Cleric[%s] is healing ...\n", name);
    }
}
