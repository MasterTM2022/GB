package ru.gb.perov.Part2.HomeWork1.Creature;

public class Robot implements Creature{
    String name;
    int runLimit;
    int jumpLimit;

    public Robot(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public String toString() {
        return "Robot " +
                name +
                " (my runLimit=" + runLimit +
                ", my jumpLimit=" + jumpLimit +
                "cm)";
    }

    public String getName() {
        return name;
    }

    @Override
    public int run() {
        System.out.println("I am a robot. I'm running...");
        return runLimit;
    }

    @Override
    public int jump() {
        System.out.println("I am a robot. I'm jumping...");
        return jumpLimit;
    }
}
