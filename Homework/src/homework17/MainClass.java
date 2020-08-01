package homework17;

/**
 * 3. Большая задача:
 * a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
 * b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * c. Для хранения фруктов внутри коробки можете использовать ArrayList;
 * d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес
 * одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 * e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
 * которую подадут в compare в качестве параметра, true - если их веса равны, false в противном
 * случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую
 * коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
 * соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
 * которые были в этой коробке;
 * g. Не забываем про метод добавления фрукта в коробку.
 */

public class MainClass {

    public static void main(String[] args) {

        doTest();
    }

    public static void doTest() {

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();

        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());

        appleBox2.add(new Apple());

        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());

        System.out.println("AppleBox1 weight is: " + appleBox1.getWeight());
        System.out.println("AppleBox2 weight is: " + appleBox2.getWeight());
        System.out.println("OrangeBox1 weight is: " + orangeBox1.getWeight());

        System.out.println("Compare AppleBox1 and OrangeBox1: " + appleBox1.compare(orangeBox1));
        System.out.println("Compare AppleBox2 and OrangeBox1: " + appleBox2.compare(orangeBox1));

        appleBox1.moveAllTo(appleBox2);
        System.out.println("AppleBox1 weight is: " + appleBox1.getWeight());
        System.out.println("AppleBox2 weight is: " + appleBox2.getWeight());

    }
}
