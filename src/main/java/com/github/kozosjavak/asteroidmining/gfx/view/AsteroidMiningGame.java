package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.github.kozosjavak.asteroidmining.core.Location;
import com.github.kozosjavak.asteroidmining.core.Sun;
import com.github.kozosjavak.asteroidmining.gfx.model.Model;
import com.github.kozosjavak.asteroidmining.gfx.model.SunModel;

import java.util.ArrayList;
import java.util.List;

public class AsteroidMiningGame extends Game {

    GameScreen gameScreen;
    private final com.github.kozosjavak.asteroidmining.core.Game game;
    private final TextureAtlas textureAtlas;

    public AsteroidMiningGame(com.github.kozosjavak.asteroidmining.core.Game game) {
        this.game = game;
        textureAtlas = new TextureAtlas("images.atlas");
        Location sunLocation = new Location(game, 0.0, 0.0);
        game.setSun(new Sun(sunLocation));

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
        updateModellList();
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
    private void updateModellList() {
        List<Model> modelList = new ArrayList<>();
        modelList.add(new SunModel(textureAtlas, new Vector2((float) game.getSun().getLocation().getCoordinate().getX(), (float) game.getSun().getLocation().getCoordinate().getY())));
        //for (Location location : game.getLocationList()) {
        //    //aszteroidak, urhajok, portalok
        //}
        gameScreen.updateModelList(modelList);
    }


}
