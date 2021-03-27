package com.github.kozosjavak.asteroidmining.bills;

import com.github.kozosjavak.asteroidmining.materials.Inventory;
import com.github.kozosjavak.asteroidmining.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.materials.Material;
import com.github.kozosjavak.asteroidmining.materials.Materials;
import com.github.kozosjavak.asteroidmining.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.materials.types.Waterice;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;


public class BillOfMaterialTest {

    @Test
    public void isNeeded_emptyInventory() {

        Map<Class<? extends Material>, Integer> result = Bills.TELEPORT.isNeeded(Inventory.infiniteCapacity());
        assertEquals(3, result.size());
        assertEquals(2, (int) result.get(Materials.IRON));
        assertEquals(1, (int) result.get(Materials.WATERICE));
        assertEquals(1, (int) result.get(Materials.URANIUM));
    }

    @Test
    public void isNeeded_exactMatch() throws InventoryIsFullException {

        Inventory inventory = Inventory.infiniteCapacity()
                .add(new Iron())
                .add(new Iron())
                .add(new Waterice())
                .add(new Uranium());

        Map<Class<? extends Material>, Integer> result = Bills.TELEPORT.isNeeded(inventory);
        assertEquals(0, result.size());
    }

    @Test
    public void isNeeded_more() throws InventoryIsFullException {

        Inventory inventory = Inventory.infiniteCapacity()
                .add(new Iron())
                .add(new Iron())
                .add(new Waterice())
                .add(new Waterice())
                .add(new Uranium());
        Map<Class<? extends Material>, Integer> result = Bills.TELEPORT.isNeeded(inventory);
        assertEquals(0, result.size());
    }

    @Test
    public void isNeeded_less() throws InventoryIsFullException {

        Inventory inventory = Inventory.infiniteCapacity()
                .add(new Iron())
                .add(new Waterice())
                .add(new Uranium());
        Map<Class<? extends Material>, Integer> result = Bills.TELEPORT.isNeeded(inventory);
        assertEquals(1, result.size());
        assertEquals(1, (int) result.get(Materials.IRON));
    }


}