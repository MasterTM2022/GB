package ru.gb.perov.Part1.HomeWork7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public boolean eat(Plate p) {
        satiety = p.decreaseFood(appetite);
        return satiety;
    }

    @Override
    public String toString() {
        return "Cat " +
                "" + name +
                " with appetite=" + appetite +
                (satiety ? " is full" : " is hungry");
    }
}
