package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.AsteroidExplodeCommand;
import com.github.kozosjavak.asteroidmining.core.commands.Command;

public class AsteroidExplodeAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        if (splitted[0].equals("AsteroidExplode")) {
            if (splitted.length == 2) {
                return new AsteroidExplodeCommand(Integer.parseInt(splitted[1]));
            }
            System.out.println("No id has given!\n");
        }
        return null;
    }
}
