//package lesson2.hw;
//
//public class Application {
//
//    public static void main(String[] args) {
//
//        String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"},
//                {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
//
//        try {
//            Test(array);
//        } catch (MyArraySizeException e) {
//            e.printStackTrace();
////        } catch (MyArrayDataException e) {
////            e.printStackTrace();
//        }
//
//        System.out.println("The end");
//    }
//
//    public static void Test (String array[][]) throws MyArraySizeException {
//
//        for (int i = 0; i < array.length; i++) {
//            if (array.length != 4 || array[i].length != 4) {
//                throw new MyArraySizeException("Ошибка. Пришел массив не 4 на 4");
//            }
//        }
//
//        int result = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            try {
//                for (int j = 0; j < array[i].length; j++) {
//
//                    if (!isNumber(array[i][j])) {
//                        throw new MyArrayDataException(String.format("В ячейке [%s][%s] находится не число.", i, j));
//                    }
//
//                    result += Integer.parseInt(array[i][j]);
//                }
//            } catch (MyArrayDataException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        System.out.println(result);
//    }
//
//    private static boolean isNumber (String str){
//
//        char[] arr = str.toCharArray();
//
//        for (char c : arr) {
//            if (c > 47 && c < 58) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//}