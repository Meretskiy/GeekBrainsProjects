package lesson3_Syntax;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void guessTheNumber() {

        Random rand = new Random();
        int guessedNum = rand.nextInt(10);
        System.out.println(guessedNum);
        System.out.println("Угадайте число от 0 до 9. У вас 3 попытки!");
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Попытка " + (i + 1) + ". Введите чмсло:");
            int num = sc.nextInt();
            if (guessedNum == num) {
                System.out.println("Вы выйграли!!!");
                break;
            } else if (guessedNum > num) {
                System.out.println("Загаданное число больше!");
            } else System.out.println("Загаданное число меньше!");
        }
    }

    public static void main(String[] args) {

        guessTheNumber();

        while (true) {

            System.out.println("\nЕще поиграем?\n1 - да / 0 - нет");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (num == 1) {
                guessTheNumber();
            } else if (num == 0) {
                break;
            }
        }
    }
}
