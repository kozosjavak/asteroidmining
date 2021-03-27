package com.github.kozosjavak.asteroidmining.bills;

import com.github.kozosjavak.asteroidmining.materials.Material;
import com.github.kozosjavak.asteroidmining.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.materials.types.Waterice;

import java.util.Map;

public class BillOfTeleport implements BillOfMaterial {

    @Override
    public Map<Class<? extends Material>, Integer> getMaterialsNeeded() {
        return Map.of(Iron.class, 2, Waterice.class, 1, Uranium.class, 1);
    }

    @Override
    public String toString() {
        return "Bill of Material";
    }
}