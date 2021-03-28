package com.github.kozosjavak.asteroidmining.core.materials.types;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Explodeable;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

public class Iron implements Material {
    public void experienceExtremeHeat(Asteroid a) {
        return; // do nothing
    }

    @Override
    public String toString() {
        return "Iron";
    }

    @Override
    public void experienceExtremeHeat(Explodeable explodeableHolder) throws NotEnoughMaterialException {
    }
}