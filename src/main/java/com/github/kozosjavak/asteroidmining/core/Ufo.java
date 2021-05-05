package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.Inventory;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

import java.util.List;
import java.util.Random;

/**
 * Ufo class
 */
public class Ufo extends Spaceship {

    /**
     * Inventory of the Ufo
     */
    private final Inventory inventory = new Inventory(0);

    /**
     * Basic constructor of the ufo
     *
     * @param asteroid Asteroid, where the ufo will be placed
     */
    public Ufo(Asteroid asteroid) {
        super(asteroid);
    }

    /**
     * Implementation of the step(), it's randomly moving,steal,mine
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

    /**
     * It steals random amount of material from the asteroid inventory
     */
    public void steal() {
        Random rand = new Random();
        List<Material> materials = getCurrentAsteroid().getMaterials();
        if (materials.size() != 0) {
            Material material = materials.get(rand.nextInt(materials.size() - 1));
            try {
                getCurrentAsteroid().removeMaterial(material);
                inventory.add(material);
            } catch (NotEnoughMaterialException | InventoryIsFullException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Mine
     * Mine on the current asteroid
     *
     * @throws InventoryIsFullException inventory is full
     * @throws AsteroidIsNotMineable    asteroid can't be mined
     */
    public void mine() throws InventoryIsFullException, AsteroidIsNotMineable {
        inventory.add(getCurrentAsteroid().mine());
    }

    /**
     * Implementation of the experienceExtremeHeat(), calls inventory experienceExtremeHea()
     *
     * @throws Exception
     */
    @Override
    public void experienceExtremeHeat() throws Exception {
        if (inventory.getSize() != 0) {
            inventory.experienceExtremeHeat(this);
        }
    }

    /**
     * Gives back inventory
     *
     * @return Inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Return the Ufo structure in string
     *
     * @param depth needed for the correct amount of /t before the data for correct write out
     * @param game  needed for give the ID of itself
     * @return String
     */
    @Override
    public String toString(int depth, Game game) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";
        String out = tab + "Ufo {\n";
        out += tab + "\tID = " + game.getId(this) + ",\n";
        out += tab + "\tInventory = {\n" + inventory.toString(depth + 2, game);
        out += tab + "\t}\n";
        out += tab + "}";
        return out;
    }
}
