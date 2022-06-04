package ru.gb.perov.Part2.HomeWork1.Obstacles;

import ru.gb.perov.Part2.HomeWork1.Creature.Creature;

public interface Obstacles {
    void setObsteclesSize(int obsteclesSize);
    int getObsteclesSize();
    boolean wasCrossed(Creature creature);
}
