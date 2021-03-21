package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.materials.Material;

public class NotEnoughMaterialException extends Exception {
    public NotEnoughMaterialException(Material material) {
        super("Not enough for material: " + material.toString());
    }

}
