package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.github.kozosjavak.asteroidmining.core.*;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.gfx.model.*;

import java.util.ArrayList;
import java.util.List;

public class AsteroidMiningGame extends Game {

    private final com.github.kozosjavak.asteroidmining.core.Game game;

    GameScreen gameScreen;

    public AsteroidMiningGame(com.github.kozosjavak.asteroidmining.core.Game game) {
        this.game = game;

    }

    private void setScene(com.github.kozosjavak.asteroidmining.core.Game game) {
        Location sunLocation = new Location(game, 3840.0, 2160.0);
        game.setSun(new Sun(sunLocation));

        Location locationAsteroid = new Location(game, 4200.0, 1800.0);
        Asteroid asteroid = new Asteroid(locationAsteroid, 1, new Coal());
        game.addLocation(locationAsteroid);

        Location locationAsteroidSettler = new Location(game, 4600.0, 2160.0);
        Asteroid asteroidSettler = new Asteroid(locationAsteroidSettler, 1, new Coal());
        Settler settler = new Settler(asteroidSettler);
        game.addLocation(locationAsteroidSettler);

        Location locationAsteroidUfo = new Location(game, 5000.0, 2160.0);
        Asteroid asteroidUfo = new Asteroid(locationAsteroidUfo, 1, new Coal());
        Ufo ufo = new Ufo(asteroidUfo);
        game.addLocation(locationAsteroidUfo);

        Location locationAsteroidRobot = new Location(game, 2500.0, 2160.0);
        Asteroid asteroidRobot = new Asteroid(locationAsteroidRobot, 1, new Coal());
        Robot robot = new Robot(asteroidRobot);
        game.addLocation(locationAsteroidRobot);
    }

    @Override
    public void create() {
        gameScreen = new GameScreen();
        setScreen(gameScreen);
        setScene(game);
    }

    @Override
    public void dispose() {
        gameScreen.dispose();
    }

    @Override
    public void render() {
        updateModelList();
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

        List<Model> modelList = new ArrayList<>();
        modelList.add(new SunModel(gameScreen.getTextureAtlas(), new Vector2((float) game.getSun().getLocation().getCoordinate().getX(), (float) game.getSun().getLocation().getCoordinate().getY())));
        for (Location location : game.getLocationList()) {
            if (location.getCelestialBody() == null)
                continue;
            if (location.getCelestialBody().getClass() == Asteroid.class && location.getCelestialBody() != null) {
                modelList.add(new AsteroidModel(gameScreen.getTextureAtlas(), new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY())));
            }
            if (location.getTeleport() != null) {
                modelList.add(new TeleportModel(gameScreen.getTextureAtlas(), new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY())));
            }
            if (location.getCelestialBody().getClass() == Asteroid.class && location.getCelestialBody() != null) {
                Asteroid asteroid = (Asteroid) location.getCelestialBody();
                for (Spaceship sp : asteroid.getResidence()) {
                    if (sp.getClass() == Settler.class) {
                        modelList.add(new SettlerModel(gameScreen.getTextureAtlas(), new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY())));
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
