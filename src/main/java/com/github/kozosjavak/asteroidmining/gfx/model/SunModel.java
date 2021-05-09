package com.github.kozosjavak.asteroidmining.gfx.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class SunModel extends Model {
    boolean isSunShine;

    public SunModel(TextureAtlas atlas, Vector2 position, boolean isSunShine) {
        super(atlas, position);
        this.isSunShine = isSunShine;
        if (isSunShine) {
            texture = atlas.findRegion("ssuuuuuunnnn");
        } else {
            texture = atlas.findRegion("sun");
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
