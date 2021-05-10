package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InformationTable {
    private final BitmapFont font;
    private final SpriteBatch batch;
    private final GameScreen gameScreen; //csak erzsike miatt
    private String text;

    public InformationTable(SpriteBatch batch, GameScreen gameScreen) {
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        this.batch = batch;
        this.gameScreen = gameScreen;
    }

    public void draw() {

        font.draw(batch, text, 810, 75);
    }

    public void setText(String text) {
        if (text != null) {
            this.text = gameScreen.getRandomErzsike() + "\n" + text;
        }
    }
}
