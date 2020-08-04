package lesson5_OOPIntro;

public class Cat {

    private String name;
    private String color;
    private int age;

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void Meow() {

        System.out.printf("Meow, my name %s, my color is %s, %s ages." +
                "\n",name, color, age);
    }

    public Cat(String name, String color, int age) {

        this.name = name;
        this.color = color;
        this.age = age;
    }
}
