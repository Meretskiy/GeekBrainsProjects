package lesson8.lesson.prev;

public class Static {
    public static void main(String[] args) {
        ClassWithStatic c1 = new ClassWithStatic(123);
        ClassWithStatic c2 = new ClassWithStatic(1255);

        System.out.println(ClassWithStatic.size);
        ClassWithStatic.size = 1002;
        c1.size = 1030;

        System.out.println(ClassWithStatic.size);
        System.out.println(c1.size);
        System.out.println(c2.size);

        Static aStatic = new Static();
        aStatic.nonStaticMethod();

        // Невозможно вызвать метод объекта из статического контекста (без привязки к конкретному объекту)
//        nonStaticMethod();

        TwoLinkedList twoLinkedList = new TwoLinkedList();
        TwoLinkedList.Node node = new TwoLinkedList.Node("val");
    }

    public void nonStaticMethod() {

    }
}
