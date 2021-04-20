package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.CreateMaterialCommand;

public class CreateMaterialAdapter implements StringCommandAdapter {

    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        if (splitted[0].equals("CreateMaterial") && splitted.length > 1) {
            boolean validMaterial = splitted[1].equals("iron") ||
                    splitted[1].equals("waterice") ||
                    splitted[1].equals("uran") ||
                    splitted[1].equals("coal");
            if (validMaterial) {
                return new CreateMaterialCommand(splitted);
            } else System.out.printf("Wrong name of Material, command invalid.\n");
        }
        return null;
    }
}
