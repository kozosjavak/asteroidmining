package com.github.kozosjavak.asteroidmining.materials;

import com.github.kozosjavak.asteroidmining.Asteroid;
import com.github.kozosjavak.asteroidmining.NotEnoughMaterialException;

public class Waterice implements Material {
    public void experienceExtremeHeat(Asteroid a) throws NotEnoughMaterialException {

        if (a.isInSunZone())
            a.removeMaterial(this);
    }

    @Override
    public String toString() {
        return "Water ice";
    }
}
