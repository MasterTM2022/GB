package ru.gb.perov.HomeWork6;

public class Dog extends Animal {
    private int height;

    private static int dogCount = 0;

    public Dog(String name, int yearOfBorn, int weight, int runAbility, int swimAbility, boolean sex, int height) {
        super(name, yearOfBorn, weight, runAbility, swimAbility, sex);
        this.height = height;
        dogCount++;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
