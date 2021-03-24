package com.github.kozosjavak.asteroidmining.bills;

import com.github.kozosjavak.asteroidmining.materials.Material;
import com.github.kozosjavak.asteroidmining.materials.Materials;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;


public class BillOfMaterialTest {

    @Test
    public void isNeeded_emptyInventory() {
        Map<Material, Integer> inventory = Map.of();
        Map<Material, Integer> result = Bills.TELEPORT.isNeeded(inventory);
        assertEquals(3, result.size());
        assertEquals(2, (int) result.get(Materials.IRON));
        assertEquals(1, (int) result.get(Materials.WATERICE));
        assertEquals(1, (int) result.get(Materials.URANIUM));
    }

    @Test
    public void isNeeded_exactMatch() {
        Map<Material, Integer> inventory = Map.of(Materials.IRON, 2, Materials.WATERICE, 1, Materials.URANIUM, 1);
        Map<Material, Integer> result = Bills.TELEPORT.isNeeded(inventory);
        assertEquals(0, result.size());
    }

    @Test
    public void isNeeded_more() {
        Map<Material, Integer> inventory = Map.of(Materials.IRON, 2, Materials.WATERICE, 2, Materials.URANIUM, 1);
        Map<Material, Integer> result = Bills.TELEPORT.isNeeded(inventory);
        assertEquals(0, result.size());
    }

    @Test
    public void isNeeded_less() {
        Map<Material, Integer> inventory = Map.of(Materials.IRON, 1, Materials.WATERICE, 2, Materials.URANIUM, 1);
        Map<Material, Integer> result = Bills.TELEPORT.isNeeded(inventory);
        assertEquals(1, result.size());
        assertEquals(1, (int) result.get(Materials.IRON));
    }


}