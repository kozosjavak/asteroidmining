package com.github.kozosjavak.asteroidmining.gfx.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class UfoModel extends Model {
    public UfoModel(TextureAtlas atlas, Vector2 position) {
        super(atlas, position);
        texture = atlas.findRegion("ufo");
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x - texture.getRegionWidth(), position.y - texture.getRegionHeight());
    }

    @Override
    public void coreObjectToModelObject() {
    }
}
