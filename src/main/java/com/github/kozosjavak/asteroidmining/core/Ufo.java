package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.Inventory;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

import java.util.List;
import java.util.Random;

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
    public void step() throws AsteroidIsNotMineable, InventoryIsFullException {
        if (getCurrentAsteroid().getSurfaceThickness() == 0 && getCurrentAsteroid().getSubstance() != null) {
            mine();
        } else if (getCurrentAsteroid().getAsteroidInventory().getSize() > 0 && getCurrentAsteroid().getLocation().game.randomGenerator(80)) {
            steal();
        } else if (getCurrentAsteroid().getLocation().game.randomGenerator(30)) {
            try {
                move(getCurrentAsteroid().getLocation().getRandomNeighbor());
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }

    }

    public void steal() {
        Random rand = new Random();
        List<Material> materials = getCurrentAsteroid().getMaterials();
        Material material = materials.get(rand.nextInt(materials.size()) - 1);
        try {
            getCurrentAsteroid().removeMaterial(material);
            inventory.add(material);
        } catch (NotEnoughMaterialException | InventoryIsFullException e) {
            e.printStackTrace();
        }
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
    public void experienceExtremeHeat() throws Exception {
        if (inventory.getSize() != 0) {
            inventory.experienceExtremeHeat(this);
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
