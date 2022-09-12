package ru.gb.perov.Part3.HomeWork1.Task1and2;

/// 1. Написать метод, который меняет два элемента массива местами (массив может быть любого
//     * ссылочного типа);
//     * static swap(array1, int firstIndex, int secondIndex) {
//     *     // меняем местами элементы, которые находятся на местах firstIndex и secondIndex
//     * }
//     *
//     * 2. Написать метод, который преобразует массив в ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Elements<T> {
    private T element;

    private Elements(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
    public static final int SIZE_OF_ARRAY = 20;


    public static void main(String[] args) {
        Elements[] arrayElements = new Elements[SIZE_OF_ARRAY];
        arrayElements = fillArray(arrayElements);
        System.out.println("Start massive: \n" + Arrays.toString(arrayElements));
        outMassive(arrayElements);

        int first, second;
        first = (int) (Math.random() * (SIZE_OF_ARRAY - 1));
        do {
            second = (int) (Math.random() * (SIZE_OF_ARRAY - 1));
        }
        while (second == first);

        System.out.println("\nChanging " + Math.min(first + 1, second + 1) + "-element with " + Math.max(first + 1, second + 1) + "-element...");

        arrayElements = replaceElements(arrayElements, first, second);
        System.out.println("Final massive: \n" + Arrays.toString(arrayElements));
        outMassive(arrayElements);

        massiveToArray(arrayElements);
    }

    public static Elements[] fillArray(Elements[] arrayElements) {
        for (int i = 0; i < arrayElements.length; i++) {  //просто заполняем i-шками с двумя типами минимальных преобразований через одного
            if (i%2==0) {
                arrayElements[i] = new Elements<>("«" + (i + 1)+"»"); //просто для проверки, что тут String
            } else {
                arrayElements[i] = new Elements<>((i + 1)*10); //просто для проверки, что тут Integer
            }
        }
        return arrayElements;
    }

    public static Elements[] replaceElements(Elements[] arrayElements, int first, int second) {
        Elements buffer = arrayElements[first];
        arrayElements[first] = arrayElements[second];
        arrayElements[second] = buffer;
        return arrayElements;
    }

    public static void outMassive (Elements[] arrayElements) {
        for (int i = 0; i < arrayElements.length; i++) {
            System.out.print(arrayElements[i].element+ "  ");
//            System.out.println(arrayElements[i].element.getClass().getName());
        }
    }

    public static List massiveToArray (Elements[] massiveElements) {
        List arrayElements = new ArrayList();
        arrayElements.addAll(List.of(massiveElements));
//        for (int i = 0; i < massiveElements.length; i++) {
//            arrayElements.add(massiveElements[i]);
//        }
        System.out.println("\nArraylist: \n" + arrayElements.toString());
        return arrayElements;
    }
}