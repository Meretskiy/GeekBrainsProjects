package lesson2_Syntax;

public class Homework02 {

    public static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    //6
    public static boolean checkBalance(int[] arr) {

        int lSum, rSum;

        for (int i = 0; i < arr.length; i++) {

            lSum = rSum = 0;

            for (int j = 0; j < i; j++) {
                lSum += arr[j];
            }

            for (int j = i; j < arr.length; j++) {
                rSum += arr[j];
            }

            if (lSum == rSum) {
                return true;
            }
        }
        return false;
    }

    //7
    public static void moveElements(int arr[], int n) {

        int size = arr.length;

        if (n > 0) {

            for (int i = 0; i < n; i++) {

                int temp = arr[0];

                arr[0] = arr[size - 1];

                for (int x = 1; x < size - 1; x++) {

                    arr[size - x] = arr[size - 1 - x];
                }

                arr[1] = temp;
            }
        }

        if (n < 0) {

            for (int i = 0; i > n; i--) {

                int temp = arr[size - 1];
                arr[size - 1] = arr[0];

                for (int x = 1; x < size - 1; x++) {

                    arr[x - 1] = arr[x];
                }

                arr[size - 2] = temp;
            }
        }

        printArray(arr);
    }


    public static void main(String[] args) {

        //1
        System.out.println("1 - задание:");
        int[] arr1 = {1, 1, 0, 0, 1, 1, 0, 0, 1, 1};

        for (int i = 0; i < arr1.length; i++) {

            if (arr1[i] == 0) {
                arr1[i] = 1;
            } else {
                arr1[i] = 0;
            }
        }

        printArray(arr1);

        //2
        System.out.println("\n2 - задание:");
        int[] arr2 = new int[8];

        for (int i = arr2.length - 1; i >= 0; i--) {
            arr2[i] = 3 * i;
        }

        printArray(arr2);

        //3
        System.out.println("\n3 - задание:");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr3.length; i++) {

            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }

        printArray(arr3);

        //4
        System.out.println("\n4 - задание:");
        int[][] arr4 = new int[5][5];

        for (int i = 0; i < arr4.length; i++) {

            for (int j = 0, j1 = arr4[i].length; j < arr4[i].length; j++, j1--) {

                if (i == j || i == (j1 - 1)) {
                    arr4[i][j] = 1;
                }

                System.out.print(arr4[i][j] + " ");
            }

            System.out.println();
        }

        //5
        System.out.println("\n5 - задание:");
        int[] arr5 = {15, 12, 1, -8, 6, 27, 1987, -32, 0, 3};
        int min = arr5[0];
        int max = arr5[0];

        for (int value : arr5) {

            if (value > max) {
                max = value;
            }

            if (value < min) {
                min = value;
            }
        }

        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);

        //6
        System.out.println("\n6 - задание:");
        int[] arr6 = {2, 2, 2, 1, 2, 2, 10, 1};

        System.out.println(checkBalance(arr6));

        //7
        System.out.println("\n7 - задание:");
        int[] arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        moveElements(arr7, 15);
        moveElements(arr7, -15);

    }
}
