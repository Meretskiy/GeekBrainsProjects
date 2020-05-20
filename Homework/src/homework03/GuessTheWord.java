package homework03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {

    public static void guessWord() {

        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        char[] hintArr = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
                '#', '#', '#', '#'};

        Random rand = new Random();
        String guessWord = words[rand.nextInt(25)];

        System.out.println("Guess the word!\nP.S. This is a fruit or vegetable.");

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter your option:");
            String enteredWord = sc.nextLine();

            if (enteredWord.equals(guessWord)) {
                System.out.println("You Win!!!");
                break;
            } else {

                for (int i = 0; i < enteredWord.length() && i < guessWord.length(); i++) {
                    char charGuessWord = guessWord.charAt(i);
                    char charEnteredWord = enteredWord.charAt(i);

                    if (charEnteredWord == charGuessWord) {
                        hintArr[i] = guessWord.charAt(i);
                    }
                }

                System.out.print("Hint: ");

                for (char ch : hintArr) {
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
                guessWord();
            } else if (num == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        guessWord();
        repeatGame();
    }
}
