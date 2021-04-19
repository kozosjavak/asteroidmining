package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.SettlerBuildTeleportCommand;

public class SettlerBuildTeleportAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");

        if (splitted[0].equals("SettlerBuildTeleport")) {
            if (splitted.length == 2) {
                return new SettlerBuildTeleportCommand(Integer.parseInt(splitted[1]));
            }
            System.out.println("No id has given!\n");
        }

        return null;
    }
}
