package com.github.kozosjavak.asteroidmining.bills;

import com.github.kozosjavak.asteroidmining.materials.Material;

import java.util.HashMap;
import java.util.Map;

public interface BillOfMaterial {
    Map<Material, Integer> getMaterialsNeeded();

    /**
     * Here return a new map which indicates how many resource we will need to build, if everything matching return empty map
     *
     * @param inventory resources you have
     * @return resources needed
     */
    default Map<Material, Integer> isNeeded(Map<Material, Integer> inventory) {
        //creates a map from the needed materials, where you can remove materials what inventory have
        HashMap<Material, Integer> materialsLeft = new HashMap<>(getMaterialsNeeded());
        //iterate the inventory map, creates walletEntry
        for (Map.Entry<Material, Integer> walletEntry : inventory.entrySet()) {

            final Material material = walletEntry.getKey();
            //check if the the bill has the inventory materials
            if (materialsLeft.containsKey(material)) {
                //remove the number of material which the inventory have from the materialsLeft
                int value = materialsLeft.get(material) - walletEntry.getValue();
                //replace the new Integer number for materials, can't be under zero
                materialsLeft.replace(material, Math.max(value, 0));
            }

        }
        return materialsLeft;
    }
}
