package ru.gb.perov.Part3.Homework6;

/*
Написать метод, которому в качестве аргумента передается не пустой одномерный
целочисленный массив. Метод должен вернуть новый массив, который получен путем
вытаскивания из исходного массива элементов, идущих после последней четверки. Входной
массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить
RuntimeException.
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ]
 */

import java.util.Arrays;
public class Task1 {
    public static final int SIZE_OF_ARRAY = 10000;
    public static final int MAX_VALUE_OF_ELEMENT = 10;
    public static final int BARRIER_VALUE = 4;

    public static void main(String[] args) {
//        int[] arrayIn = fillArray(SIZE_OF_ARRAY, MAX_VALUE_OF_ARRAY);
        int[] arrayOut = cutArray(fillArray());
        System.out.println(Arrays.toString(arrayOut));
    }

    public static int[] cutArray(int[] arrayIn) throws RuntimeException {
        for (int i = arrayIn.length - 1; i >= 0; i--) {
            if (arrayIn[i] == BARRIER_VALUE) {
                int[] arrayOut = new int[arrayIn.length - i - 1];
                for (int j = 0; j < arrayIn.length - i - 1; j++) {
                    arrayOut[j] = arrayIn[i + 1 + j];
                }
                return arrayOut;
            }
        }
        System.out.println(("There isn't any digit \"4\" - Exception will be now:"));
        throw new RuntimeException();
    }

    private static int[] fillArray() {
        int[] array = new int[SIZE_OF_ARRAY];
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            array[i] = (int) (MAX_VALUE_OF_ELEMENT * Math.random());
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
