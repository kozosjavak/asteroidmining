package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.Teleport;

/**
 * Teleport osszerendeles parancs implementacio
 */
public class LinkTeleportsCommand implements Command {
    private final int teleportAid;
    private final int teleportBid;

    /**
     * Parancs ctor
     * @param teleportAid az egyik teleport id-ja
     * @param teleportBid a masik teleport id-ja
     */
    public LinkTeleportsCommand(int teleportAid, int teleportBid) {
        this.teleportAid = teleportAid;
        this.teleportBid = teleportBid;
    }

    /**
     * Parancs applikalasa a jatekra
     * @param game a jatek melyre alkalmazzuk
     * @throws Exception
     */
    @Override
    public void apply(Game game) throws Exception {
        if ((game.getObjectFromID(teleportAid).getClass() == Teleport.class) && (game.getObjectFromID(teleportBid).getClass() == Teleport.class)) {
            Teleport teleportA = new Teleport((Teleport) game.getObjectFromID(teleportAid));
            Teleport teleportB = new Teleport((Teleport) game.getObjectFromID(teleportBid));
            teleportA.setPair(teleportB);
            teleportB.setPair(teleportA);
        } else {
            System.out.println("Invalid Teleport ID!\n");
        }
    }
}
