package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.bills.BillOfMaterial;
import com.github.kozosjavak.asteroidmining.bills.Bills;
import com.github.kozosjavak.asteroidmining.materials.Material;

import java.util.HashMap;
import java.util.Map;

public class Settler extends Spaceship implements Steppable {
    private final Map<Material, Integer> inventory = new HashMap<>();
    private TeleportPair teleportPair;

    public Settler(Asteroid asteroid) {
        super(asteroid);
        Game.addASettlerInNumberOfSettler();
    }

    public Map<Material, Integer> getInventory() {
        return inventory;
    }

    /**
     * Calculate the overall number of materials the Settler carries
     *
     * @return number of materials
     */
    private int getInventoryWeight() {
        return getInventory().values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * Calls the current Asteroid's mine method, if the material return isn't null then puts in the inventory
     *
     * @throws InventoryIsFullException if the inventory is full
     */
    public void mine() throws InventoryIsFullException {
        if (getInventoryWeight() < 10) {
            Material material = getCurrentAsteroid().mine();
            if (material != null) {
                //if the material doesnt exist in the list, puIfAbsent create a key with value 0
                getInventory().putIfAbsent(material, 0);
                //if the material already exist in map as key, just add 1 to the amount
                getInventory().computeIfPresent(material, (material1, amount) -> amount + 1);
            }
        } else {
            throw new InventoryIsFullException();
        }
    }

    /**
     * Build teleport
     */
    public void buildTeleportPair() {
        //Map of materials needed to build
        if (buy(Bills.TELEPORT, getInventory()))
            teleportPair = new TeleportPair();
    }

    /**
     * Procedure of buying, checking if the inventory param has the correct amount of materials
     * if so it returns true and removes needed materials to build from the given inventory
     * if not it write out the materials that needed.
     *
     * @param billOfMaterial Bill of the current buying
     * @param inventory      Inventory where the transaction started
     * @return
     */
    private boolean buy(BillOfMaterial billOfMaterial, Map<Material, Integer> inventory) {
        Map<Material, Integer> currentNeed = billOfMaterial.isNeeded(inventory);
        //check if the returned (currentNeed) map is empty
        if (currentNeed.values().stream().mapToInt(Integer::intValue).sum() == 0) {
            //Remove materials from the settler inventory
            for (Map.Entry<Material, Integer> entry : billOfMaterial.getMaterialsNeeded().entrySet()) {
                inventory.compute(entry.getKey(), (material, inventoryAmount) -> inventoryAmount - entry.getValue() == 0 ? null : inventoryAmount - entry.getValue());
            }
            return true;
        } else {
            //
            System.out.println("You can't build " + billOfMaterial.toString() + ", you dont have: ");
            for (Map.Entry<Material, Integer> entry : currentNeed.entrySet()) {
                System.out.print("Name of material: " + entry.getKey().toString());
                System.out.print(", Quantity left: " + entry.getValue().toString());
            }
            return false;
        }
    }

    /**
     * Build Base
     * Forwarding the current Asteroid's inventory to buy()
     */
    public void buildBase() {
        if (buy(Bills.TELEPORT, getCurrentAsteroid().getAsteroidInventory()))
            getCurrentAsteroid().buildBase();
    }

    /**
     * Build robot
     * put the fresh robot to the current Asteroid
     */
    public void buildRobot() {
        if (buy(Bills.ROBOT, getInventory())) {
            Robot robot = new Robot(getCurrentAsteroid());
            getCurrentAsteroid().addSpaceShip(robot);
        }
    }

    /**
     * calls the current Asteroid insertMaterial method, to put a material into the Asteroid's inventory, and remmoves it from the inventory
     *
     * @param material the material you want to pass to the Asteroid
     * @throws NotEnoughMaterialException if you want to put an invalid material down
     */
    public void insertMaterial(Material material) throws Exception {
        getCurrentAsteroid().insertMaterial(material);
        removeMaterial(material);
    }

    /**
     * Removes a single material from the inventory map
     *
     * @param materialToRemove the material you want to remove
     * @throws NotEnoughMaterialException
     */
    private void removeMaterial(Material materialToRemove) throws NotEnoughMaterialException {
        if (getInventory().getOrDefault(materialToRemove, 0) == 0) {
            throw new NotEnoughMaterialException(materialToRemove);
        }
        getInventory().computeIfPresent(materialToRemove, (material, old) -> old - 1);
    }

    public void deployTeleport(Asteroid asteroid) {
    }

    @Override
    public void die() {
        Game.removeASettlerInNumberOfSettler();
        getCurrentAsteroid().removeSpaceship(this);
    }

    @Override
    public void getHitByExplosion() {
        this.die();
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

