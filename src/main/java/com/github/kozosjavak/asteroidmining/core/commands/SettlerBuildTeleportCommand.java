package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

public class SettlerBuildTeleportCommand implements Command {

    private final int settlerId;

    public SettlerBuildTeleportCommand(int settlerId) {
        this.settlerId = settlerId;
    }

    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(settlerId).getClass() == Settler.class) {
            Settler settler = (Settler) game.getObjectFromID(settlerId);
            try {
                settler.buildTeleportPair();
            } catch (NotEnoughMaterialException e) {
                System.err.println("Not enough materials");
            }
        } else System.out.printf("Invalid object ID");
    }
}
