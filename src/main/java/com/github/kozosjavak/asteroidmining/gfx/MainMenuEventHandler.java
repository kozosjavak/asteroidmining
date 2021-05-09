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
    int divider = 1;

    public MainMenuEventHandler(MainMenuScreen screen, GuiEventHandler guiEventHandler, AsteroidMiningGame game, int divider) {
        super();
        this.divider = divider;
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

        if (screenX >= 1638 / divider && screenX <= 1638 / divider + 476 / divider && screenY >= 831 / divider && screenY <= 831 / divider + 192 / divider) {
            Gdx.input.setInputProcessor(guiEventHandler);
            System.out.println("Screen valtva");
            game.getJanosHegyen().play();
            screen.setScreenToGame();
        }
        if ((screenX >= 1638 / 2 && screenX <= 1638 / 2 + 476 / 2 && screenY >= 831 / 2 && screenY <= 831 / 2 + 192 / 2)) {
            game.setDivider(2);
            divider = 2;
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
