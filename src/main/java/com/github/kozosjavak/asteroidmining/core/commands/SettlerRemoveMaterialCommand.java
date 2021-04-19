package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Location;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.materials.Material;

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
     * @param game a jatek melyre alkalmazzuk
     * @throws Exception
     */
    @Override
    public void apply(Game game) throws Exception {
        Settler settler = (Settler) game.getObjectFromID(settlerID);
        Asteroid asteroid=settler.getCurrentAsteroid();
        if(asteroid.getMaterials().get(0)!=null){
            asteroid.removeMaterial(asteroid.getMaterials().get(0));
        }else{
            System.out.println("Asteroid inventory is empty\n");
        }
    }
}
