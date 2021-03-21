package com.github.kozosjavak.asteroidmining.bills;

import com.github.kozosjavak.asteroidmining.materials.Material;
import com.github.kozosjavak.asteroidmining.materials.Materials;

import java.util.Map;

public class BillOfBase implements BillOfMaterial {

    @Override
    public Map<Material, Integer> getMaterialsNeeded() {
        return Map.of(Materials.IRON, 3, Materials.WATERICE, 3, Materials.URANIUM, 3);
    }
}
