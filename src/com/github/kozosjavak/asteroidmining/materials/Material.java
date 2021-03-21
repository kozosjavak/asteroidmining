package com.github.kozosjavak.asteroidmining.materials;

import com.github.kozosjavak.asteroidmining.Asteroid;
import com.github.kozosjavak.asteroidmining.NotEnoughMaterialException;

public interface Material {
    void experienceExtremeHeat(Asteroid a) throws NotEnoughMaterialException;
}
