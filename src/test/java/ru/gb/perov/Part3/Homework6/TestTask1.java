package ru.gb.perov.Part3.Homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class TestTask1 {


    @Test
    void testCutArrayNorm() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] arrayOut = {5, 6, 7, 8, 9, 10, 11};
        Assertions.assertArrayEquals(arrayOut, Task1.cutArray(array));
    }
    @Test
    void testCutArrayLast() {
        int[] array = {1, 2, 3, 5, 6, 7, 8, 9, 10, 4};
        int[] arrayOut = {};
        Assertions.assertArrayEquals(arrayOut, Task1.cutArray(array));
    }
    @Test
    void testCutArrayFirst() {
        int[] array = {4, 1, 2, 3, 5, 6, 7, 8, 9, 10};
        int[] arrayOut = {1, 2, 3, 5, 6, 7, 8, 9, 10};
        Assertions.assertArrayEquals(arrayOut, Task1.cutArray(array));
    }
    @Test
    void testCutArraySeveral() {
        int[] array = {4, 1, 2, 3, 4, 5, 6, 7, 8, 4, 9, 10};
        int[] arrayOut = {9, 10};
        Assertions.assertArrayEquals(arrayOut, Task1.cutArray(array));
    }
    @Test
    void testExeptionCutArray() {
        int[] array = {1, 2, 3, 3, 5, 6, 7, 8, 9, 10};
        Assertions.assertThrows(RuntimeException.class, () -> Task1.cutArray(array));
    }
    @ParameterizedTest
    @MethodSource("dataForArrayTest")
    public void testArrayOperation(int[] result, int[] array) {
        Assertions.assertArrayEquals(result, Task1.cutArray(array));
    }
    public static Stream<Arguments> dataForArrayTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{5, 6, 7, 8, 9, 10}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        out.add(Arguments.arguments(new int[]{}, new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10, 4}));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10}, new int[]{4, 1, 2, 3, 5, 6, 7, 8, 9, 10}));
        out.add(Arguments.arguments(new int[]{9, 10}, new int[]{4, 1, 2, 3, 4, 5, 6, 7, 8, 4, 9, 10}));
        return out.stream();
    }
}