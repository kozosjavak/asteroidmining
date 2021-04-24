package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.Game;

public class AsteroidMiningGame extends Game {

    GameScreen gameScreen;
    private final com.github.kozosjavak.asteroidmining.core.Game game;

    public AsteroidMiningGame(com.github.kozosjavak.asteroidmining.core.Game game) {
        this.game = game;
    }

    @Override
    public void create() {
        gameScreen = new GameScreen();
        setScreen(gameScreen);
    }

    @Override
    public void dispose() {
        gameScreen.dispose();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        gameScreen.resize(width, height);
    }


}
