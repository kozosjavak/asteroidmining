package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

public class SettlerRemoveMaterialCommand implements Command{
    private final int settlerID;
    /**
     * Parancs ctor
     * @param settlerID
     */
    public  SettlerRemoveMaterialCommand(int settlerID) {
        this.settlerID = settlerID;
    }

    /**
     * Parancs applikalasa a jatekra
     *
     * @param game a jatek melyre alkalmazzuk
     * @throws Exception
     */
    @Override
    public void apply(Game game) {
        Settler settler = (Settler) game.getObjectFromID(settlerID);
        Asteroid asteroid = settler.getCurrentAsteroid();
        if (asteroid.getMaterials().get(0) != null) {
            try {
                asteroid.removeMaterial(asteroid.getMaterials().get(0));
            } catch (NotEnoughMaterialException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Asteroid inventory is empty\n");
        }
    }
}
