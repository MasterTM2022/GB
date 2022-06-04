package ru.gb.perov.Part2.HomeWork1.Obstacles;

import ru.gb.perov.Part2.HomeWork1.Creature.Creature;

public class JumpingTrack implements Obstacles {
    int obsteclesSize;

    public JumpingTrack(int obsteclesSize) {
        this.obsteclesSize = obsteclesSize;
    }

    public void setObsteclesSize(int obsteclesSize) {
        if (obsteclesSize > 0 && obsteclesSize <= 100) {
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
        if (creature.jump() < obsteclesSize) {
            System.out.println("Obstacle (jumping height = " + obsteclesSize + "cm) was NOT crossed by " + creature);
            return false;
        }
        System.out.println("Obstacle (jumping height = " + obsteclesSize + "cm) was crossed by " + creature);
        return true;
    }
}
