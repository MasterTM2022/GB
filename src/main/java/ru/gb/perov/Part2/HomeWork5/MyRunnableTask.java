package ru.gb.perov.Part2.HomeWork5;

import static ru.gb.perov.Part2.HomeWork5.HomeWork5.NUMBER_OF_THREAD;

public class MyRunnableTask implements Runnable {
    private final int i;
    private final float[][] allArrays;
    private final float[] array;
    private final float[] mergedArray;
    private final int sizeLastSubArray;
    private final int sizeSubArray;

    public MyRunnableTask(int i, float[][] allArrays, float[] array, float[] mergedArray, int sizeLastSubArray, int sizeSubArray) {
        this.i = i;
        this.allArrays = allArrays;
        this.array = array;
        this.mergedArray = mergedArray;
        this.sizeLastSubArray = sizeLastSubArray;
        this.sizeSubArray = sizeSubArray;
    }

    public float[] createSubArray(float[] array, int i, int size) {
        float[] subArray = new float[size];
        System.arraycopy(array, i * sizeSubArray - i, subArray, 0, size);
        return subArray;
    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName());
        allArrays[i] = createSubArray(array, i, (i == NUMBER_OF_THREAD - 1 ? sizeLastSubArray : sizeSubArray));
            for (int j = 0; j < allArrays[i].length; j++) {
                allArrays[i][j] = (float) (allArrays[i][j] * Math.sin(0.2f + (i * sizeSubArray + j) / 5) * Math.cos(0.2f + (i * sizeSubArray + j) / 5) * Math.cos(0.4f + (i * sizeSubArray + j) / 2));
            }
            System.arraycopy(allArrays[i], 0, mergedArray, i * sizeSubArray, (i == NUMBER_OF_THREAD - 1 ? sizeLastSubArray : sizeSubArray));
        }
    }