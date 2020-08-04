package lesson6;

public class Main {

    public static void main(String[] args) {

        Animal an = new Animal("Smile", "White", 7);
        an.info();


        Cat cat1 = new Cat("Smile", "White", 7, 5);
        cat1.info();
        cat1.jump();
        System.out.println(cat1.equals(an));

        System.out.println("-----------------");

        Animal animal = new Cat("123", "321", 10, 10);
        animal.info();
        animal.jump();
        if (animal instanceof Cat) {

            ((Cat)animal).getWeight();
            System.out.println("Ohhhh!");
        }



    }
}
