package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.UfoStealCommand;

public class UfoStealAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");

        if (splitted[0].equals("UfoSteal")) {
            if (splitted.length == 2) {
                return new UfoStealCommand(Integer.parseInt(splitted[1]));
            }
            System.out.println("No id has given!\n");
        }

        return null;
    }
}
