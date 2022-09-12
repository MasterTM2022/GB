package ru.gb.perov.Part3.HomeWork1.Task3;

public class GoldenApple extends Apple {
    private static final double weight = 1.25;

    public GoldenApple() {
        super(weight);
    }

    @Override
    public String toString() {
        return "weight:" + this.weight;
    }
}
