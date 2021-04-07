package com.github.kozosjavak.asteroidmining.core.materials;

import com.github.kozosjavak.asteroidmining.core.Explodeable;

public interface Material {
    void experienceExtremeHeat(Explodeable explodeableHolder) throws Exception;
}
