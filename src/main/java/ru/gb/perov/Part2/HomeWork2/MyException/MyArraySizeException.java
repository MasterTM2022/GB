package ru.gb.perov.Part2.HomeWork2.MyException;

public class MyArraySizeException extends Exception {
    private static final String ERROR_MSG = "Massive size is not [4]*[4], your massive is [%d]*[%d]";

    public MyArraySizeException(int size1, int size2) {
        super(String.format(ERROR_MSG,size1, size2));
    }
}

