package ru.gb.perov.Part3.Homework5;

import static ru.gb.perov.Part3.Homework5.MainClass.cyclicBarrier;
import static ru.gb.perov.Part3.Homework5.MainClass.lockVictory;

public class Car implements Runnable {
    private static int CARS_COUNT;

    private volatile static int CARS_PLACE;

    private final Race race;
    private final int speed;
    private final String name;
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public static int getCarsPlace() {
        return CARS_PLACE;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        if (lockVictory.tryLock()) {
            CARS_PLACE++;
            System.out.println("\u001B[31m" + this.name + " выиграл гонку!!!" + "\u001B[0m");
        } else {
            CARS_PLACE++;
            System.out.println("\u001B[31m" + this.name + " занял " + CARS_PLACE + "-е место \u001B[0m");
        }
    }
}
