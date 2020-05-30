package homework06;

public class MainClass {

    public static void main(String[] args) {

        setTestParameters();
        startTest();
    }

    public static void setTestParameters() {

        Animal.runLength = 180;
        Animal.swimLength = 14;
        Animal.jumpHeight = 1.1;
    }

    public static void startTest() {

        Cat cat1 = new Cat("Smile");
        cat1.getInfo();
        cat1.run(Animal.runLength);
        cat1.swim(Animal.swimLength);
        cat1.jump(Animal.jumpHeight);
        System.out.println("-------------------------------------");

        Cat cat2 = new Cat("Tom");
        cat2.getInfo();
        cat2.run(Animal.runLength);
        cat2.swim(Animal.swimLength);
        cat2.jump(Animal.jumpHeight);
        System.out.println("-------------------------------------");

        Cat cat3 = new Cat("Joker", 500,
                12, 2);
        cat3.getInfo();
        cat3.run(400);
        cat3.swim(10);
        cat3.jump(1.5);
        System.out.println("-------------------------------------");

        Dog dog1 = new Dog("Tobik");
        dog1.getInfo();
        dog1.run(Animal.runLength);
        dog1.swim(Animal.swimLength);
        dog1.jump(Animal.jumpHeight);
        System.out.println("-------------------------------------");

        Dog dog2 = new Dog("Akella");
        dog2.getInfo();
        dog2.run(Animal.runLength);
        dog2.swim(Animal.swimLength);
        dog2.jump(Animal.jumpHeight);
        System.out.println("-------------------------------------");
    }
}
