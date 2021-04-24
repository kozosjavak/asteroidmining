package com.github.kozosjavak.asteroidmining.gfx.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class RobotModel extends Model {
    public RobotModel(TextureAtlas atlas, Vector2 position) {
        super(atlas, position);
        texture = atlas.findRegion("robot");
    }

    @Override
    public void draw(SpriteBatch batch) {
    }

    @Override
    public void coreObjectToModelObject() {
    }
}
