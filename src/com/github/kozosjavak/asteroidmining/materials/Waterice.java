package com.github.kozosjavak.asteroidmining.materials;

import com.github.kozosjavak.asteroidmining.Asteroid;

public class Waterice implements Material {
    public void experienceExtremeHeat(Asteroid a) {
        a.removeMaterial(this); // sublimates
    }
}
