package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.materials.Material;

public class InsertMaterialCommand implements Command {
    private final int materialId;
    private final int asteroidID;

    public InsertMaterialCommand(int materialId, int asteroidID) {
        this.materialId = materialId;
        this.asteroidID = asteroidID;
    }

    @Override
    public void apply(Game game) throws Exception {
        if (game.getObjectFromID(asteroidID).getClass() == Asteroid.class && game.getObjectFromID(materialId).getClass().getInterfaces()[0] == Material.class) {
            Asteroid asteroid = (Asteroid) game.getObjectFromID(asteroidID);
            asteroid.insertSubstance((Material) game.getObjectFromID(materialId));
        } else {
            System.out.println("Invalid Asteroid or Material!\n");
        }
    }
}
