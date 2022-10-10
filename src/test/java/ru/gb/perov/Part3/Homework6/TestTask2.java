package ru.gb.perov.Part3.Homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestTask2 {

    @Test
    void testCutArrayNorm() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Assertions.assertFalse(Task2.checkArray(array));
    }

    @Test
    void testCutArrayFirst() {
        int[] array = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Assertions.assertFalse(Task2.checkArray(array));
    }

    @Test
    void testCutArraySecond() {
        int[] array = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        Assertions.assertFalse(Task2.checkArray(array));
    }

    @Test
    void testCutArrayFirstAndSecond() {
        int[] array = {4, 1, 4, 1, 4, 1, 4, 1, 4, 1, 4, 1, 4, 1, 4, 1, 4, 1};
        Assertions.assertTrue(Task2.checkArray(array));
    }
}