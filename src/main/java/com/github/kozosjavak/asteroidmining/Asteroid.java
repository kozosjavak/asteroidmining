package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.materials.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Aszteroida osztály
 */
public class Asteroid extends Orb {

    /** Napközelben van-e az aszteroida */
    private final boolean inSunZone;

    /** Inicializálandó szomszédos aszteroidák száma */
    private final int numberOfChildren;

    /** Aszteroidában a kibányászása után tárolt nyersanyaglista */
    private final Map<Material, Integer> asteroidInventory = new HashMap<>();

    /** Aszteroidán levő űrhajók listája */
    private final List<Spaceship> residence = new ArrayList<>();

    /** Aszteroida kéregvastagsága */
    private int surfaceThickness;

    /** Aszteroida magjában levő nyersanyag */
    private Material substance;

    /**
     * Aszteroida konstruktor
     * @param surfaceThickness inicializálandó kéregvastagság
     * @param inSunZone napközelben van-e az inicializáladnó aszteroida
     * @param substance aszteroida magjába inicializálandó nyersanyag
     * @param numberOfChildren inicializálandó szomszédos aszteroidák száma
     */
    public Asteroid(int surfaceThickness, boolean inSunZone, Material substance, int numberOfChildren) {
        super();
        this.surfaceThickness = surfaceThickness;
        this.inSunZone = inSunZone;
        this.substance = substance;
        this.numberOfChildren = numberOfChildren;
    }

    public boolean isInSunZone() {
        return inSunZone;
    }

    /**
     * Aszteroidában a kibányászása után tárolt nyersanyaglista lekérése
     * @return az aszteroidában tárolt nyersanyagok
     */
    public Map<Material, Integer> getAsteroidInventory() {
        return asteroidInventory;
    }

    /**
     * Űrhajó lehelyezése az aszteroidára
     * @param spaceShip a lehelyezendő űrhajó
     */
    public void addSpaceShip(Spaceship spaceShip) {
        residence.add(spaceShip);
    }

    /**
     * Űrhajó eltávolítása az aszteroidáról
     * @param spaceShip az eltávolítandó űrhajó
     */
    public void removeSpaceship(Spaceship spaceShip) {
        residence.remove(spaceShip);
    }

    /**
     * Nyersanyag bányászása
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
        for (Spaceship spaceShip : residence) {
            spaceShip.getHitByExplosion();
        }
    }

    /**
     * Berakja a megadott nyersanyagot a map-ba
     * @param material a berakandó nyersanyag
     */
    public void insertMaterial(Material material) throws AsteroidNotMinedException {
        if (substance == null) {
            //if the material doesnt exist in the list, puIfAbsent create a key with value 0
            asteroidInventory.putIfAbsent(material, 0);
            //if the material already exist in map as key, just add 1 to the amount
            asteroidInventory.computeIfPresent(material, (material1, amount) -> amount + 1);
        } else {
            throw new AsteroidNotMinedException();
        }
    }

    /**
     * Megadott nyersanyag eltávolítása a map-ból, ha lehetséges
     * @param materialToRemove az eltávolítandó nyersanyag
     * @throws NotEnoughMaterialException ha nincs elég nyersanyag, amiből el lehetne távolítani
     */
    public void removeMaterial(Material materialToRemove) throws NotEnoughMaterialException {
        if (asteroidInventory.getOrDefault(materialToRemove, 0) == 0) {
            throw new NotEnoughMaterialException(materialToRemove);
        }
        asteroidInventory.computeIfPresent(materialToRemove, (material, old) -> old - 1);

    }

    /**
     * Űrbázis építése
     */
    public void buildBase() {
        System.out.println("Base builded!");
        Game.Win();
    }

    /**
     * Napvihar átélése
     */
    @Override
    public void experienceSolarStrom() {
        super.experienceSolarStrom();
    }

    /**
     * Égitest típusának lekérdezése
     * @return égitest típusa
     */
    @Override
    public String getType() {
        return "Asteroid";
    }

    @Override
    public String toString() {
        return "Asteroid @" + Integer.toHexString(hashCode()) + "{" +
                ("\n" + "inSunZone=" + inSunZone +
                        "\n" + "numberOfChildren=" + numberOfChildren +
                        "\n" + "asteroidInventory=" + asteroidInventory +
                        "\n" + "surfaceThickness=" + surfaceThickness +
                        "\n" + "substance=" + substance +
                        "\n" + "neighbors=\n" + neighbors +
                        "\n" + "residence=\n" + residence
                ).indent(4) +
                '}';
    }

    @Override
    public String toStringOnlyName() {
        return "Asteroid @" + Integer.toHexString(hashCode());
    }
}
