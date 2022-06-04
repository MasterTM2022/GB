package ru.gb.perov.Part2.HomeWork1.Obstacles;

import ru.gb.perov.Part2.HomeWork1.Creature.Creature;

public class RunningTrack implements Obstacles {
    int obsteclesSize;

    public RunningTrack(int obsteclesSize) {
        this.obsteclesSize = obsteclesSize;
    }

    public void setObsteclesSize(int obsteclesSize) {
        if (obsteclesSize > 0 && obsteclesSize <= 42195) {
            this.obsteclesSize = obsteclesSize;
        } else {
            this.obsteclesSize = 0;
        }
    }

    @Override
    public int getObsteclesSize() {
        return this.obsteclesSize;
    }

    public boolean wasCrossed(Creature creature) {
        if (creature.run() < obsteclesSize) {
            System.out.println("Obstacle (running track = " + obsteclesSize + "m) was NOT crossed by " + creature);
            return false;
        }
        System.out.println("Obstacle (running track = " + obsteclesSize + "m) was crossed by " + creature);
        return true;
    }
}
