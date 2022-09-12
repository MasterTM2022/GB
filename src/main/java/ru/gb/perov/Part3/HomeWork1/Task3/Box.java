package ru.gb.perov.Part3.HomeWork1.Task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Box<T extends Fruit> {
    private int indexBox;
    private ArrayList<T> massiveFruit;

    public Box(int indexBox, ArrayList<T> massiveFruit) {
        this.indexBox = indexBox;
        this.massiveFruit = massiveFruit;
    }

    public int getIndexBox() {
        return indexBox;
    }

    public void setIndexBox(int indexBox) {
        this.indexBox = indexBox;
    }

    public ArrayList<T> getMassiveFruit() {
        return massiveFruit;
    }

    public void setMassiveFruit(ArrayList<T> massiveFruit) {
        this.massiveFruit = massiveFruit;
    }

    @Override
    public String toString() {
        return "number of Box: " + this.indexBox + ", Box weight: " + getWeight();
    }

    public double getWeight() {
        double result = 0;
        for (int i = 0; i < this.massiveFruit.size(); i++) {
            result += massiveFruit.get(i).getWeight();
        }
        return result;
    }

    public void addFruit(T ... fruit) {
        Collections.addAll(this.massiveFruit, fruit);
//        System.out.println(indexBox + ": " + this.massiveFruit.toString());
    }

    public boolean compare(Box box2) {
        return 0 == this.getWeight() - box2.getWeight();
    }

    public void mergeBox(Box<? extends T> box) {

        System.out.println("\nbefore...");
        System.out.println(this.toString());
        System.out.println(box.toString());

        this.massiveFruit.addAll(box.massiveFruit);
        box.massiveFruit.clear();

        System.out.println("after...");
        System.out.println(this.toString());
        System.out.println(box.toString());

    }
}