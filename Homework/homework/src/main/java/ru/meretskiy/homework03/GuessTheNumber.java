package ru.meretskiy.homework03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void guessNumber() {

        Random rand = new Random();
        int guessedNum = rand.nextInt(10);
        System.out.println("Guess the number from 0 to 9. You have 3 attempts!");
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Attempt " + (i + 1) + ". Enter the number:");
            int enteredNum = sc.nextInt();

            if (guessedNum == enteredNum) {
                System.out.println("You win!!!");
                break;
            } else if (guessedNum > enteredNum) {
                System.out.println("The guessed number is bigger!");
            } else System.out.println("The guessed number is less!");
        }
    }

    public static void repeatGame() {

        while (true) {

            System.out.println("\nWill we play some more?\n1 - yes / 0 - no");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            if (num == 1) {
                guessNumber();
            } else if (num == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        guessNumber();
        repeatGame();

    }
}
