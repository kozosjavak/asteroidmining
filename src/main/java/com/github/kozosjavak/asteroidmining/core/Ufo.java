package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.Inventory;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

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

    @Override
    public void experienceExtremeHeat() throws NotEnoughMaterialException {
        if (inventory.getSize() != 0) {
            for (Material material : inventory.getList()) {
                material.experienceExtremeHeat(this);
            }
        }
    }
}
