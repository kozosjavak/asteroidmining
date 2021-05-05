package com.github.kozosjavak.asteroidmining.gfx.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Model {
    TextureRegion texture;
    Vector2 position;

    public Model(TextureAtlas atlas, Vector2 position) {
        this.position = position;
       //this.position.set(this.position.x,this.position.y);

    }

    public void draw(SpriteBatch batch) {
    }

    public void coreObjectToModelObject() {
    }
}
