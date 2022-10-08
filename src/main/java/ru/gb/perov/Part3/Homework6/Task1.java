package ru.gb.perov.Part3.Homework6;

import java.util.Arrays;

public class Task1 {

    public static final int SIZE_OF_ARRAY = 10;
    public static final int MAX_VALUE_OF_ARRAY = 10;
    public static final int BARRIER_VALUE = 4;

    public static void main(String[] args) {
//        int[] arrayIn = fillArray(SIZE_OF_ARRAY, MAX_VALUE_OF_ARRAY);
        int[] arrayOut = cutArray(fillArray(SIZE_OF_ARRAY, MAX_VALUE_OF_ARRAY), BARRIER_VALUE);
        System.out.println(Arrays.toString(arrayOut));
    }

    private static int[] cutArray(int[] arrayIn, int barrierValue) throws RuntimeException {
        for (int i = arrayIn.length - 1; i >= 0; i--) {
            if (arrayIn[i] == barrierValue) {
                int[] arrayOut = new int[arrayIn.length - i - 1];
                for (int j = 0; j < arrayIn.length - i - 1; j++) {
                    arrayOut[j] = arrayIn[i + 1 + j];
                }
                return arrayOut;
            }
        }
        throw new RuntimeException();
    }

    private static int[] fillArray(int size, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (maxValue * Math.random());
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
