package book.shildt;

public class BoundsDemo {

    public static void main(String[] args) {
        doTest2();
    }

    public static void doTest1() {
        NumericFns<Integer> iOb = new NumericFns<>(5);
        System.out.println("Reciprocal : " + iOb.reciprocal());
        System.out.println("Fractional part : " + iOb.fraction());
        System.out.println();

        NumericFns<Double> dOb = new NumericFns<>(5.25);
        System.out.println("Reciprocal : " + dOb.reciprocal());
        System.out.println("Fractional part : " + dOb.fraction());
    }

    public static void doTest2() {
        NumericFns<Integer> iOb = new NumericFns<>(6);
        NumericFns<Double> dOb = new NumericFns<>(-6.0);
        NumericFns<Long> lOb = new NumericFns<>(5L);

        System.out.println("Compare iOb and dOb");
        if (iOb.absEqual(dOb)) {
            System.out.println("abs values match");
        } else {
            System.out.println("abs values do not match");
        }

        System.out.println("Compare iOb and lOb");
        if (iOb.absEqual(lOb)) {
            System.out.println("abs values match");
        } else {
            System.out.println("abs values do not match");
        }
    }
}
