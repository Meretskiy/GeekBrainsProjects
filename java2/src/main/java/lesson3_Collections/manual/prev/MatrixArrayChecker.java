package lesson3_Collections.manual.prev;

public class MatrixArrayChecker {
    private static final int SIZE = 4;

    public void checkSize(String[][] matrix) {
        if (matrix.length != SIZE) {
            throw new MyArraySizeException(String.format("Array size [%s] " +
                    "is not equal to %s of array %s", matrix.length, SIZE, matrix));
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != SIZE) {
                throw new MyArraySizeException(String.format("Inner array size [%s] " +
                        "is not equal to %s of array %s", matrix[i].length, SIZE, matrix[i]));
            }
        }
    }

    public void valueToInt(String[][] matrix) {
        int val = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                try {
                    int integerVal = Integer.parseInt(matrix[i][j]);
                    val += integerVal;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Array value with index[%s][%s] " +
                            "contains no integer [%s]", i, j, matrix[i][j]));
                }
            }
        }
    }
}
