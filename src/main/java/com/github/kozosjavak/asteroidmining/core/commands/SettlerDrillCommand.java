package com.github.kozosjavak.asteroidmining.core.commands;

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
     *
     * @param game a jatek melyre alkalmazzuk
     * @throws Exception
     */
    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(settlerID).getClass() == Settler.class) {
            Settler settler = (Settler) game.getObjectFromID(settlerID);
            try {
                settler.drill();
            } catch (Exception exception) {
                System.err.println("Surface thickness is zero");
            }
        } else {
            System.out.println("Invalid Settler ID!\n");
        }

    }
}
