package ru.gb.perov.Part2.HomeWork3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> col1 = new ArrayList<>();
        col1.add("First");
        col1.add("Second");
        col1.add("Third");
        col1.add("Fourth");
        col1.add("Fifth");
        col1.add("First");
        col1.add("First");
        col1.add("Second");
        col1.add("Tenth");
        col1.add("Ninth");
        col1.add("Eighth");
        col1.add("Seventh");
        col1.add("Seventh");
        col1.add("Seventh");
        col1.add("Seventh");
        System.out.println("Start collection: \n" + col1);
        System.out.println("Size of start collection: " + col1.size() + "\n");

        HashMap<String, Integer> col2 = new HashMap<>();
        for (String element : col1) {
            if (col2.containsKey(String.valueOf(element))) {
                col2.put(element, col2.get(String.valueOf(element)) + 1);
            } else {
                col2.put(String.valueOf(element), 1);
            }
        }
        System.out.println(toString(col2));
        System.out.println("Size of finish collection: " + col2.size());
    }

    public static String toString(HashMap<String, Integer> collection) {
        StringBuilder stringToReturn = new StringBuilder("[");
        for (Map.Entry<String, Integer> obj : collection.entrySet()) {
            stringToReturn.append(obj.getKey() + " (count=" + obj.getValue() + "), ");
        }
        stringToReturn.setLength(stringToReturn.length() - 2);
        stringToReturn.append(']');
        return stringToReturn.toString();
    }
}