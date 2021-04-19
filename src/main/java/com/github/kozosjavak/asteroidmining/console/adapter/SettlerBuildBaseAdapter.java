package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.SettlerBuildBaseCommand;

public class SettlerBuildBaseAdapter implements StringCommandAdapter {

    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");

        if (splitted[0].equals("SettlerBuildBase")) {
            if (splitted.length == 2) return new SettlerBuildBaseCommand(Integer.parseInt(splitted[1]));
            else System.out.println("Not enough IDs for the command");
        }

        return null;
    }
}
