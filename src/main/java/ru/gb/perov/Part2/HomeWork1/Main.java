package ru.gb.perov.Part2.HomeWork1;

import ru.gb.perov.Part2.HomeWork1.Creature.Cat;
import ru.gb.perov.Part2.HomeWork1.Creature.Creature;
import ru.gb.perov.Part2.HomeWork1.Creature.Human;
import ru.gb.perov.Part2.HomeWork1.Creature.Robot;
import ru.gb.perov.Part2.HomeWork1.Obstacles.JumpingTrack;
import ru.gb.perov.Part2.HomeWork1.Obstacles.Obstacles;
import ru.gb.perov.Part2.HomeWork1.Obstacles.RunningTrack;

public class Main {
    public static void main(String[] args) {
        Creature[] creatureArray = {
                new Cat("Chernysh", 100, 80),
                new Cat("Plyha", 130, 40),
                new Human("Sasha", 5000, 120),
                new Human("Misha", 3000, 110),
                new Robot("Shelesiaka", 500, 50),
                new Robot("Roboclop", 300, 50),
        };

        Obstacles[] obstaclesArray = {
                new RunningTrack(0),
                new JumpingTrack(0),
                new RunningTrack(0),
                new JumpingTrack(0),
                new RunningTrack(0)
        };

        //create track of obstacles
        for (int i = 0; i < obstaclesArray.length; i++) {
            do {
                obstaclesArray[i].setObsteclesSize((int) (Math.random() * 1000));
            } while (obstaclesArray[i].getObsteclesSize() == 0);
        }

        for (Creature creature : creatureArray) {
            boolean flag = true;
            for (Obstacles obstacle : obstaclesArray) {
                if (!obstacle.wasCrossed(creature)) {
                    System.out.println("Distance was not covered by " + creature);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Hurrah!!! Hurrah!!! Hurrah!!! Distance was covered by " + creature + "!!! Congradulations!!!");
                System.out.println("*******************************************************************************************************");
            } else {
                System.out.println("Sorry... " + creature + " went out of the track...");
                System.out.println("*******************************************************************************************************");
            }
        }
    }
}

