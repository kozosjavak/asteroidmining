package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.Inventory;

public class Ufo extends Spaceship implements Steppable {

    /**
     * Az ufo inventory-ja
     */
    private final Inventory inventory = new Inventory(0);

    /**
     * Ufo konstruktor
     *
     * @param asteroid aszteroida, amire az ufo kerül
     */
    public Ufo(Asteroid asteroid) {
        super(asteroid);
    }

    /**
     * Lépés implementációja
     */
    @Override
    public void step() {

    }
}
