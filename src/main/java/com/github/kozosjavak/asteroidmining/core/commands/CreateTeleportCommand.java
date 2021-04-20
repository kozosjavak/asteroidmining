package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Teleport;

public class CreateTeleportCommand implements Command {

    @Override
    public void apply(Game game) {
        Teleport teleport = new Teleport();
        game.putInIdList(teleport);
    }
}
