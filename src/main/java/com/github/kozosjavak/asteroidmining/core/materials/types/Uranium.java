package com.github.kozosjavak.asteroidmining.core.materials.types;

import com.github.kozosjavak.asteroidmining.core.Explodeable;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.materials.Material;

public class Uranium implements Material {
    private int experienceExtremeHeatCounter = 0;

    public void experienceExtremeHeat(Explodeable explodeableHolder) throws Exception {
        if (experienceExtremeHeatCounter < 3) {
            experienceExtremeHeatCounter++;
        }
        if (experienceExtremeHeatCounter > 2) {
            explodeableHolder.explode();
        }
        System.out.println(experienceExtremeHeatCounter);
    }

    @Override
    public String toString(int depth, Game game) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";

        return tab + "Uran {ID = " + game.getId(this) + ", HeatCounter = " + experienceExtremeHeatCounter + "},\n";
    }

    @Override
    public String toString() {
        return "Uranium";
    }

    public void setExperienceExtremeHeatCounter(int count) {
        experienceExtremeHeatCounter = count;
    }
}