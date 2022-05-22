package ru.gb.perov.Part1.HomeWork6;

import java.util.Date;

public abstract class Animal {
    private String name;
    private int yearOfBorn;
    private int weight;
    private int runAbility;
    private int swimAbility;
    private boolean sex;
    private static int animalCount;

    public Animal(String name, int yearOfBorn, int weight, int runAbility, int swimAbility, boolean sex) {
        this.name = name;
        this.yearOfBorn = yearOfBorn;
        this.weight = weight;
        this.runAbility = runAbility;
        this.swimAbility = swimAbility;
        this.sex = sex;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBorn() {
        return yearOfBorn;
    }

    public void setYearOfBorn(int yearOfBorn) {
        Date dateNow = new Date();
        yearOfBorn = yearOfBorn < 0 ? Math.abs(yearOfBorn) : yearOfBorn;
        yearOfBorn = yearOfBorn < 1950 ? Math.abs(yearOfBorn) : yearOfBorn;
        yearOfBorn = yearOfBorn > dateNow.getYear() ? dateNow.getYear() + 1900 : yearOfBorn;
        this.yearOfBorn = yearOfBorn;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        weight = weight < 0 ? Math.abs(weight) : weight;
        this.weight = weight;
    }

    public int getRunAbility() {
        return runAbility;
    }

    public void setRunAbility(int runAbility) {
        runAbility = runAbility < 0 ? Math.abs(runAbility) : runAbility;
        this.runAbility = runAbility;
    }

    public int getSwimAbility() {
        return swimAbility;
    }

    public void setSwimAbility(int swimAbility) {
        swimAbility = swimAbility < 0 ? swimAbility : Math.abs(swimAbility);
        this.swimAbility = swimAbility;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public abstract void run(int distance);

    public abstract  void swim(int distance);

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", yearOfBorn=" + yearOfBorn +
                ", weight=" + weight +
                ", runAbility=" + runAbility +
                ", swimAbility=" + swimAbility +
                ", sex=" + sex +
                '}';
    }
}
