package com.github.kozosjavak.asteroidmining.bills;

import com.github.kozosjavak.asteroidmining.materials.Material;

import java.util.HashMap;
import java.util.Map;

public interface BillOfMaterial {
    Map<Material, Integer> getMaterialsNeeded();

    /**
     * Here return a new map which indicates how many resource we will need to build, if everything matching return empty map
     *
     * @param wallet resources you have
     * @return resources needed
     */
    default Map<Material, Integer> isNeeded(Map<Material, Integer> wallet) {
        //creates a map from the needed materials, where you can remove materials what wallet have
        HashMap<Material, Integer> materialsLeft = new HashMap<>(getMaterialsNeeded());
        //iterate the wallet map, creates walletEntry
        for (Map.Entry<Material, Integer> walletEntry : wallet.entrySet()) {

            final Material material = walletEntry.getKey();
            //check if the the bill has the wallet materials
            if (materialsLeft.containsKey(material)) {
                //remove the number of material which the wallet have from the materialsLeft
                int value = materialsLeft.get(material) - walletEntry.getValue();
                //replace the new Integer number for materials, can't be under zero
                materialsLeft.replace(material, Math.max(value, 0));
            }

        }
        return materialsLeft;
    }
}
