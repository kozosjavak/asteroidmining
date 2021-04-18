package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Spaceship;

public class SpaceshipMoveCommand implements Command {
    private final int spaceshipId;
    private final int asteroidId;

    public SpaceshipMoveCommand(int spaceshipId, int asteroidId) {
        this.spaceshipId = spaceshipId;
        this.asteroidId = asteroidId;
    }

    @Override
    public void apply(Game game) throws Exception {
        if (game.getObjectFromID(spaceshipId).getClass() == Spaceship.class && game.getObjectFromID(asteroidId).getClass() == Asteroid.class) {
            Asteroid asteroid = (Asteroid) game.getObjectFromID(asteroidId);
            Spaceship spaceship = (Spaceship) game.getObjectFromID(spaceshipId);
            spaceship.move(asteroid.getLocation());
        } else {
            System.out.println("Invalid spaceship or Asteroid!\n");
        }
    }
}
