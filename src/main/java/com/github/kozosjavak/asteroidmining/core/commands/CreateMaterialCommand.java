package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.core.materials.types.Waterice;

public class CreateMaterialCommand implements Command {

    String[] data;

    public CreateMaterialCommand(String[] data) {
        this.data = data;
    }

    @Override
    public void apply(Game game) {
        Material mat;
        if (data[1].equals("iron")) {
            mat = new Iron();
        } else if (data[1].equals("coal")) {
            mat = new Coal();
        } else if (data[1].equals("waterice")) {
            mat = new Waterice();
        } else if (data[1].equals("uran")) {
            Uranium uran = new Uranium();
            if (data.length == 3) uran.setExperienceExtremeHeatCounter(Integer.parseInt(data[2]));
            mat = uran;
        } else {
            return;
        }
        game.putInIdList(mat);
    }
}
