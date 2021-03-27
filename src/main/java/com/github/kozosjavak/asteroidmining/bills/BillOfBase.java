package com.github.kozosjavak.asteroidmining.bills;

import com.github.kozosjavak.asteroidmining.materials.Material;
import com.github.kozosjavak.asteroidmining.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.materials.types.Waterice;

import java.util.Map;

public class BillOfBase implements BillOfMaterial {

    @Override
    public Map<Class<? extends Material>, Integer> getMaterialsNeeded() {
        return Map.of(Iron.class, 3, Waterice.class, 3, Uranium.class, 3, Coal.class, 3);
    }

    @Override
    public String toString() {
        return "Bill of Base";
    }
}
