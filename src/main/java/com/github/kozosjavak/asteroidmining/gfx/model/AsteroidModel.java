package com.github.kozosjavak.asteroidmining.gfx.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class AsteroidModel extends Model {
    private final int texture_index;
    private final TextureAtlas.AtlasRegion selected_texture;
    private final boolean hole;
    private final TextureAtlas.AtlasRegion holeTexture;
    private final boolean selected;
    private final boolean crate;
    private final TextureAtlas.AtlasRegion crateTexture;
    private final int residence;
    private final BitmapFont font;
    private final SpriteBatch batch;


    public AsteroidModel(TextureAtlas atlas, Vector2 position, int texture_index, boolean hole, boolean selected, boolean crate, int residence, SpriteBatch batch) {
        super(atlas, position);
        font = new BitmapFont();
        font.setColor(Color.RED);
        this.batch = batch;

        holeTexture = atlas.findRegion("hole");
        crateTexture = atlas.findRegion("crate");
        this.hole = hole;
        this.selected = selected;
        this.crate = crate;
        this.residence = residence;
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
        if (crate) {
            batch.draw(crateTexture, position.x - crateTexture.getRegionWidth() - 10, position.y - crateTexture.getRegionHeight() + 8);
        }
        if (residence > 1) {
            font.draw(batch, Integer.toString(residence), position.x, position.y);
        }
    }

    @Override
    public void coreObjectToModelObject() {
    }
}
