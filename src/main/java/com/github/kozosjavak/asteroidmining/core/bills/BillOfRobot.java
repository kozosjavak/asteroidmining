package com.github.kozosjavak.asteroidmining.core.bills;

import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;

import java.util.Map;

public class BillOfRobot implements BillOfMaterial {

    @Override
    public Map<Class<? extends Material>, Integer> getMaterialsNeeded() {
        return Map.of(Iron.class, 1, Coal.class, 1, Uranium.class, 1);
    }

    @Override
    public String toString() {
        return "Bill of Robot";
    }
}