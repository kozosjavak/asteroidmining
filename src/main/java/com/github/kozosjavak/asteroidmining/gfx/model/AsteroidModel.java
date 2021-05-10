package com.github.kozosjavak.asteroidmining.gfx.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class AsteroidModel extends Model {
    private final int texture_index;
    private final TextureAtlas.AtlasRegion selected_texture;
    private final boolean hole;
    private final TextureAtlas.AtlasRegion holeTexture;
    private final boolean selected;

    public AsteroidModel(TextureAtlas atlas, Vector2 position, int texture_index, boolean hole, boolean selected) {
        super(atlas, position);
        holeTexture = atlas.findRegion("hole");
        this.hole = hole;
        this.selected = selected;
        //Itt kene random szam az indexhez, hogy osszevissza kinezetu aszteroidak legyenek
        this.texture_index = texture_index;
        texture = atlas.findRegion("spaceMeteors", texture_index);
        selected_texture = atlas.findRegion("selectedSpaceMeteors", texture_index);
    }

    @Override
    public void draw(SpriteBatch batch) {
        if (selected) {
            batch.draw(selected_texture, position.x - texture.getRegionWidth(), position.y - texture.getRegionHeight());
        }
        batch.draw(texture, position.x - texture.getRegionWidth(), position.y - texture.getRegionHeight());
        if (hole) {
            batch.draw(holeTexture, position.x - holeTexture.getRegionWidth(), position.y - holeTexture.getRegionHeight() - 5);
        }
    }

    @Override
    public void coreObjectToModelObject() {
    }
}
