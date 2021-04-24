package com.github.kozosjavak.asteroidmining.gfx.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class SunModel extends Model {

    public SunModel(TextureAtlas atlas, Vector2 position) {
        super(atlas, position);
        texture = atlas.findRegion("sun");
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    @Override
    public void coreObjectToModelObject() {
    }
}
