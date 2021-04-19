package com.github.kozosjavak.asteroidmining.core.materials.types;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Explodeable;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

public class Coal implements Material {
    public void experienceExtremeHeat(Asteroid a) {
        return; // do nothing
    }

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

    @Override
    public void experienceExtremeHeat(Explodeable explodeableHolder) throws NotEnoughMaterialException {
    }
}