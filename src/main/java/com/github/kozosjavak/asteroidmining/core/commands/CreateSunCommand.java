package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Location;
import com.github.kozosjavak.asteroidmining.core.Sun;

/**
 * Nap letrehozasa parancs implementacio
 */
public class CreateSunCommand implements Command {

    /**
     * Parancs ctor
     */
    public CreateSunCommand() { }

    /**
     * Parancs applikalasa a jatekra
     *
     * @param game a jatek melyre alkalmazzuk
     * @throws Exception
     */
    @Override
    public void apply(Game game) {
        Location loc = new Location(game, 0.0, 0.0);
        Sun sun = new Sun(loc);
        game.addLocation(loc);
        game.putInIdList(sun);
    }
}
