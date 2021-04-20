package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.console.ConsoleCommandExecutor;
import com.github.kozosjavak.asteroidmining.core.Game;

/**
 * Főprogram
 */
public class Main {

    /**
     * Belépési pont
     * @param args az argumentumok
     */
    public static void main(String[] args) {
        Game game = new Game(20, 20);
        ConsoleCommandExecutor cce = new ConsoleCommandExecutor(game);
        cce.attachToConsole(System.in);
    }

}