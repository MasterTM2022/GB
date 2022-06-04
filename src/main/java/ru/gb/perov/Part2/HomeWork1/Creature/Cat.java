package ru.gb.perov.Part2.HomeWork1.Creature;

public class Cat implements Creature{
    String name;
    private int runLimit;
    private int jumpLimit;

    public Cat(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat " +
                name +
                " (I can run " + runLimit +
                "m and jump " + jumpLimit +
                "cm)";
    }

    @Override
    public int run() {
        System.out.println("I am a cat. I'm running...");
        return this.runLimit;
    }

    @Override
    public int jump() {
        System.out.println("I am a cat. I'm jumping...");
        return this.jumpLimit;
    }
}
