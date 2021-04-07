package com.github.kozosjavak.asteroidmining.core.materials;

import com.github.kozosjavak.asteroidmining.core.Explodeable;

import java.util.*;

public class Inventory {
    private final int capacity;
    private final List<Material> materials = new ArrayList<>();

    /**
     * Inventory cotr, if you give 0 for capacity, there will be no limit
     *
     * @param capacity
     */
    public Inventory(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Creates an inventory with infinite capacity
     *
     * @return
     */
    public static Inventory infiniteCapacity() {
        return new Inventory(0);
    }

    public int getSize() {
        return materials.size();
    }

    public List<Material> getList() {
        return Collections.unmodifiableList(materials);
    }

    /**
     * @param material
     * @throws InventoryIsFullException
     */
    public Inventory add(final Material material) throws InventoryIsFullException {
        if (capacity == 0 || materials.size() < capacity) {
            materials.add(material);
        } else {
            throw new InventoryIsFullException();
        }
        return this;
    }

    /**
     * @param materialType
     * @param amount
     * @throws NotEnoughMaterialException
     */
    public void remove(final Class<? extends Material> materialType, final int amount) throws NotEnoughMaterialException {
        List<Material> temp = new ArrayList<>();
        int count = 0;

        for (final Material inventoryMaterial : materials) {
            if (inventoryMaterial.getClass() == materialType && count != amount) {
                temp.add(inventoryMaterial);
                count++;
            }
            if (count == amount)
                break;
        }

        if (count == amount) {
            materials.removeAll(temp);
        } else {
            throw new NotEnoughMaterialException(materialType);
        }
    }


    /**
     * Get materials as a map
     *
     * @return map of materials
     */
    public Map<Class<? extends Material>, Integer> toMap() {
        HashMap<Class<? extends Material>, Integer> result = new HashMap<>();
        for (Material material : materials) {
            result.putIfAbsent(material.getClass(), 0);
            result.put(material.getClass(), result.get(material.getClass()) + 1);
        }
        return Collections.unmodifiableMap(result);
    }

    public void experienceExtremeHeat(Explodeable carrier) throws Exception {
        for (Material material : materials) {
            material.experienceExtremeHeat(carrier);
        }
    }

}
