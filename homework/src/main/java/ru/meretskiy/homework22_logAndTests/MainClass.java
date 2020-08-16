package ru.meretskiy.homework22_logAndTests;

/**
1. Написать метод, которому в качестве аргумента передается не пустой одномерный
 целочисленный массив. Метод должен вернуть новый массив, который получен путем
 вытаскивания из исходного массива элементов, идущих после последней четверки.
 Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо
  выбросить RuntimeException. Написать набор тестов для этого метода
   (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
2. Написать метод, который проверяет состав массива из чисел 1 и 4.
Если в нем нет хоть одной четверки или единицы, то метод вернет false;
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 */

import java.util.Arrays;

public class MainClass {

    public int[] splitArray(int[] arr, int splitValue) {
        if (arr.length == 0) {
            throw new RuntimeException("Array is empty");
        }
        int indexFirstElement = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == splitValue) {
                indexFirstElement = i + 1;
            }
        }
        if (indexFirstElement == -1) {
            throw new RuntimeException(String.format("There are no %s in the array.", splitValue));
        }
        return Arrays.copyOfRange(arr, indexFirstElement, arr.length);
    }

    public boolean isContainsOneOrFour(int[] arr, int containsValue1, int containsValue2) {
        for (int i : arr) {
            if (i == containsValue1 || i == containsValue2) {
                return true;
            }
        }
        return false;
    }
}
