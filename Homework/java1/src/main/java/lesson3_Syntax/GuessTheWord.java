package lesson3_Syntax;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {


    public static void guessTheWord() {

        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        char[] charArr = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
                '#', '#', '#', '#'};

        Random rand = new Random();
        int wordIndex = rand.nextInt(24);
        String word = words[wordIndex];

        System.out.println("Угадай слово!\nП.С. это фрукт или овощ.");

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("\nВведите ваш вариант:");
            String str = sc.nextLine();

            if (str.equals(word)) {
                System.out.println("You Win!!!");
                break;
            } else {

                for (int i = 0; i < str.length() && i < word.length(); i++) {
                    char charWord = word.charAt(i);
                    char charStr = str.charAt(i);

                    if (charStr == charWord) {
                        charArr[i] = word.charAt(i);
                    }
                }

                for (char ch : charArr) {
                    System.out.print(ch);
                }
            }
        }
    }

    public static void main(String[] args) {

        guessTheWord();

        while (true) {

            System.out.println("\nЕще поиграем?\n1 - да / 0 - нет");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            if (num == 1) {
                guessTheWord();
            } else if (num == 0) {
                break;
            }
        }
    }
}
