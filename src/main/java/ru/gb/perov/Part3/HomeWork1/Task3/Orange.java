package ru.gb.perov.Part3.HomeWork1.Task3;

public class Orange extends Fruit {
    private static final double weight = 1.5;

    public Orange() {
        super(weight);
    }

    @Override
    public String toString() {
        return "weight: " + this.weight;
    }
}
