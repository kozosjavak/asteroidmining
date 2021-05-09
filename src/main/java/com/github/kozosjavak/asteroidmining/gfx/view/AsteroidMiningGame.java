package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.github.kozosjavak.asteroidmining.core.*;
import com.github.kozosjavak.asteroidmining.gfx.GuiEventHandler;
import com.github.kozosjavak.asteroidmining.gfx.model.*;

import java.util.ArrayList;
import java.util.List;

public class AsteroidMiningGame extends Game {

    private final com.github.kozosjavak.asteroidmining.core.Game game;
    GameScreen gameScreen;
    MainMenuScreen mainMenuScreen;
    GuiEventHandler eventHandler;

    public AsteroidMiningGame(com.github.kozosjavak.asteroidmining.core.Game game) {
        this.game = game;
    }

    public com.github.kozosjavak.asteroidmining.core.Game getGame() {
        return game;
    }

    @Override
    public void create() {
        gameScreen = new GameScreen(this);
        eventHandler = new GuiEventHandler(this);
        mainMenuScreen = new MainMenuScreen(this, gameScreen, eventHandler);
        setScreen(mainMenuScreen);

    }

    @Override
    public void dispose() {
        gameScreen.dispose();
    }

    @Override
    public void render() {
        if (gameScreen.getClass() == GameScreen.class) {
            updateModelList();
        }
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        gameScreen.resize(width, height);
    }

    /**
     * Olyan sorrendbe kell a listat feltolteni ahogyan azt meg akarjuk jeleniteni
     * Ha nem tudunk castolni floatra akkor at kell irni a gamebe
     */
    private void updateModelList() {
        if (game.getSun() != null) {
            List<Model> modelList = new ArrayList<>();
            modelList.add(new SunModel(gameScreen.getTextureAtlas(), new Vector2((float) game.getSun().getLocation().getCoordinate().getX(), (float) game.getSun().getLocation().getCoordinate().getY()), game.getSun().isSolarStorm()));
            for (Location location : game.getLocationList()) {
                if (location.getCelestialBody() == null)
                    continue;
                if (location.getCelestialBody().getClass() == Asteroid.class && location.getCelestialBody() != null) {
                    Asteroid as = (Asteroid) location.getCelestialBody();
                    modelList.add(new AsteroidModel(gameScreen.getTextureAtlas(), new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY()), as.getTexture_index()));
                }
                if (location.getTeleport() != null) {
                    modelList.add(new TeleportModel(gameScreen.getTextureAtlas(), new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY())));
                }
                if (location.getCelestialBody().getClass() == Asteroid.class && location.getCelestialBody() != null) {
                    Asteroid asteroid = (Asteroid) location.getCelestialBody();
                    for (Spaceship sp : asteroid.getResidence()) {
                        if (sp.getClass() == Settler.class) {
                            modelList.add(new SettlerModel(gameScreen.getTextureAtlas(), new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY()), ((Settler) sp).isSelected()));
                        } else if (sp.getClass() == Ufo.class) {
                            modelList.add(new UfoModel(gameScreen.getTextureAtlas(), new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY())));
                        } else if (sp.getClass() == Robot.class) {
                            modelList.add(new RobotModel(gameScreen.getTextureAtlas(), new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY())));
                        }
                    }
                }
            }
            gameScreen.updateModelList(modelList);
        }
    }


}
