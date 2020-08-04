package lesson7_OOP.hw;

public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Smile", 20), new Cat("Barsik", 40), new Cat("Pudge", 60)};

        Plate plate = new Plate(100);

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cats[i].getSatiety();
        }

        plate.addFoodToPlate(50);
        cats[2].eat(plate);
        cats[2].getSatiety();
    }
}
