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
     * Is it close to sun
     */
    private final boolean inSunZone;

    /**
     * Inicializálandó szomszédos aszteroidák száma
     */
    private final int numberOfChildren;

    /**
     * Inventory of the stored material on the asteroid, after it mined
     */
    private final Inventory asteroidInventory = new Inventory(0);
    /**
     * List of SpaceShips on the asteroid
     */
    private final List<Spaceship> residence = new CopyOnWriteArrayList<>();
    /**
     * Thickness of the surface of the asteroid
     */
    private int surfaceThickness;
    /**
     * Material in the core of the asteroid which can be mined
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

    public Material getSubstance() {
        return substance;
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
    public void drill() throws Exception {
        if (surfaceThickness == 1) {
            List<Location> locations = getLocation().getNeighbors();
            for (Location location : locations) {
                if (location.getOrb().getClass() == Sun.class) {
                    substance.experienceExtremeHeat(this);
                }
            }
        }

        if (surfaceThickness > 0) {
            surfaceThickness--;
        } else {
            throw new SurfaceThicknessIsZeroException();
        }
        if (surfaceThickness == 0) {
            if (substance != null) {
                substance.experienceExtremeHeat(this);
            }
        }
    }

    /**
     * Aszteroida explode and all thing on location explode with it
     */
    public void explode() {
        for (Spaceship spaceship : residence) {
            spaceship.getHitByExplosion();
        }
        residence.clear();
        getLocation().fullClearByExplosion();
    }

    /**
     * Insert the given material in the asteroid inventory
     *
     * @param material the material
     */
    public void insertMaterial(Material material) throws AsteroidNotMinedException, InventoryIsFullException {
        if (substance == null && surfaceThickness == 0) {
            asteroidInventory.add(material);
        } else {
            throw new AsteroidNotMinedException();
        }
    }

    /**
     * Insert the given substance to the core of the asteroid, created for the e2e test
     *
     * @param material the material
     */
    public void insertSubstance(Material material) {
        if (material != null) {
            substance = material;
        }
    }

    /**
     * Remove the given material from the asteroid inventory, if it exist
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
     * Build the spacebase on the asteroid, it means the end of the game with win
     */
    public void buildBase() {
        System.out.println("Base builded!");
        getLocation().game.Win();
    }

    /**
     * Get solar stormed, it will call the experienceSolarStorm() on all the spaceship on the asteroid
     */
    @Override
    public void experienceSolarStorm() {
        for (Spaceship spaceShip : residence) {
            spaceShip.experienceSolarStorm();
        }
    }

    /**
     * Get extreme heat, itt will call the experienceExtremeHeat() on the inventory and on all the spaceship on the asteroid
     *
     * @throws Exception inventory exceptions
     */
    @Override
    public void experienceExtremeHeat() throws Exception {
        if (surfaceThickness == 0 && substance != null) {
            substance.experienceExtremeHeat(this);
        } else {
            asteroidInventory.experienceExtremeHeat(this);
        }
        for (Spaceship spaceship : residence) {
            spaceship.experienceExtremeHeat();
        }
    }

    /**
     * Give back the thickness of the surface
     *
     * @return int thickness of the surface
     */
    public int getSurfaceThickness() {
        return surfaceThickness;
    }

    /**
     * Return the asteroid structure in string
     *
     * @param depth needed for the correct amount of /t before the data for correct write out
     * @param game  needed for give the ID of itself
     * @return String
     */
    @Override
    public String toString(int depth, Game game) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";

        String out = " Asteroid {\n";
        out += tab + "ID = " + game.getId(this) + ",\n";
        out += tab + "CrustThickness = " + surfaceThickness + ",\n";
        out += tab + "AsteroidInventory = {\n" + asteroidInventory.toString(depth + 1, game) + tab + "},\n";
        out += tab + "Substance = " + (substance == null ? "null\n" : substance.toString(0, game));
        out += tab + "Residence = {\n";
        for (Spaceship resident : residence) {
            out += resident.toString(depth + 1, game) + ",\n";
        }
        out += tab + "}\n";
        return out;
    }
}
