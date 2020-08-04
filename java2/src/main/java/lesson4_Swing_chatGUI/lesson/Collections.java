package lesson4_Swing_chatGUI.lesson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем)
 * Посчитать сколько раз встречается каждое слово
 *
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи.
 * С помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 */
public class Collections {
    public static void main(String[] args) {
        String[] words = new String[] {
                "Maks", "Salo", "Voda", "Planeta", "Police", "Deti", "Samolet", "Kirill", "Planeta", "Salo"
        };

        List<String> batchOfWords = new ArrayList<>();
//        List<String> batchOfWords = new ArrayList<>(Arrays.asList(words));
//        List<String> batchOfWords = Arrays.asList(words);
        for (String w : words) {
            batchOfWords.add(w);
        }

        System.out.println(batchOfWords);

        Set<String> uniqueWords = new HashSet<>();
//        Set<String> uniqueWords = new HashSet<>(batchOfWords);
//        uniqueWords.addAll(batchOfWords);
        for (String w : batchOfWords) {
            uniqueWords.add(w);
        }

        System.out.println(uniqueWords);

        Map<String, Integer> wordCounter = new HashMap<>();
        for (String w : batchOfWords) {
            if (wordCounter.containsKey(w)) {
                Integer count = wordCounter.get(w);
                count++;
                wordCounter.put(w, count);
            } else {
                wordCounter.put(w, 1);
            }
        }

        System.out.println(wordCounter);
    }
}

