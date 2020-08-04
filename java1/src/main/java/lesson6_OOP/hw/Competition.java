package lesson6_OOP.hw;

public class Competition {

    public static void main(String[] args) {

        setCompetitionParameters();

        Cat cat1 = new Cat("Smile");
        cat1.startCompetition();

        Cat cat2 = new Cat("Tom");
        cat2.startCompetition();

        Dog dog1 = new Dog("Tobik");
        dog1.startCompetition();

        Dog dog2 = new Dog("Akella");
        dog2.startCompetition();

    }

    public static void setCompetitionParameters() {

        Animal.runLength = 180;
        Animal.swimLength = 14;
        Animal.jumpHeight = 1.1;
    }
}
