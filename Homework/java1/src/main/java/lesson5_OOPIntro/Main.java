package lesson5_OOPIntro;

public class Main {

    public static void main(String[] args) {

        Human petya = new Human();
        petya.name = "Petya";
        petya.talk();
        petya.walk();

        Human maswa = new Human();
        maswa.name = "Masha";
        maswa.walk();
        maswa.talk();

        Cat smile = new Cat("Smile","White", 7);
        smile.Meow();
        smile.getName();
    }
}
