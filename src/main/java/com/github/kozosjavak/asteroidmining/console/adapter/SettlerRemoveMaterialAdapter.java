package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.SettlerMineCommand;
import com.github.kozosjavak.asteroidmining.core.commands.SettlerRemoveMaterialCommand;

public class SettlerRemoveMaterialAdapter  implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        if (splitted[0].equals("SettlerRemoveMaterial")) {
            if (splitted.length == 2) {
                return new SettlerRemoveMaterialCommand(Integer.parseInt(splitted[1]));
            } else {
                System.out.println("Not enough IDs for the command");
            }
        }
        return null;
    }
}
