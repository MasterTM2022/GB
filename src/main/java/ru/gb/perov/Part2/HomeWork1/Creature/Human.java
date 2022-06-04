package ru.gb.perov.Part2.HomeWork1.Creature;

public class Human implements Creature{
    String name;
    int runLimit;
    int jumpLimit;

    public Human(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Human " +
                name +
                " (I can run " + runLimit +
                "m and jump " + jumpLimit +
                "cm)";
    }

    @Override
    public int run() {
        System.out.println("I am a human. I'm running...");
        return runLimit;
    }

    @Override
    public int jump() {
        System.out.println("I am a human. I'm jumping...");
        return jumpLimit;
    }
}
