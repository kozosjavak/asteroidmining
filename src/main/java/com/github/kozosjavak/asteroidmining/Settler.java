package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.bills.Bills;
import com.github.kozosjavak.asteroidmining.materials.Inventory;
import com.github.kozosjavak.asteroidmining.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.materials.NotEnoughMaterialException;

/**
 * Telepes osztály
 */
public class Settler extends Spaceship implements Steppable {

    /**
     * A telepes inventory-ja
     */
    private final Inventory inventory = new Inventory(10);

    /**
     * Teleportpár a telepesnél
     */
    private TeleportPair teleportPair = null;

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
        return "Settler@" + Integer.toHexString(hashCode()) + "{" +
                ("\n" + "inventory=\n" + inventory
                ).indent(4) +
                "teleportPair=\n" + teleportPair +
                "}";
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

    }

    /**
     * Teleportpár építése
     */
    public void buildTeleportPair() throws NotEnoughMaterialException {

        if (Bills.TELEPORT.buy(inventory))
            teleportPair = new TeleportPair();
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
        //if(teleportPair != null)
        teleportPair.deployTeleport(asteroid);
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
     * Robbanás elszenvedése
     */
    @Override
    public void getHitByExplosion() {
        die();
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
    @Override
    public String getType() {
        return "Settler";
    }

    /**
     * Lépés implementációja
     */
    @Override
    public void step() {

    }
}

