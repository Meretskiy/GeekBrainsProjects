public class Homework01 {

    //1
    public static void main(String[] args) {

        //2
        byte byteTest = 127;
        short shortTest = 32767;
        int intTest = 2147483647;
        long longTest = 2147483648L;
        float floatTest = 9.9F;
        double doubleTest = 99.99;
        char charTest = 'A';
        String stringTest = "Hello!";
        boolean booleanTest = true;

        //3
        System.out.println(calculation(1.0F,2.5F, 3.2F, 4.1F));

        //4
        System.out.println(checkSum(2, 10));

        //5
        System.out.println(checkPositive(0));

        //6
        System.out.println(checkNegative(-10));

        //7
        sayHello("Java");

        //8
        leapYear(2020);

    }
    //3
    public static float calculation(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    //4
    public static boolean checkSum(int num1, int num2) {
        int sum = num1 + num2;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else return false;
    }

    //5
    public static String checkPositive(int num) {
        return num >= 0 ? "This number is positive." : "This number is negative.";
    }

    //6
    public static boolean checkNegative(int num) {
        return num < 0 ? true : false;
    }

    //7
    public static void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    //8
    public static void leapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 ) {
            System.out.println(year + " - this year is a leap year!");
        } else if (year % 400 == 0) {
            System.out.println(year + " - this year is a leap year!");
        } else System.out.println(year + " - this year is not leap year!");
    }
}