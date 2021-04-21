package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.SettlerInsertMaterialCommand;

public class SettlerInsertMaterialAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        if (splitted[0].equals("SettlerInsertMaterial")) {
            if (splitted.length == 2) {
                return new SettlerInsertMaterialCommand(Integer.parseInt(splitted[1]));
            } else {
                System.out.println("Invalid command");
            }

        }
        return null;
    }

}
