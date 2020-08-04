package lesson2_Exceptions.lesson;

public class Application {

    public static void main(String[] a) throws CustomCheckedException {
        try {
            checkNullpointer(null);
        } catch (CustomUncheckedException e) {
            System.out.println(e.getMessage());
        }

        int val = 123;
        int divider = 0;
        try {
            checkDivisionByZero(divider);
            int result = val / divider;
            System.out.println(result);
        } catch (DivisionByZeroException e) {
            System.out.println(String.format("Attemption of division by zero: [%s / %s]", val, divider));
        } catch (ArithmeticException e) {
            System.out.println(String.format("Attemption of division by zero: [%s / %s]", val, divider));
        } finally {
            System.out.println("Final");
            //close something
        }

        int val2 = 46724;
        int multiplier = 10;
        System.out.println(val2 * multiplier);
    }

    static void checkNullpointer(Runnable runnable) {
        if (runnable == null) {
            throw new CustomUncheckedException("Object must not be null");
        }
    }

    static void checkDivisionByZero(int divider) throws DivisionByZeroException {
        if (divider == 0) {
            throw new DivisionByZeroException("Division by zero");
        }
    }

    static void doDemoCheckException() throws CustomCheckedException {
        throw new CustomCheckedException("Demo checked exception");
    }
}
