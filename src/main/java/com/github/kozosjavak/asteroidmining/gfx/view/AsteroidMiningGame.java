package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.github.kozosjavak.asteroidmining.core.*;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.gfx.model.*;

import java.util.ArrayList;
import java.util.List;

public class AsteroidMiningGame extends Game {

    private final com.github.kozosjavak.asteroidmining.core.Game game;
    private final TextureAtlas textureAtlas;
    GameScreen gameScreen;

    public AsteroidMiningGame(com.github.kozosjavak.asteroidmining.core.Game game) {
        this.game = game;
        textureAtlas = new TextureAtlas("kozosjavak_astpck.atlas");
        Location sunLocation = new Location(game, 0.0, 0.0);
        game.setSun(new Sun(sunLocation));

        Location locationAsteroid = new Location(game, 50.0, 50.0);
        Asteroid asteroid = new Asteroid(locationAsteroid, 1, new Coal());
        game.addLocation(locationAsteroid);

        Location locationAsteroidSettler = new Location(game, 250.0, 50.0);
        Asteroid asteroidSettler = new Asteroid(locationAsteroid, 1, new Coal());
        Settler settler = new Settler(asteroidSettler);
        game.addLocation(locationAsteroidSettler);

        Location locationAsteroidUfo = new Location(game, 50.0, 250.0);
        Asteroid asteroidUfo = new Asteroid(locationAsteroid, 1, new Coal());
        Ufo ufo = new Ufo(asteroidUfo);
        game.addLocation(locationAsteroidUfo);

        Location locationAsteroidRobot = new Location(game, 1000.0, 1000.0);
        Asteroid asteroidRobot = new Asteroid(locationAsteroid, 1, new Coal());
        Robot robot = new Robot(asteroidRobot);
        game.addLocation(locationAsteroidRobot);
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
        modelList.add(new SunModel(textureAtlas, new Vector2((float) game.getSun().getLocation().getCoordinate().getX(), (float) game.getSun().getLocation().getCoordinate().getY())));
        for (Location location : game.getLocationList()) {
            if (location.getOrb().getClass() == Asteroid.class && location.getOrb() != null) {
                modelList.add(new AsteroidModel(textureAtlas, new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY())));
            }
            if (location.getTeleport() != null) {
                modelList.add(new TeleportModel(textureAtlas, new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY())));
            }
            if (location.getOrb().getClass() == Asteroid.class && location.getOrb() != null) {
                Asteroid asteroid = (Asteroid) location.getOrb();
                for (Spaceship sp : asteroid.getResidence()) {
                    if (sp.getClass() == Settler.class) {
                        modelList.add(new SettlerModel(textureAtlas, new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY())));
                    } else if (sp.getClass() == Ufo.class) {
                        modelList.add(new UfoModel(textureAtlas, new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY())));
                    } else if (sp.getClass() == Robot.class) {
                        modelList.add(new RobotModel(textureAtlas, new Vector2((float) location.getCoordinate().getX(), (float) location.getCoordinate().getY())));
                    }
                }
            }
        }
        gameScreen.updateModelList(modelList);
    }


}
