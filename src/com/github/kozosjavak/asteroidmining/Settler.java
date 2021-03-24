package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.bills.BillOfMaterial;
import com.github.kozosjavak.asteroidmining.bills.Bills;
import com.github.kozosjavak.asteroidmining.materials.Material;

import java.util.HashMap;
import java.util.Map;

/**
 * Telepes osztály
 */
public class Settler extends Spaceship implements Steppable {

    /**
     * A telepes inventory-ja
     */
    private final Map<Material, Integer> inventory = new HashMap<>();

    /**
     * Teleportpár a telepesnél
     */
    private TeleportPair teleportPair = null;

    @Override
    public String toString() {
        return "Settler@" + Integer.toHexString(hashCode()) + "{" +
                ("\n" + "inventory=\n" + inventory
                ).indent(4) +
                "teleportPair=\n" + teleportPair +
                "}";
    }

    /**
     * Telepes konstruktor
     * @param asteroid aszteroida, melyre a telepes kerül
     */
    public Settler(Asteroid asteroid) {
        super(asteroid);
        Game.addASettlerInNumberOfSettler();
    }

    /**
     * Telepes inventory getter
     * @return a telepes inventory-ja
     */
    public Map<Material, Integer> getInventory() {
        return inventory;
    }

    /**
     * Telepes által cipelt nyersanyagok darabszámának kalkulálása
     * @return nyersanyagok száma
     */
    private int getInventoryWeight() {
        return getInventory().values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * Bányászás
     * Nyersanyag kibányászása azon az aszteroidán, amelyen a telepes épp tartózkodik
     * @throws InventoryIsFullException az inventory tele van kivétel
     */
    public void mine() throws InventoryIsFullException, AsteroidIsNotMineable {
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
     * Teleportpár építése
     */
    public void buildTeleportPair() {
        //Map of materials needed to build
        if (buy(Bills.TELEPORT, getInventory()))
            teleportPair = new TeleportPair();
    }

    /**
     * Buy implementálása
     * Ha elegendő nyersanyag van a kiválasztott elem létrehozásához,
     * akkor eltávolítja azokat az inventoryból és true-val tér vissza,
     * ha nincs elegendő nyersanyag akkor a szükséges nyersanyagok listájával tér vissza
     *
     * @param billOfMaterial    a kiválasztott elem nyersanyagszükséglete
     * @param inventory         inventory, amiből a nyersanyagok meglétét ellenőrzi
     * @return                  true ha van elegendő nyersanyag az elem létrehozásához, false ha nincs elegendő
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
     * Bázis építése
     * Aktuális aszteroida inventorijából buy segítségével
     */
    public void buildBase() {
        if (buy(Bills.BASE, getCurrentAsteroid().getAsteroidInventory()))
            getCurrentAsteroid().buildBase();
    }

    /**
     * Robot építése
     * A robotot arra az aszteroidára helyezi le, amelyen maga a telepes is tartózkodik
     */
    public void buildRobot() {
        if (buy(Bills.ROBOT, getInventory())) {
            Robot robot = new Robot(getCurrentAsteroid());

        }
    }

    /**
     * Nyersanyag behelyezése a telepes inventory-jából aszteroidába, amelyen tartózkodik
     * @param material a behelyezendő nyersanyag
     * @throws NotEnoughMaterialException nem lehet a nyersanyagot eltávolítani, mert nincs elég belőle kivétel
     */
    public void insertMaterial(Material material) throws Exception {
        getCurrentAsteroid().insertMaterial(material);
        removeMaterial(material);
    }

    /**
     * Eltávolítja a megadott nyersanyagot az inventoryból
     * @param materialToRemove az eltávolítandó nyersanyag
     * @throws NotEnoughMaterialException nem lehet a nyersanyagot eltávolítani, mert nincs elég belőle kivétel
     */
    private void removeMaterial(Material materialToRemove) throws NotEnoughMaterialException {
        if (getInventory().getOrDefault(materialToRemove, 0) == 0) {
            throw new NotEnoughMaterialException(materialToRemove);
        }
        getInventory().computeIfPresent(materialToRemove, (material, old) -> old - 1);
    }

    /**
     * Teleportkaput helyez a megadott aszteroidára
     * @param asteroid aszteroida, melyre a teleportot helyezzük
     */
    public void deployTeleport(Asteroid asteroid) {
        //if(teleportPair != null)
        teleportPair.deployTeleport(asteroid);
    }

    /**
     * Telepes megsemmisülése
     */
    @Override
    public void die() {
        Game.removeASettlerInNumberOfSettler();
        getCurrentAsteroid().removeSpaceship(this);
    }

    /**
     * Robbanás elszenvedése
     */
    @Override
    public void getHitByExplosion() {
        die();
    }

    /**
     * Napvihar elszenvedése
     */
    @Override
    public void experienceSolarStorm() {
    }

    /**
     * Űrhajó típusának lekérdezése
     * @return az űrhajó típusa
     */
    @Override
    public String getType() {
        return "Settler";
    }

    /**
     * Lépés implementációja
     */
    @Override
    public void step() {

    }
}

