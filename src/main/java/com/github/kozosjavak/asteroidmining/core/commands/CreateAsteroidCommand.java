package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Location;
import com.github.kozosjavak.asteroidmining.core.materials.Material;


/**
 * Aszteroida letrehozasa parancs implementacio
 */
public class CreateAsteroidCommand implements Command {
    private final int surfaceThickness;
    private final int materialID;

    /**
     * Parancs ctor
     * @param surfaceThickness az aszteroida kopenyvastagsaga
     * @param materialID
     */
    public CreateAsteroidCommand(int surfaceThickness, int materialID) {
        this.surfaceThickness = surfaceThickness;
        this.materialID = materialID; // if -1 then empty
    }

    /**
     * Parancs applikalasa a jatekra
     * @param game a jatek melyre alkalmazzuk
     * @param game
     */
    @Override
    public void apply(Game game) {
        Location loc = new Location(game, 0.0, 0.0);
        Asteroid asteroid = null;

        if(surfaceThickness < 0) {
            System.out.println("Invalid surface thickness!\n");
            return;
        }

        if (materialID != -1) {
            if(game.getObjectFromID(materialID) != null) {
                if (game.getObjectFromID(materialID).getClass().getSuperclass() == Object.class) { // bovithetoseg miatt nem jobban definialt
                    asteroid = new Asteroid(loc, surfaceThickness, false, (Material) game.getObjectFromID(materialID), 0);
                }
                else {
                    System.out.println("Invalid material ID!\n");
                    return;
                }
            }
            else {
                System.out.println("Invalid material ID!\n");
                return;
            }
        }
        else {
            asteroid = new Asteroid(loc, surfaceThickness, false, null, 0);
        }

        game.addLocation(loc);
        game.putInIdList(asteroid);
    }
}
