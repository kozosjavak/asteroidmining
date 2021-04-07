package com.github.kozosjavak.asteroidmining.core.materials.types;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Explodeable;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

public class Waterice implements Material {
    public void experienceExtremeHeat(Asteroid a) throws NotEnoughMaterialException {

        if (a.isInSunZone())
            a.removeMaterial(this);
    }

    @Override
    public String toString() {
        return "Water ice";
    }

    @Override
    public void experienceExtremeHeat(Explodeable explodeableHolder) throws NotEnoughMaterialException {
        explodeableHolder.removeSubstance(); // Sublimate substance
    }
}
