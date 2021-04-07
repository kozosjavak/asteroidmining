package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.Inventory;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
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

    /**
     * Bányászás
     * Nyersanyag kibányászása azon az aszteroidán, amelyen a telepes épp tartózkodik
     *
     * @throws InventoryIsFullException az inventory tele van kivétel
     * @throws AsteroidIsNotMineable    az asteroida nem bányászható állapotban van
     */
    public void mine() throws InventoryIsFullException, AsteroidIsNotMineable {
        inventory.add(getCurrentAsteroid().mine());
    }

    @Override
    public void experienceExtremeHeat() throws NotEnoughMaterialException {
        if (inventory.getSize() != 0) {
            inventory.experienceExtremeHeat(this);
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
