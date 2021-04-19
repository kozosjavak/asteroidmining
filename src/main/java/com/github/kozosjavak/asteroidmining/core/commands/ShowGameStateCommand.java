package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;

/**
 * Kiírja az összes létrehozott objektum állapotát
 */
public class ShowGameStateCommand implements Command {

    @Override
    public void apply(Game game) throws Exception {
        System.out.printf("<ShowGameState starts>\n" + game.toString(0) + "<ShowGameState ends>\n");
    }
}
