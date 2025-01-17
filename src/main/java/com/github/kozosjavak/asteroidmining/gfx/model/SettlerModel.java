package com.github.kozosjavak.asteroidmining.gfx.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class SettlerModel extends Model {
    public SettlerModel(TextureAtlas atlas, Vector2 position, boolean isSelected) {
        super(atlas, position);
        if (isSelected) {
            texture = atlas.findRegion("selectedSpaceShip");
        } else {
            texture = atlas.findRegion("spaceShip");
        }

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x - texture.getRegionWidth(), position.y - texture.getRegionHeight());
    }

    @Override
    public void coreObjectToModelObject() {
    }
}
