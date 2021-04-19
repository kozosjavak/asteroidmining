package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Settler;

/**
 * Telepes banyaszik parancs implementacio
 */
public class SettlerMineCommand implements Command{
    private final int settlerID;

    /**
     * Parancs ctor
     * @param settlerID
     */
    public SettlerMineCommand(int settlerID) {
        this.settlerID = settlerID;
    }


    /**
     * Parancs applikalasa a jatekra
     * @param game a jatek melyre alkalmazzuk
     * @throws Exception
     */
    @Override
    public void apply(Game game) throws Exception {
        if (game.getObjectFromID(settlerID).getClass() == Settler.class) {
            Settler settler = (Settler) game.getObjectFromID(settlerID);
            settler.mine();
        }
        else {
            System.out.println("Invalid Settler ID!\n");
        }
    }
}
