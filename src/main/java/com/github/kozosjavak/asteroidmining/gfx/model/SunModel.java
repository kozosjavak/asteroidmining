package com.github.kozosjavak.asteroidmining.gfx.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class SunModel extends Model {
    boolean isSunShine;
    TextureRegion radiance;
    boolean isRadiant;
    float sunCenteX;
    float sunCenterY;

    public SunModel(TextureAtlas atlas, Vector2 position, boolean isSunShine) {
        super(atlas, position);
        radiance = atlas.findRegion("sunStorm");
        this.isSunShine = isSunShine;
        if (isSunShine) {
            isRadiant = true;
            texture = atlas.findRegion("ssuuuuuunnnn");
        } else {
            isRadiant = false;
            texture = atlas.findRegion("sun");
        }
        sunCenteX = position.x - texture.getRegionWidth() / 2;
        sunCenterY = position.y - texture.getRegionHeight() / 2;
    }

    @Override
    public void draw(SpriteBatch batch) {
        if (isRadiant) {
            batch.draw(radiance, sunCenteX - radiance.getRegionWidth() / 2 + 30, sunCenterY - radiance.getRegionHeight() / 2 + 30);
        }
        batch.draw(texture, sunCenteX, sunCenterY);
    }

    @Override
    public void coreObjectToModelObject() {
    }
}
