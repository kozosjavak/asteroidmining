package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;

public class AsteroidExplodeCommand implements Command {

    private final int asteroidId;

    public AsteroidExplodeCommand(int asteroidId) {
        this.asteroidId = asteroidId;
    }

    @Override
    public void apply(Game game) throws Exception {
        if (game.getObjectFromID(asteroidId).getClass() == Asteroid.class) {
            Asteroid asteroid = (Asteroid) game.getObjectFromID(asteroidId);
            asteroid.explode();
        } else System.out.println("Invalid object ID");
    }
}
