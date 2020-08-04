package book.shildt;

public class GenDemo {

    public static void main(String[] args) {
        doTest();
    }

    public static void doTest() {

        Gen<Integer> iOb = new Gen<>(88);
        iOb.showType();
        int v = iOb.getOb();
        System.out.println("Value: " + v);
        System.out.println();

        Gen<String> strOb = new Gen<>("Text message");
        strOb.showType();
        String str = strOb.getOb();
        System.out.println("Value: " + str);

    }
}
