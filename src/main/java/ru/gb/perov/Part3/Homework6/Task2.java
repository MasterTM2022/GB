package ru.gb.perov.Part3.Homework6;

import java.util.Arrays;

public class Task2 {

    public static final int FIRST_ELEMENTS = 1;
    public static final int SECOND_ELEMENTS = 4;
    public static final int SIZE_OF_ARRAY = 10;

    public static void main(String[] args) {
        System.out.println(checkArray(fillArray(FIRST_ELEMENTS, SECOND_ELEMENTS, SIZE_OF_ARRAY), FIRST_ELEMENTS, SECOND_ELEMENTS));

    }

    private static boolean checkArray(int[] array, int firstValue, int secondValue) {
        int sum = 0;
        for (int j : array) {
            if (j != firstValue && j != secondValue) {
                return false;
            }
            sum += j;
        }
        return sum != firstValue * array.length && sum != secondValue * array.length;
    }
    private static int[] fillArray(int firstValue, int secondValue, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            int buff = (int) (10 * Math.random());
            if (buff < 4) {
                array[i] = 1;
            } else if (buff < 9) {
                array[i] = 4;
            } else {
                array[i] = (int) (10 * Math.random());
            }
//            array[i] = 1;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}