package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.AddTeleportCommand;
import com.github.kozosjavak.asteroidmining.core.commands.Command;

public class AddTeleportAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        if (splitted[0].equals("AddTeleport")) {
            if (splitted.length == 3) {
                return new AddTeleportCommand(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]));
            } else {
                System.out.println("Not enough IDs for the command");
            }
        }
        return null;
    }

}
