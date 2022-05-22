package ru.gb.perov.Part1.HomeWork3;

import java.util.Arrays;

public class HomeWork3 {
    public static void main(String[] args) {
//        1
        reverse();
        System.out.println("*******************");

//        2
        fulfill();
        System.out.println("*******************");

//        3
        doubleSix();
        System.out.println("*******************");

//        4
        cross(10);
        System.out.println("*******************");

//        5
        System.out.println(Arrays.toString(arrayReturn(10, 5)));
        System.out.println("*******************");

//        6
        math();
        System.out.println("*******************");

//        7
        int[] array = new int[1000];
        System.out.println(half(fillArray(array.length)));
        System.out.println("*******************");

//        8
        int[] arrayShift = new int[100];
        arrayShift = fillArray(arrayShift.length);
        System.out.println(Arrays.toString(arrayShift));
        shift(arrayShift, 90);
        System.out.println(Arrays.toString(arrayShift));
        System.out.println("*******************");
    }

    public static void reverse() {
        int[] array = {1, 0, 1, 0, 1, 0, 1, 1, 0, 0};
        for (int i : array) {
            if (i == 0) {
                i = 1;
            } else {
                i = 0;
            }
            System.out.println(i);
        }
    }

    public static void fulfill() {
        int[] array = new int[100];
        int j = 1;
        for (int i : array) {
            i = j++;
            System.out.println(i);
        }
    }

    public static void doubleSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i : array) {
            if (i < 6) i = i * 2;
            System.out.println(i);
        }
    }

    public static void cross(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || i == size - 1 - j) {
                    array[i][j] = 1;
                }
            }
        }
        Arrays.stream(array).map(Arrays::toString).forEach(System.out::println); // честно стырил в интернете эту строчку,
        // пока не понимаю как работает, но, вах! как она работает....
        // до Stringbuilder-а пока не дошел, но уже слышал, что
        // складывать строки в цикле - не комильфо, поэтому решил
        // вывод массива в консоль сплагиатить...
        System.out.println("*******************");

        //var 2: с одним циклом... (сначала сделала домашку, потом посмотрел по ней лекцию, где был коммент о попытке в один цикл...
        //жаль, что сам не сообразил сразу, что можно подумать в этом направлении... вернулся - передалал...
        //видимо смутил в задаче акцент "нарисовать хотя бы одну диагональ"... из-за этого кажтся, что это две подзадачи со всеми вытекающими...
        int[][] array2 = new int[size][size];
        for (int i = 0; i < size; i++) {
            array2[i][i] = 1;
            array2[i][size - 1 - i] = 1;
        }
        Arrays.stream(array2).map(Arrays::toString).forEach(System.out::println);
    }

    public static int[] arrayReturn(int len, int initialValue) {
        int[] array = new int[len];         // Почему-то в этой секции не получилось через foreach... все заполнилось нулями, кроме первого элемента
        for (int i = 0; i < len; i++) {     // for (int i : array) {
            array[i] = initialValue;        //      i = initialValue;
        }                                   // }
        return array;
    }

    public static void math() {
        int[] array = new int[11];
        array = fillArray(array.length);

        int min = array[0];
        int max = array[0];
        int sum = 0;
        int count = 0;

        for (int i : array) {
            if (min > i) {
                min = i;
            } else if
            (max < i) {
                max = i;
            }
            sum += i;
            ++count;
        }
        System.out.println("массив: " + Arrays.toString(array));
        System.out.println("максимум = " + max);
        System.out.println("минимум = " + min);
        System.out.println("среднее = " + String.format("%.2f", (double) sum / count));
        System.out.println("сумма = " + sum);
    }

    public static boolean half(int[] array) {
        int sum = 0, sum1 = 0, j = 0;
        for (int i : array) {
            sum += i;
        }
        do {
            sum1 += array[j++];
            if (sum1 == (sum - sum1)) {
                System.out.println("half-sum delimiter is between " + j + "th and " + (j + 1) + "th elements (" + sum1 + " + " + sum1 + " = " + sum + ")");
                return true;
            }
        } while (j < array.length);
        return false;
    }

    public static int[] shift(int[] shiftArray, int shift) {
        shift = shift % shiftArray.length;
        boolean direction;

        if (shift == 0) {
            System.out.println("no changes");
            return shiftArray;
        } else if (shift < 0) {
            if ((Math.abs(shift) * 2 > shiftArray.length)) {
                shift = shiftArray.length + shift;
                direction = true;
            } else {
                direction = false;
            }
        } else {
            if (shift * 2 > shiftArray.length) {
                shift = shiftArray.length - shift;
                direction = false;
            } else {
                direction = true;
            }
        }
        for (int i = 0; i < Math.abs(shift); i++) {
            shiftArray = oneShiftArray(shiftArray, direction);
        }
        return shiftArray;
    }


    public static int[] oneShiftArray(int[] oneShiftArray, boolean direction) {
        if (direction) {
            int buf = oneShiftArray[oneShiftArray.length - 1];
            for (int j = oneShiftArray.length - 1; j > 0; j--) {
                oneShiftArray[j] = oneShiftArray[j - 1];
            }
            oneShiftArray[0] = buf;
        } else {
            int buf = oneShiftArray[0];
            for (int j = 0; j < oneShiftArray.length - 1; j++) {
                oneShiftArray[j] = oneShiftArray[j + 1];
            }
            oneShiftArray[oneShiftArray.length - 1] = buf;
        }
        return oneShiftArray;
    }

    public static int[] fillArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
//        int[] array = {2, 8, 10, 4, 1, 7, 4, 4, 4, 4}; // если надоест ловить массив, который имеет такой разделить из задачи про полусуммы массива,
//                                                       // то надо раскомментировать эту строку и закомментировать четыре строки над ней
        return array;
    }

    }