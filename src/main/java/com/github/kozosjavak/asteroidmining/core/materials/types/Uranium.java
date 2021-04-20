package com.github.kozosjavak.asteroidmining.core.materials.types;

import com.github.kozosjavak.asteroidmining.core.Explodeable;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

/**
 * Uranium class
 */
public class Uranium implements Material {
    private int experienceExtremeHeatCounter = 0;

    /**
     * Implementation of the experienceExtremeHeat(), if the experienceExtremeHeatCounter is 3, it will call the explode() of the holder
     *
     * @param explodeableHolder Explodeable, holder of the material
     * @throws NotEnoughMaterialException
     */
    public void experienceExtremeHeat(Explodeable explodeableHolder) throws Exception {
        if (experienceExtremeHeatCounter < 3) {
            experienceExtremeHeatCounter++;
        }
        if (experienceExtremeHeatCounter > 2) {
            explodeableHolder.explode();
        }
        System.out.println(experienceExtremeHeatCounter);
    }

    /**
     * Return the uranium structure in string
     *
     * @param depth needed for the correct amount of /t before the data for correct write out
     * @param game  needed for give the ID of itself
     * @return String
     */
    @Override
    public String toString(int depth, Game game) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";

        return tab + "Uran {ID = " + game.getId(this) + ", HeatCounter = " + experienceExtremeHeatCounter + "},\n";
    }

    @Override
    public String toString() {
        return "Uranium";
    }

    public void setExperienceExtremeHeatCounter(int count) {
        experienceExtremeHeatCounter = count;
    }
}