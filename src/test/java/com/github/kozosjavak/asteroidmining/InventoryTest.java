package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.core.materials.*;
import com.github.kozosjavak.asteroidmining.core.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.core.materials.types.Waterice;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class InventoryTest {
    final Material iron1 = new Iron();
    final Material iron2 = new Iron();
    final Material waterIce = new Waterice();
    final Material uran = new Uranium();

    @Test
    public void it_should_add_four_item() throws InventoryIsFullException {
        Inventory inventoryLimitless = Inventory.infiniteCapacity()
                .add(iron1)
                .add(iron2)
                .add(waterIce)
                .add(uran);

        assertEquals(4, inventoryLimitless.getSize());
        assertEquals(iron2, inventoryLimitless.getList().get(1));

    }

    @Test(expected = InventoryIsFullException.class)
    public void it_should_throw_an_error_when_adding_more_than_limit() throws InventoryIsFullException {
        Inventory inventoryLimit = new Inventory(3)
                .add(iron1)
                .add(iron2)
                .add(waterIce)
                .add(uran);

        assertEquals(3, inventoryLimit.getSize());
    }

    @Test
    public void it_should_remove_two_items_with_same_type() throws Exception {
        Inventory inventory = Inventory.infiniteCapacity()
                .add(iron1)
                .add(waterIce)
                .add(iron2);
        inventory.remove(Materials.IRON, 2);
        assertEquals(1, inventory.getSize());
        assertEquals(Materials.WATERICE, inventory.getList().iterator().next().getClass());
    }

    @Test(expected = NotEnoughMaterialException.class)
    public void it_should_throw_exception_when_not_enough_materials() throws Exception {
        Inventory inventory = Inventory.infiniteCapacity()
                .add(iron1)
                .add(waterIce)
                .add(iron2);
        inventory.remove(Materials.IRON, 3);
    }

    @Test
    public void convertListToMap() throws InventoryIsFullException {
        Map<Class<? extends Material>, Integer> expected = Map.of(Materials.IRON, 2, Materials.WATERICE, 1, Materials.URANIUM, 1);


        Inventory inventory = Inventory.infiniteCapacity()
                .add(iron1)
                .add(waterIce)
                .add(iron2)
                .add(uran);
        Map<Class<? extends Material>, Integer> map = inventory.toMap();
        assertEquals(3, map.size());
        assertThat(map, is(expected));
    }

}