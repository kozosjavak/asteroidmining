package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.Inventory;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Aszteroida osztály
 */
public class Asteroid extends Orb implements Explodeable {

    /**
     * Napközelben van-e az aszteroida
     */
    private final boolean inSunZone;

    /**
     * Inicializálandó szomszédos aszteroidák száma
     */
    private final int numberOfChildren;

    /**
     * Aszteroidában a kibányászása után tárolt nyersanyaglista
     */
    private final Inventory asteroidInventory = new Inventory(0);
    /**
     * Aszteroidán levő űrhajók listája
     */
    private final List<Spaceship> residence = new CopyOnWriteArrayList<>();
    /**
     * Aszteroida kéregvastagsága
     */
    private int surfaceThickness;
    /**
     * Aszteroida magjában levő nyersanyag
     */
    private Material substance;

    /**
     * Aszteroida konstruktor
     *
     * @param surfaceThickness inicializálandó kéregvastagság
     * @param inSunZone        napközelben van-e az inicializáladnó aszteroida
     * @param substance        aszteroida magjába inicializálandó nyersanyag
     * @param numberOfChildren inicializálandó szomszédos aszteroidák száma
     */
    public Asteroid(Location location, int surfaceThickness, boolean inSunZone, Material substance, int numberOfChildren) {
        super(location);
        this.surfaceThickness = surfaceThickness;
        this.inSunZone = inSunZone;
        this.substance = substance;
        this.numberOfChildren = numberOfChildren;
    }

    public List<Spaceship> getResidence() {
        return Collections.unmodifiableList(residence);
    }

    public List<Material> getMaterials() {
        return asteroidInventory.getList();
    }

    public boolean isInSunZone() {
        return inSunZone;
    }

    public Inventory getAsteroidInventory() {
        return asteroidInventory;
    }

    /**
     * Űrhajó lehelyezése az aszteroidára
     *
     * @param spaceShip a lehelyezendő űrhajó
     */
    public void addSpaceShip(Spaceship spaceShip) {
        residence.add(spaceShip);
    }

    /**
     * Űrhajó eltávolítása az aszteroidáról
     *
     * @param spaceShip az eltávolítandó űrhajó
     */
    public void removeSpaceship(Spaceship spaceShip) {
        residence.remove(spaceShip);
    }

    /**
     * Nyersanyag bányászása
     *
     * @return kibányászott nyersanyag
     */
    public Material mine() throws AsteroidIsNotMineable {
        if (surfaceThickness <= 0 && substance != null) {
            Material temp = substance;
            substance = null;
            return temp;
        } else {
            throw new AsteroidIsNotMineable();
        }
    }

    /**
     * removes a layer of crust from the asteroid itself
     *
     * @throws SurfaceThicknessIsZeroException if its already removed to zero
     */
    public void drill() throws SurfaceThicknessIsZeroException, NotEnoughMaterialException {
        if (surfaceThickness == 1) {

            substance.experienceExtremeHeat(this);

        }

        if (surfaceThickness > 0) {
            surfaceThickness--;
        } else {
            throw new SurfaceThicknessIsZeroException();
        }
    }

    /**
     * Aszteroida felrobbanása
     */
    public void explode() {
        for (Spaceship spaceship : residence) {
            spaceship.explode();
        }
        residence.clear();
        getLocation().fullClearByExplosion();
    }

    /**
     * Berakja a megadott nyersanyagot a map-ba
     *
     * @param material a berakandó nyersanyag
     */
    public void insertMaterial(Material material) throws AsteroidNotMinedException, InventoryIsFullException {
        if (substance == null) {
            asteroidInventory.add(material);
        } else {
            throw new AsteroidNotMinedException();
        }
    }

    /**
     * Megadott nyersanyag eltávolítása a map-ból, ha lehetséges
     *
     * @param materialToRemove az eltávolítandó nyersanyag
     * @throws NotEnoughMaterialException ha nincs elég nyersanyag, amiből el lehetne távolítani
     */
    public void removeMaterial(Material materialToRemove) throws NotEnoughMaterialException {
        asteroidInventory.remove(materialToRemove.getClass(), 1);

    }

    @Override
    public void removeSubstance() {
        substance = null;
    }

    /**
     * Űrbázis építése
     */
    public void buildBase() {
        System.out.println("Base builded!");
        getLocation().game.Win();
    }

    /**
     * Napvihar átélése
     */
    @Override
    public void experienceSolarStorm() {
        for (Spaceship spaceShip : residence) {
            spaceShip.experienceSolarStorm();
        }
    }

    @Override
    public void experienceExtremeHeat() throws NotEnoughMaterialException {
        if (surfaceThickness == 0 && substance != null) {
            substance.experienceExtremeHeat(this);
        } else {
            asteroidInventory.experienceExtremeHeat(this);
        }
        for (Spaceship spaceship : residence) {
            spaceship.experienceExtremeHeat();
        }

    }

    public int getSurfaceThickness() {
        return surfaceThickness;
    }
}
