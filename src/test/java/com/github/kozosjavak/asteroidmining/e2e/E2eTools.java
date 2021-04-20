package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.console.ConsoleCommandExecutor;
import com.github.kozosjavak.asteroidmining.core.Game;

import java.io.InputStream;

public class E2eTools {
    static Game getGame(InputStream in) {
        Game game = new Game(20, 20);
        ConsoleCommandExecutor cce = new ConsoleCommandExecutor(game);
        cce.attachToConsole(in);
        return game;
    }
}
