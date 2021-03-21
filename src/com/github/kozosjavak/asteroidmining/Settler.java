package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.materials.Material;

import java.util.HashMap;
import java.util.Map;

public class Settler extends Spaceship implements Steppable {
    private final Map<Material, Integer> inventory = new HashMap<>();
    private TeleportPair teleportPair;

    public Map<Material, Integer> getInventory() {
        return inventory;
    }

    private int getInventoryWeight() {
        return inventory.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public void mine() {
        if (getInventoryWeight() < 10) {
            //    carriedMaterials.add(Asteroid::mine());
        }
    }

    public void buildTeleportPair() {

    }

    public void buildBase() {
    }

    public void buildRobot() {

    }

    public void insertMaterial(Material material) {
     /*   Asteroid::insertMaterial(material);
        RemoveMaterial(material);*/
    }

    private void removeMaterial(Material materialToRemove) throws NotEnoughMaterialException {
        if (inventory.getOrDefault(materialToRemove, 0) == 0) {
            throw new NotEnoughMaterialException(materialToRemove);
        }
        inventory.computeIfPresent(materialToRemove, (material, old) -> old - 1);

    }

    public void deployTeleport(Asteroid asteroid) {
    }

    @Override
    public void die() {
        //SetnumOfSettler(numOfSettler-1);
    }

    @Override
    public void getHitByExplosion() {
    }

    @Override
    public void drill() {
    }

    @Override
    public void experienceSolarStorm() {
    }

    @Override
    public String getType() {
        return "Settler";
    }

    @Override
    public void step() {

    }
}

