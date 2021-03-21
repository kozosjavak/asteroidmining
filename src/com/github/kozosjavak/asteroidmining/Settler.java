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

    public void Mine() {
        if (getInventoryWeight() < 10) {
            //    carriedMaterials.add(Asteroid::mine());
        }
    }

    public void BuildTeleportPair() {

    }

    public void BuildBase() {
    }

    public void BuildRobot() {

    }

    public void InsertMaterial(Material material) {
     /*   Asteroid::insertMaterial(material);
        RemoveMaterial(material);*/
    }

    private void RemoveMaterial(Material materialToRemove) throws NotEnoughMaterialException {
        if (inventory.getOrDefault(materialToRemove, 0) == 0) {
            throw new NotEnoughMaterialException(materialToRemove);
        }
        inventory.computeIfPresent(materialToRemove, (material, old) -> old - 1);

    }

    public void DeployTeleport(Asteroid asteroid) {
    }

    @Override
    public void Die() {
        //SetnumOfSettler(numOfSettler-1);
    }

    @Override
    public void GetHitByExplosion() {
    }

    @Override
    public void Drill() {
    }

    @Override
    public void ExperienceSolarStorm() {
    }

    @Override
    public String GetType() {
        return "Settler";
    }

    @Override
    public void step() {

    }
}

