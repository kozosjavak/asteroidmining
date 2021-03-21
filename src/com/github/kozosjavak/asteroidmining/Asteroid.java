package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.materials.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Asteroid extends Orb {

    private final boolean inSunZone;
    private final int numberOfChildren;


    private final Map<Material, Integer> asteroidInventory = new HashMap<>();
    private final List<Spaceship> residence = new ArrayList<>();
    private int surfaceThickness;
    private Material substance;

    public Asteroid(int surfaceThickness, boolean inSunZone, Material substance, int numberOfChildren) {
        this.surfaceThickness = surfaceThickness;
        this.inSunZone = inSunZone;
        this.substance = substance;
        this.numberOfChildren = numberOfChildren;
    }

    public Map<Material, Integer> getAsteroidInventory() {
        return asteroidInventory;
    }

    public void addSpaceShip(Spaceship spaceShip) {
        residence.add(spaceShip);
    }

    public void removeSpaceship(Spaceship spaceShip) {
        residence.remove(spaceShip);
    }

    public Material mine() {
        if (surfaceThickness == 0 && substance != null) {
            Material temp = substance;
            substance = null;
            return temp;
        } else {
            return null;
        }
    }

    /**
     * removes a layer of crust from the asteroid itself
     *
     * @throws SurfaceThicknessIsZeroException if its already removed to zero
     */
    public void drill() throws SurfaceThicknessIsZeroException {
        if (surfaceThickness == 1) {
            substance.experienceExtremeHeat(this);
        }

        if (surfaceThickness > 0) {
            surfaceThickness--;
        } else {
            new SurfaceThicknessIsZeroException();
        }
    }

    public void explode() {
        for (Spaceship spaceShip : residence) {
            spaceShip.getHitByExplosion();
        }
    }

    /**
     * puts the given material into the map
     *
     * @param material the material
     */
    public void insertMaterial(Material material) throws AsteroidNotMinedException {
        if (substance == null) {
            //if the material doesnt exist in the list, puIfAbsent create a key with value 0
            asteroidInventory.putIfAbsent(material, 0);
            //if the material already exist in map as key, just add 1 to the amount
            asteroidInventory.computeIfPresent(material, (material1, amount) -> amount + 1);
        }
    }

    /**
     * removes the given material from the map if it possible
     *
     * @param materialToRemove the material should removed
     * @throws NotEnoughMaterialException if there is not enough material to remove
     */
    public void removeMaterial(Material materialToRemove) throws NotEnoughMaterialException {
        if (asteroidInventory.getOrDefault(materialToRemove, 0) == 0) {
            throw new NotEnoughMaterialException(materialToRemove);
        }
        asteroidInventory.computeIfPresent(materialToRemove, (material, old) -> old - 1);

    }

    public void buildBase() {
        System.out.println("Base builded!");
        Game.Win();
    }

    @Override
    public void experienceSolarStrom() {
        super.experienceSolarStrom();
    }

    @Override
    public String getType() {
        return "Asteroid";
    }
}
