package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.materials.Material;

/** Nincs elég nyersanyag kivétel */
public class NotEnoughMaterialException extends Exception {
    public NotEnoughMaterialException(Material material) {
        super("Not enough from material: " + material.toString());
    }

}
