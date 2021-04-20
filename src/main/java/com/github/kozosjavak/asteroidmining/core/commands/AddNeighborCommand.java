package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Orb;
import com.github.kozosjavak.asteroidmining.core.Sun;

/**
 * Két Orb közötti szomszédség létrehozását megvalósító parancs.
 * AddNeighbor <OrbID1> <OrbID2>
 */
public class AddNeighborCommand implements Command {

    /**
     * A aparancsnak átadott két Orb objektum ID-ja
     */
    private final int objId1;
    private final int objId2;

    public AddNeighborCommand(int astreoidId1, int objId2) {
        this.objId1 = astreoidId1;
        this.objId2 = objId2;
    }

    /**
     * Összelinkeli a két Orb-ot, ha az egyik Nap a napközelséget idéz elő.
     *
     * @param game
     * @throws Exception
     */
    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(objId1) != null && game.getObjectFromID(objId2) != null && objId1 != objId2) {
            if (game.getObjectFromID(objId1).getClass().getSuperclass() == Orb.class && game.getObjectFromID(objId2).getClass().getSuperclass() == Orb.class) {
                Orb orb1 = (Orb) game.getObjectFromID(objId1);
                Orb orb2 = (Orb) game.getObjectFromID(objId2);
                orb1.getLocation().addNeighbor(orb2.getLocation());
                orb2.getLocation().addNeighbor(orb1.getLocation());
                try {
                    if (game.getObjectFromID(objId1).getClass() == Sun.class) {
                        orb2.experienceExtremeHeat();
                    } else if (game.getObjectFromID(objId2).getClass() == Orb.class) {
                        orb1.experienceExtremeHeat();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace(); // TODO
                }
                return;
            }
        }
        System.out.println("Invalid Object ID");
    }
}
