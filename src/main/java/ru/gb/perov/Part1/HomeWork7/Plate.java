package ru.gb.perov.Part1.HomeWork7;

import java.util.Scanner;

public class Plate {
    private int food;
    private final int limitFood;
    int LIMIT_PLATE = 30;

    public Plate(int food, int limitFood) {
        this.food = food;
        this.limitFood = LIMIT_PLATE;
    }
    public String info() {
        return "plate: " + food;
    }

    public boolean decreaseFood(int n) {
        if (food < n) {
            return false;
        } else {
            food -= n;
            return true;
        }
    }

    public void increaseFood() {
        System.out.println("Master, add some food in plate, please (no more than " + (limitFood - food) + ")");
        Scanner in = new Scanner(System.in);
        int addedFood;
        do {
            addedFood = in.nextInt();
            if (addedFood <= 0) {
                System.out.println("Master??? We didn't understand, meow...");
            } else if (addedFood + food > limitFood) {
                System.out.println("Master, so much... Our plate is very small for your bounty... A little smaller, meow...");
            } else {
                System.out.println("Master, you are so kind to us, meow...");
                food = addedFood + food;
            }
        } while (!(addedFood > 0 && food <= limitFood));

    }
}
