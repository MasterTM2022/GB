package ru.gb.perov.Part2.HomeWork2;

import ru.gb.perov.Part2.HomeWork2.MyException.MyArrayDataException;
import ru.gb.perov.Part2.HomeWork2.MyException.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        int PERCENTAGE = 5; // probability of occurrence of a non-numeric string, %%
        int size = (int) (Math.random() * 2) + 3;
        String[][] array = new String[size][size];
        try {
            array = fillArray(array, PERCENTAGE);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static String[][] fillArray(String[][] array, int percentage) throws MyArraySizeException, NumberFormatException {
        if (array.length == 4) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if ((int) (Math.random() * 100) % (int) (100 / percentage) == 0) {
                        array[i][j] = "EGG";
                    } else {
                        array[i][j] = String.valueOf((int) (Math.random() * 1000));
                    }
                    System.out.print(" ".repeat((5 - array[i][j].length())) + array[i][j]);
                }
                System.out.println();
            }
        } else {
            throw new MyArraySizeException(array.length, array.length);
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Sum of array = " + sum);
        return array;
    }
}