package com.github.kozosjavak.asteroidmining.bills;

import com.github.kozosjavak.asteroidmining.materials.Material;
import com.github.kozosjavak.asteroidmining.materials.Materials;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillOfMaterialTest {

    @Test
    void isNeeded_emptyInventory() {
        Map<Material, Integer> inventory = Map.of();
        Map<Material, Integer> result = Bills.TELEPORT.isNeeded(inventory);
        assertEquals(3, result.size());
        assertEquals(2, result.get(Materials.IRON));
        assertEquals(1, result.get(Materials.WATERICE));
        assertEquals(1, result.get(Materials.URANIUM));
    }

    @Test
    void isNeeded_exactMatch() {
        Map<Material, Integer> inventory = Map.of(Materials.IRON, 2, Materials.WATERICE, 1, Materials.URANIUM, 1);
        Map<Material, Integer> result = Bills.TELEPORT.isNeeded(inventory);
        assertEquals(0, result.size());
    }

    @Test
    void isNeeded_more() {
        Map<Material, Integer> inventory = Map.of(Materials.IRON, 2, Materials.WATERICE, 2, Materials.URANIUM, 1);
        Map<Material, Integer> result = Bills.TELEPORT.isNeeded(inventory);
        assertEquals(0, result.size());
    }

    @Test
    void isNeeded_less() {
        Map<Material, Integer> inventory = Map.of(Materials.IRON, 1, Materials.WATERICE, 2, Materials.URANIUM, 1);
        Map<Material, Integer> result = Bills.TELEPORT.isNeeded(inventory);
        assertEquals(1, result.size());
        assertEquals(1, result.get(Materials.IRON));
    }


}