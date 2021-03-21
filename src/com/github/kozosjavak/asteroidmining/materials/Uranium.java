package com.github.kozosjavak.asteroidmining.materials;

import com.github.kozosjavak.asteroidmining.Asteroid;

public class Uranium implements Material {
    public void experienceExtremeHeat(Asteroid a) {
        a.explode(); // explodes
    }
}