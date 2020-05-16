package homework03;

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
        String word = words[rand.nextInt(25)];

        System.out.println("Guess the word!\nP.S. This is a fruit or vegetable.");

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter your option:");
            String enteredWord = sc.nextLine();

            if (enteredWord.equals(word)) {
                System.out.println("You Win!!!");
                break;
            } else {

                for (int i = 0; i < enteredWord.length() && i < word.length(); i++) {
                    char charWord = word.charAt(i);
                    char charStr = enteredWord.charAt(i);

                    if (charStr == charWord) {
                        charArr[i] = word.charAt(i);
                    }
                }

                System.out.print("Hint: ");

                for (char ch : charArr) {
                    System.out.print(ch);
                }
            }
        }
    }

    public static void repeatGame() {

        while (true) {

            System.out.println("\nWill we play some more?\n1 - yes / 0 - no");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            if (num == 1) {
                guessTheWord();
            } else if (num == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        guessTheWord();
        repeatGame();
    }
}
