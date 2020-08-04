package lesson3_Syntax;

import java.util.Date;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        String template = "Hello, world! My name is %s. I am %s years old";
        String template2 = "Hello, world! My name is %s. I am %d years old";

        doGreetings("Geekbrains", "10");
        doGreetings("Mike", "20");
        doGreetings(template, "Gaz", "25");
        System.out.println();
        doGreetings(template2, "Gaz", 26);
        System.out.println();

        Date date = new Date();
        float revenueValue = 181267.091980127214124F;
        float totalLosesValue = 617.0879126784F;

        String revenueTemplate = "Revenue of %1$td.%1$tm.%1$tY %nTotal revenue: %2$.3f %nTotal loses: %3$.3f";
        String revenueTemplate2 = "Revenue of XXXXXX %nTotal revenue: %.3f %nTotal loses: %.3f";

        doRevenue(revenueTemplate, date, revenueValue, totalLosesValue);

        printValue(1, 2, 3, 5, 6, 7);
    }

    static void printValue(int... numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    static void doRevenue(String template, Date date, float totalRevenue, float totalLoses) {
        System.out.printf(template, date, totalRevenue, totalLoses);
    }

    static void doRevenue(String template, float... params) {
        System.out.printf(template, params);
    }

    static void doGreetings(String name, String year) {
        System.out.println("Hello, World! My name is " + name + ". I'm " + year + " year old!");
    }

    static void doGreetings(String template, String name, String year) {
        System.out.printf(template, name, year);
    }

    static void doGreetings(String template, String name, int year) {
        System.out.printf(template, name, year);
    }

    static void demoArrayShift() {
        doArrayShift();
    }

    static void doArrayShift() {
        int[] numbers = new int[0];
        numbers = addValues(numbers);

        System.out.println("New array");
        printArray(numbers);

        int[] shiftedArray = shiftArray(numbers, 2);

        System.out.println("\nShifted array");
        printArray(shiftedArray);
    }

    static int[] addValues(int[] numbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add new value ...");
        boolean isAddNewValue;
        do {
            int value = scanner.nextInt();
            numbers = addValue(numbers, value);

            System.out.println("Do you want to add value? ...");
            isAddNewValue = scanner.nextBoolean();
        } while (isAddNewValue);
        return numbers;
    }

    static int[] addValue(int[] arr, int value) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = value;
        return newArr;
    }

    static int[] shiftArray(int[] arr, int shift) {
        int[] shifted = new int[arr.length];
        for (int i = shift; i < arr.length; i++) {
            shifted[i] = arr[i - shift];
        }
        return shifted;
    }

    static void printArray(int[] arr) {
        System.out.print("{ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.print("}");
    }

    static void printArray(double[] arr) {
        System.out.print("{ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.print("}");
    }

}