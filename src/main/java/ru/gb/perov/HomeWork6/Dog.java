package ru.gb.perov.HomeWork6;

public class Dog extends Animal {
    private int height;

    private static int dogCount = 0;

    public Dog(String name, int yearOfBorn, int weight, int runAbility, int swimAbility, boolean sex, int height) {
        super(name, yearOfBorn, weight, 500, 10, sex);
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

    @Override
    public void run(int distance) {
        if (distance < 0) {
            System.out.println("Собаки не умеют бегать задом");
        } else if (distance <= getRunAbility()) {
            System.out.println((getSex() ? "Пёс " : "Собака ") + getName() + (getSex() ? " пробежал" : " пробежала") + " дистанцию " + distance + "м.");
        } else {
            System.out.println((getSex() ? "Пёс " : "Собака ") + getName() + (getSex() ? " пробежал" : " пробежала") + " дистанцию " + distance + "м. за "
                    + (distance / getRunAbility() + (distance % getRunAbility() == 0 ? 0 : 1)) + " забега");
        }
    }

    public void swim(int distance) {
        if (getSwimAbility() == 0) {
            System.out.println(getName() + " не умеет плавать!!!");
        } else {
            if (distance < 0) {
                System.out.println(getName() + "не умеет плавать задом");
            } else if (distance <= getSwimAbility()) {
                System.out.println(getName() + (getSex() ? " проплыл" : " проплыла") + " дистанцию " + distance + "м");
            } else {
                System.out.println(getName() + (getSex() ? " проплыл" : " проплыла") + " дистанцию " + distance + "м за "
                        + (distance / getSwimAbility() + (distance % getSwimAbility() == 0 ? 0 : 1)) + " заплыва");
            }
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "height=" + height +
                "} " + super.toString();
    }
}