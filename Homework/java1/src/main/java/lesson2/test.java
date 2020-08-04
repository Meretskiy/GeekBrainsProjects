package lesson2;

import java.util.Arrays;

public class test {

    public static void main (String [] args){
        int a[]= {1,2,3,4,5,6,7,8,9,10};
        moveRight(a,-1);
        System.out.println(Arrays.toString(a));

    }

    public static void moveRight(int[] array, int positions) {
        int size = array.length;
        for (int i = 0; i < positions; i++) {
            int temp = array[size - 1];
            for (int j = size - 1; j > 0; j--) {
                array[j] = array[j-1];
            }
            array[0] = temp;
        }
    }
    public static void moveLeft(int[] array, int positions) {
        int size = array.length;
        for (int i = size; i > positions; i--) {
            int temp = array[size-1];
            for (int j = size-1; j > 0; j--) {
                array[j] = array[j-1];
            }
            array[0] = temp;
        }
    }
}