package lesson2_Exceptions.hw;

public class Application {

    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив
     * размером 4х4, при подаче массива другого размера необходимо бросить исключение
     * MyArraySizeException.
     *
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int,
     * и просуммировать. Если в каком-то элементе массива преобразование не удалось
     * (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
     * исключение MyArrayDataException, с детализацией в какой именно ячейке лежат
     * неверные данные.
     *
     * 3. В методе main() вызвать полученный метод, обработать возможные исключения
     * MySizeArrayException и MyArrayDataException, и вывести результат расчета.
     */


    /**
     * Обработал исключение MyArrayDataException прямо в методе, что бы посчиталась
     * сумма всех чисел в массиве, а не только чисел до первого не верного значения.
     */

    public static void main(String[] args) {

        String[][] array = {{"1", "2", "3", "one"}, {"4", "two", "5", "6"},
                {"7", "fatalError", "8", "9"}, {"for", "10", "Y", "N"}};

        try {
            calculateSumAllArrayNumbers(array);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    public static void calculateSumAllArrayNumbers(String array[][])
            throws MyArraySizeException {

        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length != 4) {
                throw new MyArraySizeException("Invalid array size." +
                        " You must pass an array of format [4][4].");
            }
        }

        int result = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {

                    if (!isNumber(array[i][j])) {
                        throw new MyArrayDataException(String.format("Cell [%s][%s] " +
                                "contains invalid data. There: %s", i, j, array[i][j]));
                    }

                    result += Integer.parseInt(array[i][j]);

                } catch (MyArrayDataException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("The sum of all numbers in the array is: " + result);
    }

    private static boolean isNumber(String str) {

        char[] arr = str.toCharArray();

        for (char c : arr) {
            if (c > 47 && c < 58) {
                return true;
            }
        }

        return false;
    }
}