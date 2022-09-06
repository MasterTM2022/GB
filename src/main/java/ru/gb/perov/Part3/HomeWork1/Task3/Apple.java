package ru.gb.perov.Part3.HomeWork1.Task3;

public class Apple extends Fruit {
    private static final double weight = 1;


    public Apple() {
        super (weight);
    }

    public Apple(double weight) {
        super(weight);
    }


    @Override
    public String toString() {
        return "weight:" + this.weight;
    }

}
