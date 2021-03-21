package com.github.kozosjavak.asteroidmining.bills;

import com.github.kozosjavak.asteroidmining.materials.Material;
import com.github.kozosjavak.asteroidmining.materials.Materials;

import java.util.Map;

public class BillOfTeleport implements BillOfMaterial {

    @Override
    public Map<Material, Integer> getMaterialsNeeded() {
        return Map.of(Materials.IRON, 2, Materials.WATERICE, 1, Materials.URANIUM, 1);
    }

    @Override
    public String toString() {
        return "Bill of Material";
    }
}