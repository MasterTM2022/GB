package ru.gb.perov.Part2.HomeWork3;

import java.util.ArrayList;
import java.util.HashMap;

public class Task2 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        add(phoneBook, "Иванов", 1112233);
        add(phoneBook, "Иванов", 1112244);
        add(phoneBook, "Петров", 1112255);
        add(phoneBook, "Сидоров", 1112266);
        add(phoneBook, "Сидоренко", 1112277);
        add(phoneBook, "Сидорчук", 1112288);
        add(phoneBook, "Сидорченко", 1112299);
        add(phoneBook, "Сидоров", 1112200);
        add(phoneBook, "Сидоров", 1113311);
        get(phoneBook, "Иванов");
        get(phoneBook, "Сидоров");
        get(phoneBook, "Петров");
    }

    public static void add(HashMap<String, ArrayList<Integer>> col, String surname, Integer number) {
        ArrayList<Integer> newArrayList = new ArrayList<>();
        if (col.containsKey(surname)) {
            newArrayList.addAll(col.get(surname));
        }
        newArrayList.add(number);
        col.put(surname, newArrayList);
    }

    public static void get(HashMap<String, ArrayList<Integer>> col, String surname) {
        System.out.println(surname + ", телефон(ы): " + col.get(surname));
    }
}