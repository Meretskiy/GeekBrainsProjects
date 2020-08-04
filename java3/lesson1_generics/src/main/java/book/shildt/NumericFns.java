package book.shildt;

public class NumericFns<T extends Number> {

    private T num;

    public NumericFns(T num) {
        this.num = num;
    }

    public double reciprocal() {
        return 1 / num.doubleValue();
    }

    public double fraction() {
        return num.doubleValue() - num.intValue();
    }

    public boolean absEqual(NumericFns<?> ob) {
        if (Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue())) {
            return true;
        }
        return false;
    }
}
