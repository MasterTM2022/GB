package ru.gb.perov.Part3.HomeWork1.Task3;
/// Задача:
//     * a. Даны классы abstract Fruit, Apple extends Fruit, Orange extends Fruit;
//     * b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
//     * фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//     * c. Для хранения фруктов внутри коробки можно использовать ArrayList;
//     * d. Сделать в классе Box метод getWeight(), который высчитывает вес коробки по содержимому:
//     *          вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//     * e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую
//     * коробку с той, которую подадут в compare() в качестве параметра. true – если их массы
//     * равны, false в противоположном случае. Можно сравнивать коробки с яблоками и
//     * апельсинами;
//     * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//     * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//     * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
//     * объекты, которые были в первой;
//     * f*. Для усложнения, создать класс GoldenApple extends Apple
//     * g. Не забываем про метод добавления фрукта в коробку.
//     * g*. Метод из g должен принимать varargs: ...

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>(1, new ArrayList<>());
        Box<Orange> box2 = new Box<>(2, new ArrayList<>());
        Box<Apple> box3 = new Box<>(3, new ArrayList<>());

        box1.addFruit(new Apple(), new Apple(), new Apple());
        box2.addFruit(new Orange(), new Orange());


        System.out.println(box1);
        System.out.println(box2);
        System.out.println(box3);

        System.out.println(box1.compare(box2));
        System.out.println(box1.compare(box3));

        box1.addFruit(new Apple(), new Apple(), new Apple(), new GoldenApple());
        box2.addFruit(new Orange(), new Orange());
        box3.addFruit(new Apple(), new GoldenApple());

        box3.mergeBox(box1);
        box1.mergeBox(box3);
    }
}
