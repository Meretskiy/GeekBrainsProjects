package lesson3_Collections.hw;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать сколько раз встречается каждое слово.
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список
 * фамилий и телефонных номеров. В этот телефонный справочник с помощью метода add()
 * можно добавлять записи. С помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов
 * (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 */

public class Application {

    public static void main(String[] args) {

        printUniqueWords(initArray());
        countUniqueWords(initArray());

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Bob", "+7-915-123-32-21");
        phoneBook.add("Max", "+7-905-321-55-62");
        phoneBook.add("Roy", "+7-910-432-33-67");
        phoneBook.add("Lex", "+7-925-564-87-60");
        phoneBook.add("Bob", "+7-903-002-29-48");
        phoneBook.add("Bob", "+7-903-002-29-50");
        phoneBook.get("Bob");
        phoneBook.get("Lex");
        phoneBook.get("Roy");
    }

    public static String[] initArray() {

        String[] wordArray = {
                "word1", "word2", "word3", "word4", "word5",
                "word5", "word6", "word7", "word7", "word7",
                "word8", "word9", "word9", "word10", "word10"};

        return wordArray;
    }

    public static void printUniqueWords(String[] wordArray) {

        Set<String> wordSet = new HashSet<>();

        System.out.print("Unique words list: ");

        for (String str : wordArray) {
            wordSet.add(str);
        }

        for (String str : wordSet) {
            System.out.print(str + " ");
        }

        System.out.println("\n----------------");
    }

    public static void countUniqueWords(String[] wordArray) {

        Map<String, Integer> wordMap = new HashMap<>();

        for (String str : wordArray) {
            Integer count = wordMap.get(str);

            if (count == null) {
                count = 0;
            }
            wordMap.put(str, ++count);
        }

        System.out.println("Number of words in an array:");

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("----------------");
    }
}
