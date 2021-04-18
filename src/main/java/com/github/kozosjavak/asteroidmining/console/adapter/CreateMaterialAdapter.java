package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.CreateMaterialCommand;

public class CreateMaterialAdapter implements StringCommandAdapter {

    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        boolean validMaterial = splitted[1].equals("iron") ||
                splitted[1].equals("waterice") ||
                splitted[1].equals("uran") ||
                splitted[1].equals("coal");

        if (splitted[0].equals("CreateMaterial") && validMaterial) {
            return new CreateMaterialCommand(splitted[1]);
        } else if (!splitted[0].equals("CreateMaterial")) {
            return null;
        }
        System.out.printf("Wrong name of Material, command invalid.\n");
        return null;
    }
}
