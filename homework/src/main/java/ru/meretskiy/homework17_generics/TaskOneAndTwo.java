package ru.meretskiy.homework17_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. Написать метод, который меняет два элемента массива местами.
 * (массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 */

public class TaskOneAndTwo {

    public static void main(String[] args) {

        doTaskOneTest();
        doTaskTwoTest();
    }

    public static void doTaskOneTest() {

        Integer[] iArray = {1, 2, 3, 4, 5};
        swapElementsInArray(iArray, 2, 3);
        System.out.println(Arrays.toString(iArray));

        String[] strArray = {"A", "B", "C", "D", "E"};
        swapElementsInArray(strArray, 0, 4);
        System.out.println(Arrays.toString(strArray));
    }

    public static <T> void swapElementsInArray(T array[], int indexOne, int indexTwo) {

        try {
            T tmp = array[indexOne];
            array[indexOne] = array[indexTwo];
            array[indexTwo] = tmp;
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println(exc);
        }
    }

    public static void doTaskTwoTest() {

        Integer[] iArray = {1, 2, 3, 4, 5};
        System.out.println(transformArrayToArrayList(iArray));

        String[] strArray = {"A", "B", "C", "D", "E"};
        System.out.println(transformArrayToArrayList(strArray));
    }

    public static <T> List<T> transformArrayToArrayList(T[] array) {

        return new ArrayList<>(Arrays.asList(array));
    }
}
