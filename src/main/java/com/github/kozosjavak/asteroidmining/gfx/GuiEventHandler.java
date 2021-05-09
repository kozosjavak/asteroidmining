package com.github.kozosjavak.asteroidmining.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.Steppable;
import com.github.kozosjavak.asteroidmining.gfx.view.AsteroidMiningGame;

import java.util.ArrayList;
import java.util.List;

public class GuiEventHandler implements InputProcessor {
    AsteroidMiningGame game;

    public GuiEventHandler(AsteroidMiningGame game) {
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
        List<Steppable> settlerList = new ArrayList<>(game.getGame().getSettlers());

        for (Steppable settler : settlerList) {
            Settler currentSettler = (Settler) settler;
            if (currentSettler.isSelected()) {
                try {
                    currentSettler.drill();
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                currentSettler.setSelectedFalse();
                System.out.println(currentSettler.getCurrentAsteroid().getSurfaceThickness());
            }
        }
        //System.out.println(screenX + " " + screenY);

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
