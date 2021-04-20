package com.github.kozosjavak.asteroidmining.core.materials.types;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Explodeable;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

/**
 * Coal class
 */
public class Coal implements Material {
    public void experienceExtremeHeat(Asteroid a) {
        return; // do nothing
    }

    /**
     * Return the coal structure in string
     *
     * @param depth needed for the correct amount of /t before the data for correct write out
     * @param game  needed for give the ID of itself
     * @return String
     */
    @Override
    public String toString(int depth, Game game) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";

        return tab + "Coal {ID = " + game.getId(this) + "},\n";
    }

    @Override
    public String toString() {
        return "Coal";
    }

    /**
     * Implementation of the experienceExtremeHeat()
     *
     * @param explodeableHolder Explodeable, holder of the material
     * @throws NotEnoughMaterialException
     */
    @Override
    public void experienceExtremeHeat(Explodeable explodeableHolder) throws NotEnoughMaterialException {
    }
}