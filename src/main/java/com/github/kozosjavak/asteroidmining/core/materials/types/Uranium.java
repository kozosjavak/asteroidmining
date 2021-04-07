package com.github.kozosjavak.asteroidmining.core.materials.types;

import com.github.kozosjavak.asteroidmining.core.Explodeable;
import com.github.kozosjavak.asteroidmining.core.materials.Material;

public class Uranium implements Material {
    private int experienceExtremeHeatCounter = 3;

    public void experienceExtremeHeat(Explodeable explodeableHolder) throws Exception {
        if (experienceExtremeHeatCounter > 1) {
            experienceExtremeHeatCounter--;
        } else {
            explodeableHolder.explode();
        }
        System.out.println(experienceExtremeHeatCounter);
    }

    @Override
    public String toString() {
        return "Uranium";
    }
}