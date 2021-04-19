package com.github.kozosjavak.asteroidmining.core.materials;

import com.github.kozosjavak.asteroidmining.core.Explodeable;
import com.github.kozosjavak.asteroidmining.core.Game;

public interface Material {
    void experienceExtremeHeat(Explodeable explodeableHolder) throws Exception;

    String toString(int depth, Game game);
}
