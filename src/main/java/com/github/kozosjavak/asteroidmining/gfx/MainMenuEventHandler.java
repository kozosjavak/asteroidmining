package com.github.kozosjavak.asteroidmining.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.github.kozosjavak.asteroidmining.gfx.view.AsteroidMiningGame;
import com.github.kozosjavak.asteroidmining.gfx.view.MainMenuScreen;

public class MainMenuEventHandler implements InputProcessor {
    MainMenuScreen screen;
    GuiEventHandler guiEventHandler;
    AsteroidMiningGame game;

    public MainMenuEventHandler(MainMenuScreen screen, GuiEventHandler guiEventHandler) {
        super();
        this.screen = screen;
        this.guiEventHandler = guiEventHandler;
        this.game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (screenX >= 1638 && screenX <= 1638 + 476 && screenY >= 831 && screenY <= 831 + 192) {
            Gdx.input.setInputProcessor(guiEventHandler);
            System.out.println("Screen valtva");
            screen.setScreenToGame();
        }
        System.out.println(screenX + " " + screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
