package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.AsteroidNotMinedException;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

public class SettlerInsertMaterialCommand implements Command {
    private final int settlerID;
    private final int materialID;

    public SettlerInsertMaterialCommand(int settlerID, int materialID) {
        this.settlerID = settlerID;
        this.materialID = materialID;
    }

    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(settlerID).getClass() == Settler.class && game.getObjectFromID(materialID).getClass().getInterfaces()[0] == Material.class) {
            Settler settler = (Settler) game.getObjectFromID(settlerID);
            try {
                settler.insertMaterial();
            } catch (AsteroidNotMinedException e) {
                e.printStackTrace(); // TODO
            } catch (InventoryIsFullException e) {
                e.printStackTrace(); // TODO
            } catch (NotEnoughMaterialException e) {
                e.printStackTrace();
            }
        }
    }
}
