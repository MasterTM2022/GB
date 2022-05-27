package ru.gb.perov.HomeWork6;

public class Cat extends Animal {
    String color;
    private static int catCount = 0;

    public Cat(String name, int yearOfBorn, int weight, int runAbility, int swimAbility, boolean sex, String color) {
        super(name, yearOfBorn, weight, runAbility, swimAbility, sex);
        this.color = color;
        catCount++;
    }

    private void countCat() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static int getCatCount() {
        return catCount;
    }

}
