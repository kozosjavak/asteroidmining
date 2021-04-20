package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.Material;

/**
 * Telepeshez nyersanyag hozzaadasa parancs implementacio
 */
public class SettlerAddMaterialCommand implements Command {
    private final int settlerID;
    private final int materialID;

    /**
     * Parancs ctor
     *
     * @param settlerID  a telepes akihez hozza adjuk a nyersanyagot az inventoryba
     * @param materialID nyersanyag amit hozzaadunk
     */
    public SettlerAddMaterialCommand(int settlerID, int materialID) {
        this.settlerID = settlerID;
        this.materialID = materialID;
    }

    /**
     * Parancs applikalasa a jatekra
     *
     * @param game a jatek melyre alkalmazzuk
     * @throws Exception
     */
    @Override
    public void apply(Game game) {
        if ((game.getObjectFromID(settlerID).getClass() == Settler.class) && (game.getObjectFromID(materialID).getClass().getInterfaces()[0] == Material.class)) {
            Settler settler = (Settler) game.getObjectFromID(settlerID);
            Material material = (Material) game.getObjectFromID(materialID);
            try {
                settler.addToInventory(material);
            } catch (InventoryIsFullException e) {
                System.err.println("Inventory is full");
            }
        } else {
            System.out.println("Invalid Settler and/or Material ID!\n");
        }
    }
}
