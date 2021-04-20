package com.github.kozosjavak.asteroidmining.core.materials;

import com.github.kozosjavak.asteroidmining.core.Explodeable;
import com.github.kozosjavak.asteroidmining.core.Game;

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

    /**
     * Returns the size of the inventory
     *
     * @return int
     */
    public int getSize() {
        return materials.size();
    }

    /**
     * Returns the list of the materials which stored in the inventory
     *
     * @return List<Material>
     */
    public List<Material> getList() {
        return Collections.unmodifiableList(materials);
    }

    /**
     * Adds the given material to the inventory list
     *
     * @param material Material
     * @return Inventory
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
     * Removes the given amount of the specified materials from the list
     * @param materialType Material
     * @param amount int
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

    /**
     * Implementation of the experienceExtremeHeat()
     *
     * @param carrier Explodeable, carrier of the inventory
     * @throws Exception
     */
    public void experienceExtremeHeat(Explodeable carrier) throws Exception {
        for (Material material : materials) {
            material.experienceExtremeHeat(carrier);
        }
    }

    /**
     * Return the inventory structure in string
     *
     * @param depth needed for the correct amount of /t before the data for correct write out
     * @param game  needed for give the ID of itself
     * @return String
     */
    public String toString(int depth, Game game) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";

        String out = "";
        for (Material material : materials) {
            out += tab + material.toString(depth + 1, game) + "\n";
        }
        return out;
    }
}
