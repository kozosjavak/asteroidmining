package com.github.kozosjavak.asteroidmining.materials.types;

import com.github.kozosjavak.asteroidmining.Asteroid;
import com.github.kozosjavak.asteroidmining.materials.Material;

public class Uranium implements Material {
    public void experienceExtremeHeat(Asteroid a) {
        if (a.isInSunZone())
            a.explode(); // explodes
    }

    @Override
    public String toString() {
        return "Uranium";
    }
}