package com.github.kozosjavak.asteroidmining.core.materials;

/**
 * Nincs elég nyersanyag kivétel
 */
public class NotEnoughMaterialException extends Exception {
    public NotEnoughMaterialException(Class<? extends Material> material) {
        super("Not enough from material: " + material.toString());
    }


}
