package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.core.materials.types.Waterice;

public class CreateMaterialCommand implements Command {
    String data;


    public CreateMaterialCommand(String data) {
        this.data = data;
    }

    @Override
    public void apply(Game game) throws Exception {
        Material mat;
        if (data.equals("iron")) {
            mat = new Iron();
        } else if (data.equals("coal")) {
            mat = new Coal();
        } else if (data.equals("waterice")) {
            mat = new Waterice();
        } else if (data.equals("uran")) {
            mat = new Uranium();
        } else {
            return;
        }
        game.putInIdList(mat);
    }
}
