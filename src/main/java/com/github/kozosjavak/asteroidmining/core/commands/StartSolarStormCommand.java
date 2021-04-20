package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;

public class StartSolarStormCommand implements Command {
    @Override
    public void apply(Game game) {
        if (game.getSun() != null) {
            game.getSun().experienceSolarStorm();
        } else {
            System.out.println("We don't have sun!\n");
        }
    }
}
