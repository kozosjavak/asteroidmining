package com.github.kozosjavak.asteroidmining.core.bills;

import com.github.kozosjavak.asteroidmining.core.materials.Inventory;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

import java.util.HashMap;
import java.util.Map;

public interface BillOfMaterial {
    Map<Class<? extends Material>, Integer> getMaterialsNeeded();

    /**
     * Here return a new map which indicates how many resource we will need to build, if everything matching return empty map
     *
     * @param inventory resources you have
     * @return resources needed
     */
    default Map<Class<? extends Material>, Integer> isNeeded(Inventory inventory) {
        //creates a map from the needed materials, where you can remove materials what inventory have
        HashMap<Class<? extends Material>, Integer> materialsLeft = new HashMap<>(getMaterialsNeeded());
        //iterate the inventory map, creates walletEntry
        for (Map.Entry<Class<? extends Material>, Integer> inventoryEntry : inventory.toMap().entrySet()) {

            final Class<? extends Material> material = inventoryEntry.getKey();
            //check if the the bill has the inventory materials
            if (materialsLeft.containsKey(material)) {
                //remove the number of material which the inventory have from the materialsLeft
                int value = materialsLeft.get(material) - inventoryEntry.getValue();
                //replace the new Integer number for materials, can't be under zero
                materialsLeft.compute(material, (material1, amount) -> value <= 0 ? null : value);
            }

        }
        return materialsLeft;
    }

    default boolean buy(Inventory inventory) throws NotEnoughMaterialException {
        Map<Class<? extends Material>, Integer> currentNeed = this.isNeeded(inventory);
        //check if the returned (currentNeed) map is empty
        if (currentNeed.values().stream().mapToInt(Integer::intValue).sum() == 0) {
            //Remove materials from the settler inventory
            for (Map.Entry<Class<? extends Material>, Integer> entry : this.getMaterialsNeeded().entrySet()) {
                inventory.remove(entry.getKey(), entry.getValue());
            }
            return true;
        } else {
            System.out.println("You can't build " + this.toString() + ", you dont have: ");
            for (Map.Entry<Class<? extends Material>, Integer> entry : currentNeed.entrySet()) {
                System.out.print("Name of material: " + entry.getKey().getSimpleName());
                System.out.print(", Quantity left: " + entry.getValue().toString());
            }
            return false;
        }

    }
}
