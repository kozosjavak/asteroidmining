package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.bills.Bills;
import com.github.kozosjavak.asteroidmining.core.materials.Inventory;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

/**
 * Settler class
 */
public class Settler extends Spaceship implements Steppable {

    /**
     * Settler's inventory
     */
    private final Inventory inventory = new Inventory(10);
    /**
     * Settler's teleport inventory array
     */
    private final Teleport[] teleportInventory = new Teleport[3];

    /**
     * Basic constructor
     *
     * @param asteroid Asteroid, where will be placed
     */
    public Settler(Asteroid asteroid) {
        super(asteroid);
        getCurrentAsteroid().getLocation().game.getSettlers().add(this);
    }

    /**
     * give back "Settler"
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Settler";
    }

    /**
     * Gives back the settler inventory
     *
     * @return Inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Adds material to the settler's inventory
     *
     * @param material Material, which have to be added
     * @throws InventoryIsFullException if the inventory is full
     */
    public void addToInventory(Material material) throws InventoryIsFullException {
        inventory.add(material);
    }

    /**
     * Gives back the teleport inventory array
     *
     * @return Teleport[]
     */
    public Teleport[] getTeleportInventory() {
        return teleportInventory;
    }

    /**
     * Mining
     * Mine the material from the Asteroid where settlers currently on
     *
     * @throws InventoryIsFullException inventory is full
     * @throws AsteroidIsNotMineable    Asteroid can't be mined
     */
    public void mine() throws InventoryIsFullException, AsteroidIsNotMineable {
        if (!inventory.isFull()) {
            inventory.add(getCurrentAsteroid().mine());
        }
    }

    /**
     * Drills, remove a layer of crust
     *
     * @throws Exception
     */
    public void drill() throws Exception {
        getCurrentAsteroid().drill();
    }

    /**
     * Builds a teleport pair and puts in the teleport inventory
     */
    public void buildTeleportPair() throws NotEnoughMaterialException {
        int numberOfEmptyElement;

        numberOfEmptyElement = 0;
        for (Teleport teleport : teleportInventory) {
            if (teleport == null) {
                numberOfEmptyElement += 1;
            }
        }

        Bills.TELEPORT.buy(inventory);

        if (numberOfEmptyElement > 1) {
            Teleport t1 = new Teleport();
            Teleport t2 = new Teleport(t1);
            t1.setPair(t2);
            for (int i = 0; i < teleportInventory.length; i++) {
                if (teleportInventory[i] == null) {
                    teleportInventory[i] = t1;
                    break;
                }

            }
            for (int i = 0; i < teleportInventory.length; i++) {
                if (teleportInventory[i] == null) {
                    teleportInventory[i] = t2;
                    break;
                }

            }
        } else {
            System.out.println("Not enough space in teleport inventory");
        }
    }


    /**
     * Builds base
     *
     * @throws NotEnoughMaterialException not enough material on the asteroid, combined with the inventory of the settler
     * @throws InventoryIsFullException
     */
    public void buildBase() throws NotEnoughMaterialException, InventoryIsFullException {
        Inventory inventoryFromAsteroidAndSettler = new Inventory(0);
        for (int i = 0; i < getCurrentAsteroid().getAsteroidInventory().getSize(); i++) {
            inventoryFromAsteroidAndSettler.add(getCurrentAsteroid().getAsteroidInventory().getList().get(i));
        }
        for (int i = 0; i < getInventory().getSize(); i++) {
            inventoryFromAsteroidAndSettler.add(getInventory().getList().get(i));
        }
        Bills.BASE.buy(inventoryFromAsteroidAndSettler);
        getCurrentAsteroid().buildBase();
    }

    /**
     * Build robot
     *
     * @return Robot
     * @throws NotEnoughMaterialException not enough material
     */
    public Robot buildRobot() throws NotEnoughMaterialException {
        Bills.ROBOT.buy(inventory);
        return new Robot(getCurrentAsteroid());
    }


    /**
     * Place teleport on the location where the currently asteroid is
     *
     * @param number ID of the teleport which will be placed
     */
    public void deployTeleport(int number) {
        if (teleportInventory[number] != null) {
            teleportInventory[number].deployTeleport(getCurrentAsteroid().getLocation());
            teleportInventory[number] = null;
        }
    }

    /**
     * Settlers dies
     */
    @Override
    public void die() {
        getCurrentAsteroid().getLocation().game.removeSettlerFromGame(this);
        getCurrentAsteroid().removeSpaceship(this);
        setCurrentAsteroid(null);
    }

    /**
     * Puts back material in the asteroid inventory
     *
     * @throws AsteroidNotMinedException if the asteroid not mined
     * @throws InventoryIsFullException  if the asteroid inventory is full
     */
    public void insertMaterial() throws AsteroidNotMinedException, InventoryIsFullException, NotEnoughMaterialException {
        if (inventory.getSize() > 0) {
            getCurrentAsteroid().insertMaterial(inventory.getList().get(0));
            inventory.remove(inventory.getList().get(0).getClass(), 1);
        }
    }


    /**
     * Implementation of the step(), settler can be controlled from there
     */
    @Override
    public void step() {
        //itt kontrollalsz
        //hivd meg a drill().
    }

    /**
     * Implementation of the experienceExtremeHeat(), it calls the experienceExteremeHeat() of the inventory
     *
     * @throws Exception
     */
    @Override
    public void experienceExtremeHeat() throws Exception {
        if (inventory.getSize() != 0) {
            inventory.experienceExtremeHeat(this);
        }
    }

    /**
     * Return the settler structure in string
     *
     * @param depth needed for the correct amount of /t before the data for correct write out
     * @param game  needed for give the ID of itself
     * @return String
     */
    @Override
    public String toString(int depth, Game game) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";

        String out = tab + "Settler {\n" +
                tab + "\tID = " + game.getId(this) + ",\n";
        out += tab + "\tInentory = {\n" + inventory.toString(depth + 2, game);
        out += tab + "\t},\n";
        out += tab + "\tTeleportInventory = {\n";
        for (int i = 0; i < 3; i++) {
            if (teleportInventory[i] != null) out += tab + "\t\t" + teleportInventory[i].toString(depth + 3, game);
        }
        out += tab + "\t}\n";
        out += tab + "}";
        return out;
    }
}

