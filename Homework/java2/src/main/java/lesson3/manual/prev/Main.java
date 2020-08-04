package lesson3.manual.prev;

public class Main {

    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
     * при подаче массива другого размера необходимо бросить исключение prev.MyArraySizeException
     *
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
     * должно быть брошено исключение prev.MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные
     *
     * 3. В методе main() вызвать полученный метод, обработать возможные исключения
     * MySizeArrayException и prev.MyArrayDataException, и вывести результат расчета
     */
    public static void main(String[] args) {
        MatrixArrayChecker matrixArrayChecker = new MatrixArrayChecker();
        String[][] matrix = {
                {"1", "2", "3", "A"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] matrix1 = {
                {"1", "2", "3", "4"},
                {"1", "2"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };


        try {
            matrixArrayChecker.checkSize(matrix1);
            matrixArrayChecker.valueToInt(matrix1);
        } catch (MyArraySizeException e) {
            System.out.println(String.format("Array size is improper: %s", e.getMessage()));
        } catch (MyArrayDataException e) {
            System.out.println(String.format("Array value is not integer: %s", e.getMessage()));
        }

        try {
            matrixArrayChecker.checkSize(matrix);
            matrixArrayChecker.valueToInt(matrix);
        } catch (MyArraySizeException e) {
            System.out.println(String.format("Array size is improper: %s", e.getMessage()));
        } catch (MyArrayDataException e) {
            System.out.println(String.format("Array value is not integer: %s", e.getMessage()));
        }
    }
}
