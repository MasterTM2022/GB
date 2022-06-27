package ru.gb.perov.Part2.HomeWork2.MyException;

public class MyArrayDataException extends java.lang.NumberFormatException {
private static final String ERROR_MSG = "There is a char/string (no numeric) in this cell: [%d][%d]";
    public MyArrayDataException(int a, int b) {
        super(String.format(ERROR_MSG, a, b));
    }
}