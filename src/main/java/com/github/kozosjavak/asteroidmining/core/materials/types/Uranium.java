package com.github.kozosjavak.asteroidmining.core.materials.types;

import com.github.kozosjavak.asteroidmining.core.Explodeable;
import com.github.kozosjavak.asteroidmining.core.materials.Material;

public class Uranium implements Material {
    private int experienceExtremeHeatCounter = 3;

    public void experienceExtremeHeat(Explodeable explodeableHolder) {
        if (experienceExtremeHeatCounter != 0) {
            experienceExtremeHeatCounter--;
        } else {
            explodeableHolder.explode();
        }

    }

    @Override
    public String toString() {
        return "Uranium";
    }
}