package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.SettlerAddMaterialCommand;

public class SettlerAddMaterialAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        if (splitted[0].equals("InsertMaterial")) {
            if (splitted.length == 3) {
                return new SettlerAddMaterialCommand(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]));
            } else System.out.println("Not enough IDs for the command");
        }
        return null;
    }
}
