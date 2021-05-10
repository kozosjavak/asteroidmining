package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.kozosjavak.asteroidmining.core.Location;
import com.github.kozosjavak.asteroidmining.core.Settler;

import java.util.ArrayList;
import java.util.List;

public class AsteroidListTable {
    private final BitmapFont font;
    private final SpriteBatch batch;
    private final GameScreen gameScreen; //csak erzsike miatt
    private final AsteroidMiningGame game;
    private final List<Location> locations;
    //private Location selected;
    private Settler currentSettler;
    // private String text;

    public AsteroidListTable(SpriteBatch batch, GameScreen gameScreen, AsteroidMiningGame game) {
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        this.batch = batch;
        this.gameScreen = gameScreen;
        this.game = game;
        this.currentSettler = null;
        locations = new ArrayList<>();
    }

    public void setCurrentSettler(Settler currentSettler) {
        this.currentSettler = currentSettler;
    }

    //public Location getSelected() {
    //   return selected;
    // }

    public Location getListLocation(int x, int y) {
        if (currentSettler == null) {
            return null;
        }
        locations.clear();
        locations.addAll(currentSettler.getCurrentAsteroid().getLocation().getNeighbors());
        if (x >= 1612 / game.getDivider() && x <= 1612 + 378) {
            if (y >= 73 / game.divider && y <= (73 + 40) / game.divider) {
                if (locations.size() >= 1) {
                    game.setSelectedLocation(locations.get(0));
                    return locations.get(0);
                }

            }
            if (y >= (73 + 40) / game.divider && y <= (73 + 80) / game.divider) {
                if (locations.size() >= 2) {
                    game.setSelectedLocation(locations.get(1));
                    return locations.get(1);
                }
            }
            if (y >= (73 + 80) / game.divider && y <= (73 + 120) / game.divider) {
                if (locations.size() >= 3) {
                    game.setSelectedLocation(locations.get(2));

                    return locations.get(2);
                }
            }
            if (y >= (73 + 120) / game.divider && y <= (73 + 160) / game.divider) {

                if (locations.size() >= 4) {
                    game.setSelectedLocation(locations.get(3));
                    return locations.get(3);
                }
            }
            if (y >= (73 + 160) / game.divider && y <= (73 + 200) / game.divider) {
                if (locations.size() >= 5) {
                    game.setSelectedLocation(locations.get(4));
                    return locations.get(4);
                }
            }
            if (y >= (73 + 200) / game.divider && y <= (73 + 240) / game.divider) {
                if (locations.size() >= 6) {
                    game.setSelectedLocation(locations.get(5));
                    return locations.get(5);
                }
            }
            if (y >= (73 + 240) / game.divider && y <= (73 + 280) / game.divider) {
                if (locations.size() >= 7) {
                    game.setSelectedLocation(locations.get(6));
                    return locations.get(6);
                }
            }
            if (y >= (73 + 280) / game.divider && y <= (73 + 320) / game.divider) {
                if (locations.size() >= 8) {
                    game.setSelectedLocation(locations.get(7));
                    return locations.get(7);
                }
            }
            if (y >= (73 + 320) / game.divider && y <= (73 + 360) / game.divider) {
                if (locations.size() >= 9) {
                    game.setSelectedLocation(locations.get(8));
                    return locations.get(8);
                }
            }
            if (y >= (73 + 360) / game.divider && y <= (73 + 400) / game.divider) {
                if (locations.size() >= 10) {
                    game.setSelectedLocation(locations.get(9));
                    return locations.get(9);
                }
            }
        }
        return game.getSelectedLocation();
    }

    public void draw() {


        locations.clear();
        locations.addAll(currentSettler.getCurrentAsteroid().getLocation().getNeighbors());
        for (int i = 0; i < (Math.min(locations.size(), 10)); i++) {
            if (locations.get(i) == game.getSelectedLocation())
                font.setColor(Color.BLUE);
            font.draw(batch, "Asteroid no.: " + (i + 1), (float) 805, (float) (780 - ((i + 1) * 20)));
            font.setColor(Color.BLACK);
        }

    }

}
