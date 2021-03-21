package com.github.kozosjavak.asteroidmining.bills;

import com.github.kozosjavak.asteroidmining.materials.Material;
import com.github.kozosjavak.asteroidmining.materials.Materials;

import java.util.Map;

public class BillOfRobot implements BillOfMaterial {

    @Override
    public Map<Material, Integer> getMaterialsNeeded() {
        return Map.of(Materials.IRON, 1, Materials.COAL, 1, Materials.URANIUM, 1);
    }
}