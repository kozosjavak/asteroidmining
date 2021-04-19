package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Settler;

/**
 * Telepes fur parancs implementacio
 */
public class SettlerDrillCommand implements Command {
    private final int settlerID;

    /**
     * Parancs ctor
     * @param settlerID
     */
    public SettlerDrillCommand(int settlerID) {
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
        settler.drill();
    }
}
