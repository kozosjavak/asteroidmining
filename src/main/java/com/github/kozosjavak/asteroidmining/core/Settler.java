package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.bills.Bills;
import com.github.kozosjavak.asteroidmining.core.materials.Inventory;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

/**
 * Telepes osztály
 */
public class Settler extends Spaceship implements Steppable {

    /**
     * A telepes inventory-ja
     */
    private final Inventory inventory = new Inventory(10);
    // ez egy issue
    private final Teleport[] teleportInventory = new Teleport[3];

    /**
     * Telepes konstruktor
     *
     * @param asteroid aszteroida, melyre a telepes kerül
     */
    public Settler(Asteroid asteroid) {
        super(asteroid);
        Game.addASettlerInNumberOfSettler();
    }

    @Override
    public String toString() {
        return "bla";
    }

    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Bányászás
     * Nyersanyag kibányászása azon az aszteroidán, amelyen a telepes épp tartózkodik
     *
     * @throws InventoryIsFullException az inventory tele van kivétel
     */
    public void mine() throws InventoryIsFullException, AsteroidIsNotMineable {
        inventory.add(getCurrentAsteroid().mine());
    }

    /**
     * Teleportpár építése
     */
    public void buildTeleportPair() throws NotEnoughMaterialException {

        if (Bills.TELEPORT.buy(inventory)) {
            Teleport t1 = new Teleport();
            Teleport t2 = new Teleport(t1);
            t1.setPair(t2);
            //elkene vhogy menteni
        }

    }


    /**
     * Bázis építése
     * Aktuális aszteroida inventorijából buy segítségével
     */
    public void buildBase() throws NotEnoughMaterialException {
        if (Bills.BASE.buy(inventory))
            getCurrentAsteroid().buildBase();
    }

    /**
     * Robot építése
     * A robotot arra az aszteroidára helyezi le, amelyen maga a telepes is tartózkodik
     */
    public void buildRobot() throws NotEnoughMaterialException {
        if (Bills.ROBOT.buy(inventory)) {
            Robot robot = new Robot(getCurrentAsteroid());

        }
    }


    /**
     * Teleportkaput helyez a megadott aszteroidára
     *
     * @param asteroid aszteroida, melyre a teleportot helyezzük
     */
    public void deployTeleport(Asteroid asteroid) {

    }

    /**
     * Telepes megsemmisülése
     */
    @Override
    public void die() {
        Game.removeASettlerInNumberOfSettler();
        getCurrentAsteroid().removeSpaceship(this);
    }


    /**
     * Napvihar elszenvedése
     */
    @Override
    public void experienceSolarStorm() {
    }

    /**
     * Űrhajó típusának lekérdezése
     *
     * @return az űrhajó típusa
     */


    /**
     * Lépés implementációja
     */
    @Override
    public void step() {
        //itt kontrollalsz
        //hivd meg a drill().
    }

    @Override
    public void explode() {

        getCurrentAsteroid().explode();
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

