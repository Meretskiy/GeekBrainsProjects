package lesson1_OOP.lesson;

public abstract class AbstractUnit implements Unit {
    protected String name;

    public AbstractUnit(String name) {
        this.name = name;
    }

    @Override
    public void salute() {
        System.out.printf("%s[%s] is saluting ...\n", this.getClass().getCanonicalName(), name);
    }
}
