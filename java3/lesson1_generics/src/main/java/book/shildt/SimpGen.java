package book.shildt;

public class SimpGen {

    public static void main(String[] args) {
        doTest();
    }

    public static void doTest() {

        TwoGen<Integer, String> tgObj = new TwoGen<>(88, "Generics");
        tgObj.showTypes();
        int v = tgObj.getObj1();
        System.out.println("Value : " + v);
        String str = tgObj.getObj2();
        System.out.println("Value : " + str);
    }
}
