package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InformationTable {
    private final BitmapFont font;
    private final SpriteBatch batch;
    private String text;

    public InformationTable(SpriteBatch batch) {
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        this.batch = batch;
    }

    public void draw() {

        font.draw(batch, text, 875, 40);
    }

    public void setText(String text) {
        if (text != null) {
            this.text = text;
        }
    }
}
