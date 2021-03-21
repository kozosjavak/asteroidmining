package com.github.kozosjavak.asteroidmining.materials;

import com.github.kozosjavak.asteroidmining.Asteroid;

public class Waterice implements Material {
    public void ExperienceExtremeHeat(Asteroid a) {
        a.RemoveSubstance(); // sublimates
    }
}
