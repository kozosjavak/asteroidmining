package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.AsteroidAlreadyMinedException;
import com.github.kozosjavak.asteroidmining.core.AsteroidIsNotMineable;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;

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
     *
     * @param game a jatek melyre alkalmazzuk
     * @throws Exception
     */
    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(settlerID).getClass() == Settler.class) {
            Settler settler = (Settler) game.getObjectFromID(settlerID);
            try {
                settler.mine();
            } catch (InventoryIsFullException e) {
                System.err.println("Inventory is full!");
            } catch (AsteroidIsNotMineable asteroidIsNotMineable) {
                System.err.println("Asteroid is not mineable!");
            } catch (AsteroidAlreadyMinedException e) {
                System.err.println("Asteroid is already miend");
            }
        }
        else {
            System.out.println("Invalid Settler ID!\n");
        }
    }
}
