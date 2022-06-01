package ru.gb.perov.HomeWork6;

public class Cat extends Animal {
    String color;
    private static int catCount = 0;

    public Cat(String name, int yearOfBorn, int weight, int runAbility, int swimAbility, boolean sex, String color) {
        super(name, yearOfBorn, weight, 200, 0, sex);
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

    @Override
    public void run(int distance) {
        if (distance < 0) {
            System.out.println("Коты не умеют бегать задом");
        } else if (distance <= getRunAbility()) {
            System.out.println((getSex() ? "Кот " : "Кошка ") + getName() + (getSex() ? " пробежал" : " пробежала") + " дистанцию " + distance + "м");
        } else {
            System.out.println((getSex() ? "Кот " : "Кошка ") + getName() + (getSex() ? " пробежал" : " пробежала") + " дистанцию " + distance + "м за "
                    + (distance / getRunAbility() + (distance % getRunAbility() == 0 ? 0 : 1)) + " забега");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеет плавать!!!");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Cat{" +
                "color='" + color + '\'' +
                "} ";
    }
}
