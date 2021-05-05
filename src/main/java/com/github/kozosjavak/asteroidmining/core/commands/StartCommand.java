package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;

public class StartCommand implements Command {
    @Override
    public void apply(Game game) {
        try {
            //game.startGame(5);
        } catch (Exception exception) {
            exception.printStackTrace(); // TODO
        }
    }
}
