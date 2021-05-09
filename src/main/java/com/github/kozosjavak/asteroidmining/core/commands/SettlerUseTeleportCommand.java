package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.Teleport;

public class SettlerUseTeleportCommand implements Command {
    private final int settlerID;
    private final int teleportID;
    private Settler settler;
    private Teleport teleport;

    public SettlerUseTeleportCommand(int settlerID, int teleportID) {
        this.settlerID = settlerID;
        this.teleportID = teleportID;
    }

    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(settlerID).getClass() == Settler.class && game.getObjectFromID(teleportID).getClass() == Teleport.class) {
            teleport = (Teleport) game.getObjectFromID(teleportID);
            settler = (Settler) game.getObjectFromID(settlerID);
            if (teleport.getLocation() == settler.getCurrentAsteroid().getLocation()) {
                settler.teleport();
            } else {
                System.out.println("The given Teleport is not on the same location with the given Settler");
            }
        }

    }
}
