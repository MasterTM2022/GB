package ru.gb.perov.HomeWork2;

public class HomeWork2 {
    public static void main(String[] args) {
        interval(5, 16);

        positive(10);

        System.out.println(positiveReturn(-20));

        copier("tired to type", 10);

        System.out.println(leapYear(2000));
        System.out.println(leapYear(1900));
        System.out.println(leapYear(2022));
        System.out.println(leapYear(2024));
        System.out.println(leapYear(1997));

    }

    public static void interval(int a, int b) {
        if (a + b < 10 | 20 < a + b) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }

    public static void positive(int c) {
        if (c >= 0) {
            System.out.println(c + " - positive number");
        } else {
            System.out.println(c + " - negative number");
        }
    }

    public static boolean positiveReturn(int d) {
        if (d >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void copier(String str, int numCopy) {
        for (int i = 0; i < numCopy; i++) {
            System.out.println(str);
        }
    }


    public static boolean leapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}