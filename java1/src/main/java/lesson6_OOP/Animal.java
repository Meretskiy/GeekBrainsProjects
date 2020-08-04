package lesson6_OOP;

public class Animal {

    protected String name;
    protected String color;
    protected int age;

    public Animal(String name, String color, int age) {

        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void info() {

        System.out.println(String.format("Name: %s color: %s age: %s",
                name, color, age));
    }

    public void jump() {

        System.out.println(name + " jump!");
    }
}
