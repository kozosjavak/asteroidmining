package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;

public class StartSolarStormCommand implements Command {
    @Override
    public void apply(Game game) throws Exception {
        if (game.getTheSun() != null) {
            game.getTheSun().generateDirectSolarStorm();
        } else {
            System.out.println("We don't have sun!\n");
        }
    }
}
