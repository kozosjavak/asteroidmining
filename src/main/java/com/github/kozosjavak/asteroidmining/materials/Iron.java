package com.github.kozosjavak.asteroidmining.materials;

import com.github.kozosjavak.asteroidmining.Asteroid;

public class Iron implements Material {
    public void experienceExtremeHeat(Asteroid a) {
        return; // do nothing
    }

    @Override
    public String toString() {
        return "Iron";
    }
}