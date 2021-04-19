package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Ufo;

/**
 * Ufo letrehozasa parancs implementacio
 */
public class CreateUfoCommand implements Command{
    private final int asteroidID;

    /**
     * Parancs ctor
     * @param asteroidID az aszteroida ID-ja melyre az ufo-t akarjuk letrehozni
     */
    public CreateUfoCommand(int asteroidID) {
        this.asteroidID = asteroidID;
    }

    /**
     * Parancs applikalasa a jatekra
     * @param game a jatek melyre alkalmazzuk
     * @throws Exception
     */
    @Override
    public void apply(Game game) throws Exception {
        if (game.getObjectFromID(asteroidID).getClass() == Asteroid.class) {
            Asteroid asteroid = (Asteroid) game.getObjectFromID(asteroidID);
            Ufo ufo = new Ufo(asteroid);
            game.putInIdList(ufo);
        }
        else {
            System.out.println("Invalid Asteroid ID!\n");
        }
    }
}
