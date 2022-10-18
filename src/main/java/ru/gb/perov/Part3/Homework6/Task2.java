package ru.gb.perov.Part3.Homework6;
/*
Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной
четверки или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4
варианта входных данных).
[ 1 1 1 4 4 1 4 4 ] -> true
[ 1 1 1 1 1 1 ] -> false
[ 4 4 4 4 ] -> false
[ 1 4 4 1 1 4 3 ] -> false
*/

import java.util.Arrays;

public class Task2 {

    public static final int FIRST_ELEMENTS = 1;
    public static final int SECOND_ELEMENTS = 4;
    public static final int SIZE_OF_ARRAY = 10;

    public static void main(String[] args) {
        System.out.println(checkArray(fillArray()));
    }

    static boolean checkArray(int[] array) {
        int sum = 0;
        for (int j : array) {
            if (j != FIRST_ELEMENTS && j != SECOND_ELEMENTS) {
                return false;
            }
            sum += j;
        }
        return sum != FIRST_ELEMENTS * array.length && sum != SECOND_ELEMENTS * array.length;
    }

    private static int[] fillArray() {
        int[] array = new int[SIZE_OF_ARRAY];
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            int buff = (int) (10 * Math.random());
            if (buff < 4) {
                array[i] = FIRST_ELEMENTS;
            } else if (buff < 9) {
                array[i] = SECOND_ELEMENTS;
            } else {
                array[i] = (int) (10 * Math.random());
            }
//            array[i] = 1;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}