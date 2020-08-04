package lesson1_intro;

public class Homework01 {

    public static void main(String[] args) {
        byte numByte = 125;
        short numShort = 327;
        int numInt = 123321;
        long numLong = 100000000000L;
        float numFloat = 25.123f;
        double numDouble = 123.1233;
        char letter = 'F';
        boolean bool = true;
        float a, b, c, d;
        a = b = c = d = 12.5f;
        String name = "Java";
        int x = -10;
        int y = 18;
        int year = 2020;
        System.out.println(computation(a, b, c, d));
        System.out.println(compareAmount(x, y));
        positiveCheck(x);
        System.out.println(negativeCheck(x));
        hello(name);
        leapYear(year);
    }

    public static float computation(float a, float b, float c, float d) {
        return (a * (b + (c / d)));
    }

    public static boolean compareAmount(int a, int b) {
        int c = a + b;
        if (c > 10 && c < 20) {
            return true;
        } else return false;
    }

    public static void positiveCheck(int a) {
        if (a < 0) {
            System.out.println("Отрицательное число");
        } else System.out.println("Положительное число");
    }

    public static boolean negativeCheck(int a) {
        if (a < 0) {
            return true;
        } else return false;

    }

    public static void hello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void leapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + " Год високосный!");
        }
        if (year % 400 == 0) {
            System.out.println(year + " Год високосный!");
        }
    }
}
