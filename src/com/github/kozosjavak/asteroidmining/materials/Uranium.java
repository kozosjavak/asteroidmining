package com.github.kozosjavak.asteroidmining.materials;

import com.github.kozosjavak.asteroidmining.Asteroid;

public class Uranium implements Material {
    public void ExperienceExtremeHeat(Asteroid a) {
        a.Explode(); // explodes
    }
}