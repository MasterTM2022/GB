package ru.gb.perov.Part1.HomeWork4;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Boolean.TRUE;

public class HomeWork4 {
    public static final boolean GUI = TRUE;
    public static char[][] map;
    public static final int SIZE = 7;
    public static final int DOTS_TO_WIN = 5; // не менее 2, самые классные рубилова идут при DOTS_TO_WIN = SIZE  - [1 или 2]  ))))
    public static final int DIFFICULT_LEVEL = 3; // в интервале от 0 до (DOTS_TO_WIN - 1), 0 - рандомно, 1 - анализ шахов в один ход, 2 - шахов в два хода и т.д.
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[43;30m";
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        if (GUI) {
            new MyWindow();
        } else {
            printMap();
            System.out.println("Победит тот, чья непрерывная цепочка будет не менее «" + DOTS_TO_WIN + " в ряд» (в том числе по диагонали)");
            while (true) {
                if (humanTurn()) {
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
                if (aiTurn()) {
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }
            System.out.println("Игра закончена");
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("   ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%3d  ", (i + 1));
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printMap(int y, int x, int direction) {

        System.out.print("   ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        int shift = 0;
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%3d  ", (i + 1));
            for (int j = 0; j < SIZE; j++) {
                if (i == y && j == x && shift < DOTS_TO_WIN) {
                    System.out.print(ANSI_RED + HomeWork4.map[i][j] + ANSI_RESET + "  ");
                    switch (direction) {
                        case 1 -> x++;
                        case 2 -> y++;
                        case 3 -> {
                            x++;
                            y++;
                        }
                        case 4 -> {
                            x--;
                            y++;
                        }
                    }
                    shift++;
                } else {
                    System.out.print(HomeWork4.map[i][j] + "  ");
                }
            }
            System.out.println(ANSI_RESET);
        }
        System.out.println();

    }

    public static boolean humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
        if (checkWin(y, x, 0, true)[2] > 0) {
            System.out.println("Победил человек");
            return true;
        } else {
            printMap();
            return false;
        }
    }

    public static boolean humanTurnGUI(int y, int x) {
        map[y][x] = DOT_X;
        if (checkWin(y, x, 0, false)[2] > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean aiTurn() {
        int x, y;
        if (DIFFICULT_LEVEL > 0) {
            int[] turn = realAiTurn(DOT_O);

            if (turn[0] == SIZE) {
                turn = realAiTurn(DOT_X);
            } else {
                x = turn[0];
                y = turn[1];
            }
            if (turn[0] == SIZE) {
                do {
                    x = rand.nextInt(SIZE);
                    y = rand.nextInt(SIZE);
                } while (!isCellValid(x, y));
            } else {
                x = turn[0];
                y = turn[1];
            }
        } else {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
        }
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;

        if (checkWin(y, x, 0, true)[2] > 0) {
            System.out.println("Победил Искусственный Интеллект");
            return true;
        } else {
            printMap();
            return false;
        }

    }
    public static int[] aiTurnGUI() {
        int x, y;
        int[] turn;
        if (DIFFICULT_LEVEL > 0) {
            turn = realAiTurn(DOT_O);

            if (turn[0] == SIZE) {
                turn = realAiTurn(DOT_X);
            } else {
                x = turn[0];
                y = turn[1];
            }
            if (turn[0] == SIZE) {
                do {
                    x = rand.nextInt(SIZE);
                    y = rand.nextInt(SIZE);
                } while (!isCellValid(x, y));
            } else {
                x = turn[0];
                y = turn[1];
            }
        } else {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
                turn = new int[]{y, x};
            } while (!isCellValid(x, y));
        }
        map[y][x] = DOT_O;
        turn[0] = y;
        turn[1] = x;
        return turn;
    }

    public static int[] realAiTurn(char dotForCheck) {
        int x = SIZE;
        int y = SIZE;
        int[] status;
        int diffLevel;
        if (dotForCheck == DOT_O) {
            diffLevel = 1;
        } else {
            diffLevel = DIFFICULT_LEVEL;
        }
        outerloop:
        for (int d = 1; d <= diffLevel; d++) {

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == dotForCheck) {
                        status = checkWin(i, j, d, false);
                        if (status[2] > 0) {
                            y = status[0];
                            x = status[1];
                            switch (status[2]) {
                                case 1:
                                    while (!isCellValid(x, y)) {
                                        x++;
                                    }
                                    break outerloop;
                                case 2:
                                    while (!isCellValid(x, y)) {
                                        y++;
                                    }
                                    break outerloop;
                                case 3:
                                    while (!isCellValid(x, y)) {
                                        x++;
                                        y++;
                                    }
                                    break outerloop;
                                case 4:
                                    while (!isCellValid(x, y)) {
                                        x--;
                                        y++;
                                    }
                                    break outerloop;
                            }
                        }
                    }
                }
            }
        }
        int[] turn = {x, y};
        return turn;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static boolean isMapFull() {
        String stringToWinX = new String(new char[DOTS_TO_WIN]).replace('\u0000', DOT_X);
        String stringToWinO = new String(new char[DOTS_TO_WIN]).replace('\u0000', DOT_O);
        boolean part1 = false, part2 = false;
        for (int i = 0; i <= SIZE - DOTS_TO_WIN; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
                String stringVertical = String.valueOf(map[i][j]);
                String stringHorizontal = stringVertical;
                String stringLeftDown = stringVertical;
                String stringLeftUp = String.valueOf(map[SIZE - 1 - i][j]);

                for (int k = 1; k < DOTS_TO_WIN; k++) {
                    stringHorizontal += String.valueOf(map[i][j + k]);
                    stringVertical += String.valueOf(map[i + k][j]);
                    stringLeftDown += String.valueOf(map[i + k][j + k]);
                    stringLeftUp += String.valueOf(map[SIZE - 1 - i - k][j + k]);
                }

                part1 = (stringVertical.replace(DOT_EMPTY, DOT_X).equals(stringToWinX) ||
                        stringVertical.replace(DOT_EMPTY, DOT_O).equals(stringToWinO) ||
                        stringHorizontal.replace(DOT_EMPTY, DOT_X).equals(stringToWinX) ||
                        stringHorizontal.replace(DOT_EMPTY, DOT_O).equals(stringToWinO) ||
                        stringLeftDown.replace(DOT_EMPTY, DOT_X).equals(stringToWinX) ||
                        stringLeftDown.replace(DOT_EMPTY, DOT_O).equals(stringToWinO) ||
                        stringLeftUp.replace(DOT_EMPTY, DOT_X).equals(stringToWinX) ||
                        stringLeftUp.replace(DOT_EMPTY, DOT_O).equals(stringToWinO));
                if (part1) {
                    return !part1;
                }
            }
        }

        for (int i = SIZE - DOTS_TO_WIN + 1; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
                String stringHorizontal = String.valueOf(map[i][j]);
                String stringVertical = String.valueOf(map[j][i]);

                for (int k = 1; k < DOTS_TO_WIN; k++) {
                    stringHorizontal += String.valueOf(map[i][j + k]);
                    stringVertical += String.valueOf(map[j + k][i]);
                }

                part2 = (stringVertical.replace(DOT_EMPTY, DOT_X).equals(stringToWinX) ||
                        stringVertical.replace(DOT_EMPTY, DOT_O).equals(stringToWinO) ||
                        stringHorizontal.replace(DOT_EMPTY, DOT_X).equals(stringToWinX) ||
                        stringHorizontal.replace(DOT_EMPTY, DOT_O).equals(stringToWinO));
                if (part2) {
                    return !part2;
                }
            }
        }

        return !part1 || !part2;
    }

    public static int[] checkWin(int y, int x, int diffLevel, boolean printable) {
//      для возврата используется массив, где первые две ячейки - адрес старта победной дорожки,
//      третья - направление (1-вправо, 2 - влево, 3 - вправо вниз, 4 - вправо вверх)
//      четвертая - признак необходимости печатать карту после проверки дорожки на необходимые условия
        String stringToWin = new String(new char[DOTS_TO_WIN]).replace('\u0000', map[y][x]);
        String stringVertical = "";
        String stringHorizontal = "";
        String stringLeftDown = "";
        String stringLeftUp = "";
        int print;
        if (printable) {
            print = 1;
        } else {
            print = 0;
        }
        int minY = Math.max(0, y - DOTS_TO_WIN + 1);
        int maxY = Math.min(y + DOTS_TO_WIN - 1, SIZE - 1);
        int minX = Math.max(0, x - DOTS_TO_WIN + 1);
        int maxX = Math.min(x + DOTS_TO_WIN - 1, SIZE - 1);

        for (int j = minX; j <= maxX - DOTS_TO_WIN + 1; j++) {
            for (int k = 0; k < DOTS_TO_WIN; k++) {
                stringHorizontal += map[y][j + k];
            }
            if (stringCorrected(stringHorizontal, diffLevel, map[y][x]).equals(stringToWin)) {
                int[] checkWin = {y, j, 1, print};
                if (printable) {
                    printMap(y, j, 1);
                }
                return checkWin;
            }
            stringHorizontal = "";
        }
        for (int i = minY; i <= maxY - DOTS_TO_WIN + 1; i++) {
            for (int k = 0; k < DOTS_TO_WIN; k++) {
                stringVertical += map[i + k][x];
            }
            if (stringCorrected(stringVertical, diffLevel, map[y][x]).equals(stringToWin)) {
                int[] checkWin = {i, x, 2, print};
                if (printable) {
                    printMap(i, x, 2);
                }
                return checkWin;
            }
            stringVertical = "";
        }
        for (int i = minY; i <= maxY - DOTS_TO_WIN + 1; i++) {
            for (int j = minX; j <= maxX - DOTS_TO_WIN + 1; j++) {
                if ((Math.abs(i - y) == Math.abs(j - x))) {
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        stringLeftDown += map[i + k][j + k];
                    }
                    if (stringCorrected(stringLeftDown, diffLevel, map[y][x]).equals(stringToWin)) {
                        int[] checkWin = {i, j, 3, print};
                        if (printable) {
                            printMap(i, j, 3);
                        }
                        return checkWin;
                    }
                    stringLeftDown = "";
                }
            }
        }
        for (int i = maxY; i >= minY + DOTS_TO_WIN - 1; i--) {
            for (int j = minX; j <= maxX - DOTS_TO_WIN + 1; j++) {
                if ((Math.abs(i - y) == Math.abs(j - x))) {
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        stringLeftUp += map[i - k][j + k];
                    }
                    if (stringCorrected(stringLeftUp, diffLevel, map[y][x]).equals(stringToWin)) {
                        int[] checkWin = {i, j, 4, print};
                        if (printable) {
                            printMap(i - DOTS_TO_WIN + 1, j + DOTS_TO_WIN - 1, 4);
                        }
                        return checkWin;
                    }
                    stringLeftUp = "";
                }
            }
        }
        int[] checkWin = {y, x, 0, print};
        return checkWin;

    }

    public static String stringCorrected(String checkString, int diffLevel, char dot) {
        for (int i = 0; i < diffLevel; i++) {
            checkString = checkString.replaceFirst(String.valueOf(DOT_EMPTY), String.valueOf(dot));
        }
        return checkString;
    }

    public static void PopUpJava(String message) {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, message);
    }


}