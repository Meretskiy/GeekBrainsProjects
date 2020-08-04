package ru.meretskiy.homework04_gameTikTakToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static char[][] map;
    public static int size = 5;
    public static int block = 4;
    public static char dotX = 'X';
    public static char dotO = 'O';
    public static char dotEmpty = '*';
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        selectGame();
    }

    public static void selectGame() {

        System.out.println("Select game: " +
                "\n1 - Player vs Player" +
                "\n2 - Player vs AI" +
                "\n3 - Player vs AI(HARD)");

        switch (scanner.nextInt()) {
            case 1: {
                playGamePvP();
                break;
            }
            case 2: {
                playGamePvAi();
                break;
            }
            case 3: {
                System.out.println("In developing. Sorry for the inconvenience..");
                break;
            }
        }
    }

    public static void initMap() {

        map = new char[size][size];

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                map[i][j] = dotEmpty;
            }
        }
    }

    public static void printMap() {

        for (int i = 0; i <= size; i++) {

            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < size; i++) {

            System.out.print((i + 1) + " ");

            for (int j = 0; j < size; j++) {

                System.out.print(map[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static boolean isMapFull() {

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if (map[i][j] == dotEmpty) {

                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isCellValid(int x, int y) {

        if (x < 0 || x >= size || y < 0 || y >= size) {
            return false;
        }

        if (map[y][x] == dotEmpty) {
            return true;
        }

        return false;
    }

    public static void player1Turn() {

        int x, y;

        do {

            System.out.println("\nPlayer1:\nEnter the coordinates in X Y format");

            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        } while (!isCellValid(x, y));

        map[y][x] = dotX;
    }

    public static void player2Turn() {

        int x, y;

        do {

            System.out.println("\nPlayer2:\nEnter the coordinates in X Y format");

            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        } while (!isCellValid(x, y));

        map[y][x] = dotO;
    }

    public static void aiTurn() {

        int x, y;

        do {

            x = random.nextInt(size);
            y = random.nextInt(size);

        } while (!isCellValid(x, y));

        System.out.println("\nAI sets dot: " + (x + 1) + " " + (y + 1));
        map[y][x] = dotO;
    }

    public static boolean checkDiagonal(char ch, int offsetX, int offsetY ) {

        boolean toRight = true;
        boolean toLeft = true;
        for (int i = 0; i < block; i++) {

            toRight = toRight & (map[i + offsetX][i + offsetY] == ch);
            toLeft = toLeft & (map[block - i - 1 + offsetX][i + offsetY] == ch);
        }

        if (toRight || toLeft) {
            return true;
        }

        return false;
    }

    public static boolean checkLines(char ch, int offsetX, int offsetY) {

        boolean cols;
        boolean rows;

        for (int col = offsetX; col < block + offsetX; col++) {

            cols = rows = true;

            for (int row = offsetY; row < block + offsetY; row++) {

                cols = cols & (map[col][row] == ch);
                rows = rows & (map[row][col] == ch);
            }

            if (cols || rows) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkWin(char ch) {

        for (int col = 0; col < size - block + 1; col++) {

            for (int row = 0; row < size - block + 1; row++) {

                if (checkDiagonal(ch, col, row) || checkLines(ch, col, row)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void playGamePvAi() {

        initMap();
        printMap();

        while (true) {

            player1Turn();
            printMap();

            if (checkWin(dotX)) {
                System.out.println("\nPlayer Win!");
                break;
            }

            if (isMapFull()) {
                System.out.println("\nDraw!");
                break;
            }

            aiTurn();
            printMap();

            if (checkWin(dotO)) {
                System.out.println("\nAI Win!");
                break;
            }

            if (isMapFull()) {
                System.out.println("\nDraw!");
                break;
            }
        }

        System.out.println("\nGame Over.");
    }

    public static void playGamePvP() {

        initMap();
        printMap();

        while (true) {

            player1Turn();
            printMap();

            if (checkWin(dotX)) {
                System.out.println("\nPlayer1 Win!");
                break;
            }

            if (isMapFull()) {
                System.out.println("\nDraw!");
                break;
            }

            player2Turn();
            printMap();

            if (checkWin(dotO)) {
                System.out.println("\nPlayer2 Win!");
                break;
            }

            if (isMapFull()) {
                System.out.println("\nDraw!");
                break;
            }
        }

        System.out.println("\nGame Over.");
    }
}
