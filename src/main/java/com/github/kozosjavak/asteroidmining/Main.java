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
        Game game = new Game(800, 800);

        AsteroidMiningGame gameGfx = new AsteroidMiningGame(game);
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = 1200;
        config.height = 800;
        config.resizable = false;
        config.vSyncEnabled = true;
        config.useHDPI = true;
        LwjglApplication application = new LwjglApplication(gameGfx, config);
        // GuiEventHandler inputProcessor = new GuiEventHandler();
        //Gdx.input.setInputProcessor(inputProcessor);
        try {
            game.startGame(160, 5, 100, 5, 3);
        } catch (Exception exception) {
            exception.printStackTrace();
        }


        //  ConsoleCommandExecutor cce = new ConsoleCommandExecutor(game);
        //  cce.attachToConsole(System.in);
    }

}