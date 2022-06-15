package ru.gb.perov.Part2.HomeWork5;

import java.util.Arrays;

public class HomeWork5 {
    static final int SIZE = 10_000_000;
    static final int NUMBER_OF_THREAD = 8;


    public static float[] fillArray(int size) {
        float[] arr = new float[size];
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        }
        a = System.currentTimeMillis() - a;
        System.out.println("fill-Time for array[" + size + "] = " + a);
        return arr;
    }

    public static float[] reFillArrayFirstMethod(float[] array) {
        long a = System.currentTimeMillis();
        float[] newArray = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        a = System.currentTimeMillis() - a;
        System.out.println("reFill-Time for array[" + newArray.length + "] = " + a);
//        System.out.println(Arrays.toString(newArray));
        return newArray;
    }

    public static float[] refillArraySecondMethod(float[] array) {
        long a = System.currentTimeMillis();
        int sizeSubArray = array.length / NUMBER_OF_THREAD;
        int sizeLastSubArray = sizeSubArray + array.length % NUMBER_OF_THREAD;
        float[] mergedArray = new float[array.length];
        float[][] allArrays = new float[NUMBER_OF_THREAD][];
        Thread[] thread = new Thread[NUMBER_OF_THREAD];
        for (int i = 0; i < NUMBER_OF_THREAD; i++) {
            thread[i] = new Thread(new MyRunnableTask(i, allArrays, array, mergedArray, sizeLastSubArray, sizeSubArray));
            thread[i].start();
        }
        try {
            for (int i = 0; i < NUMBER_OF_THREAD; i++) {
                thread[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a = System.currentTimeMillis() - a;
        System.out.println("reFill-Time for array[" + array.length + "] by Second Method = " + a);
//        System.out.println(Arrays.toString(mergedArray));
        return mergedArray;
    }

    public static void main(String[] args) {
        float[] array1 = fillArray(SIZE);
        float[] array1_1 = reFillArrayFirstMethod(array1);
        float[] array1_2 = refillArraySecondMethod(array1);
        System.out.println(Arrays.equals(array1_1, array1_2) ? "Arrays are equal" : "Arrays are NOT equal");
    }
}