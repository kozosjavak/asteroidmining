package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.AsteroidNotMinedException;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

public class SettlerInsertMaterialCommand implements Command {
    private final int settlerID;

    public SettlerInsertMaterialCommand(int settlerID) {
        this.settlerID = settlerID;
    }

    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(settlerID).getClass() == Settler.class) {
            Settler settler = (Settler) game.getObjectFromID(settlerID);
            try {
                settler.insertMaterial();
            } catch (AsteroidNotMinedException e) {
                System.err.println("Asteroid not mined!");
            } catch (InventoryIsFullException e) {
                System.err.println("Inventory is full!");
            } catch (NotEnoughMaterialException e) {
                System.err.println("Not enough material!");
            }
        }
    }
}
