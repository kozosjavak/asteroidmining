package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.bills.Bills;
import com.github.kozosjavak.asteroidmining.core.materials.Inventory;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

/**
 * Telepes osztály
 */
public class Settler extends Spaceship implements Steppable {

    /**
     * A telepes inventory-ja
     */
    private final Inventory inventory = new Inventory(10);
    // ez egy issue
    private final Teleport[] teleportInventory = new Teleport[3];

    /**
     * Telepes konstruktor
     *
     * @param asteroid aszteroida, melyre a telepes kerül
     */
    public Settler(Asteroid asteroid) {
        super(asteroid);
        getCurrentAsteroid().getLocation().game.addASettlerInGame(this);
    }

    @Override
    public String toString() {
        return "Settler";
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addToInventory(Material material) throws InventoryIsFullException {inventory.add(material);}

    public Teleport[] getTeleportInventory(){
        return teleportInventory;
    }

    /**
     * Bányászás
     * Nyersanyag kibányászása azon az aszteroidán, amelyen a telepes épp tartózkodik
     *
     * @throws InventoryIsFullException az inventory tele van kivétel
     * @throws AsteroidIsNotMineable    az asteroida nem bányászható állapotban van
     */
    public void mine() throws InventoryIsFullException, AsteroidIsNotMineable {
        inventory.add(getCurrentAsteroid().mine());
    }

    public void drill() throws Exception {
        getCurrentAsteroid().drill();
    }

    /**
     * Teleportpár építése
     */
    public void buildTeleportPair() throws NotEnoughMaterialException {
        int numberOfEmptyElement;

        numberOfEmptyElement = 0;
        for (Teleport teleport : teleportInventory) {
            if (teleport == null) {
                numberOfEmptyElement += 1;
            }
        }
        if (Bills.TELEPORT.buy(inventory)) {
            if(numberOfEmptyElement>1){
                Teleport t1 = new Teleport();
                Teleport t2 = new Teleport(t1);
                t1.setPair(t2);
                for(int i = 0; i < teleportInventory.length; i++) {
                    if(teleportInventory[i] == null) {
                        teleportInventory[i]=t1;
                    break;}

                }
                for(int i = 0; i < teleportInventory.length; i++) {
                    if(teleportInventory[i] == null) {
                        teleportInventory[i]=t2;
                        break; }

                }
            }
            else{
                System.out.println("Not enough space in teleport inventory");
            }
        }

    }


    /**
     * Bázis építése
     * Aktuális aszteroida inventorijából buy segítségével
     */
    public void buildBase() throws NotEnoughMaterialException, InventoryIsFullException {
        Inventory inventoryFromAsteroidAndSettler = new Inventory(0);
        for(int i=0;i< getCurrentAsteroid().getAsteroidInventory().getSize();i++) {
            inventoryFromAsteroidAndSettler.add(getCurrentAsteroid().getAsteroidInventory().getList().get(i));
        }
        for(int i=0;i< getInventory().getSize();i++) {
            inventoryFromAsteroidAndSettler.add(getInventory().getList().get(i));
        }
        if (Bills.BASE.buy(inventoryFromAsteroidAndSettler))
            getCurrentAsteroid().buildBase();
    }

    /**
     * Robot építése
     * A robotot arra az aszteroidára helyezi le, amelyen maga a telepes is tartózkodik
     */
    public void buildRobot() throws NotEnoughMaterialException {
        if (Bills.ROBOT.buy(inventory)) {
            Robot robot = new Robot(getCurrentAsteroid());
        }
    }


    /**
     * Teleportkaput helyez a megadott aszteroidára
     *
     * @param number aszteroida, melyre a teleportot helyezzük
     */
    public void deployTeleport(int number) {
        if( teleportInventory[number] != null) {
            teleportInventory[number].deployTeleport(getCurrentAsteroid().getLocation());
            teleportInventory[number]=null;
        }
    }

    /**
     * Telepes megsemmisülése
     */
    @Override
    public void die() {
        getCurrentAsteroid().getLocation().game.removeSettlerFromGame(this);
        getCurrentAsteroid().removeSpaceship(this);
        setCurrentAsteroid(null);
    }


    public void insertMaterial() throws AsteroidNotMinedException, InventoryIsFullException {
        getCurrentAsteroid().insertMaterial(inventory.getList().get(0));
    }


    /**
     * Lépés implementációja
     */
    @Override
    public void step() {
        //itt kontrollalsz
        //hivd meg a drill().
    }


    @Override
    public void experienceExtremeHeat() throws Exception {
        if (inventory.getSize() != 0) {
            inventory.experienceExtremeHeat(this);
        }
    }

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

