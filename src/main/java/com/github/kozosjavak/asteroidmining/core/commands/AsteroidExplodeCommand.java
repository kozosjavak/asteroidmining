package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.NoNeighborException;

public class AsteroidExplodeCommand implements Command {

    private final int asteroidId;

    public AsteroidExplodeCommand(int asteroidId) {
        this.asteroidId = asteroidId;
    }

    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(asteroidId).getClass() == Asteroid.class) {
            Asteroid asteroid = (Asteroid) game.getObjectFromID(asteroidId);
            try {
                asteroid.explode();
            } catch (NoNeighborException e) {
                e.printStackTrace();
            }
        } else System.out.println("Invalid object ID");
    }
}
