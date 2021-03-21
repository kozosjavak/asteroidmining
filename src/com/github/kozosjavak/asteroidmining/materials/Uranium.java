package com.github.kozosjavak.asteroidmining.materials;

import com.github.kozosjavak.asteroidmining.Asteroid;

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