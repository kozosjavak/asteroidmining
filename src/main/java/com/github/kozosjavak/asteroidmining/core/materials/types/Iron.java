package com.github.kozosjavak.asteroidmining.core.materials.types;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Explodeable;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

/**
 * Iron class
 */
public class Iron implements Material {
    public void experienceExtremeHeat(Asteroid a) {
        return; // do nothing
    }

    /**
     * Return the iron structure in string
     *
     * @param depth needed for the correct amount of /t before the data for correct write out
     * @param game  needed for give the ID of itself
     * @return String
     */
    @Override
    public String toString(int depth, Game game) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";

        return tab + "Iron {ID = " + game.getId(this) + "},\n";
    }

    @Override
    public String toString() {
        return "Iron";
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