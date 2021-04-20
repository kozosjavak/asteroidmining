package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Teleport;

public class AddTeleportCommand implements Command {
    private final int asteroidID;
    private final int teleportID;

    public AddTeleportCommand(int teleportID, int asteroidID) {
        this.asteroidID = asteroidID;
        this.teleportID = teleportID;
    }

    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(asteroidID).getClass() == Asteroid.class && game.getObjectFromID(teleportID).getClass() == Teleport.class) {
            Asteroid asteroid = (Asteroid) game.getObjectFromID(asteroidID);
            asteroid.getLocation().setTeleport((Teleport) game.getObjectFromID(teleportID));
        }
    }
}
