package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

public class SettlerBuildBaseCommand implements Command {

    private final int settlerId;

    public SettlerBuildBaseCommand(int settlerId) {
        this.settlerId = settlerId;
    }

    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(settlerId).getClass() == Settler.class) {
            Settler settler = (Settler) game.getObjectFromID(settlerId);
            try {
                settler.buildBase();
            } catch (NotEnoughMaterialException e) {
                System.err.println("Not enough material!");
            } catch (InventoryIsFullException e) {
                System.err.println("Inventory is full!");
            }
        } else System.out.printf("Invalid object ID");
    }
}
