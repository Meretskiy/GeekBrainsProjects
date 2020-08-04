package lesson5_OOPIntro;

public class CatDemo {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Barsik", "Black", 7);

        cat1.Meow();

        cat1.setName("Catzilla");
        System.out.println(cat1.getName());
    }
}
