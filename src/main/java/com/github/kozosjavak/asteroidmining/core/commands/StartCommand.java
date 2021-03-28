package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;

public class StartCommand implements Command {
    @Override
    public void apply(Game game) {
        game.start();
    }
}
