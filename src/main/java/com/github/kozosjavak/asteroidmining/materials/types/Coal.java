package com.github.kozosjavak.asteroidmining.materials.types;

import com.github.kozosjavak.asteroidmining.Asteroid;
import com.github.kozosjavak.asteroidmining.materials.Material;

public class Coal implements Material {
    public void experienceExtremeHeat(Asteroid a) {
        return; // do nothing
    }

    @Override
    public String toString() {
        return "Coal";
    }
}