package com.github.kozosjavak.asteroidmining;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.gfx.view.AsteroidMiningGame;

/**
 * Főprogram
 */
public class Main {

    /**
     * Belépési pont
     * @param args az argumentumok
     */
    public static void main(String[] args) {
        Game game = new Game(7680, 4320);
        AsteroidMiningGame gameGfx = new AsteroidMiningGame(game);
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1920;
        config.height = 1080;
        config.resizable = true;
        config.vSyncEnabled = true;
        config.useHDPI = true;
        LwjglApplication application = new LwjglApplication(gameGfx, config);


        //  ConsoleCommandExecutor cce = new ConsoleCommandExecutor(game);
        //  cce.attachToConsole(System.in);
    }

}