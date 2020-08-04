package lesson5;

public class Human {

    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human() {
    }

    void walk() {
        System.out.println(String.format("%s is walking", name));
    }

    void talk() {
        System.out.println(String.format("%s is talking", name));
    }

}
