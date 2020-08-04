package lesson1.manual;

public class Cat {
    private String name;
    private int age;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat: " + name;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age * 71;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cat another = (Cat) obj;
        return this.age == another.age && this.name.equals(another.name);
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 5);
        Cat cat2 = new Cat("Barsik", 5);
        System.out.println(cat1.toString());
        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());
        System.out.println(cat1.equals(cat2));
    }
}
