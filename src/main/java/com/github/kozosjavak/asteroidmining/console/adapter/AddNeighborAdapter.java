package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.AddNeighborCommand;
import com.github.kozosjavak.asteroidmining.core.commands.Command;

/**
 * Az AddNeighbor parancs adaptere.
 */
public class AddNeighborAdapter implements StringCommandAdapter {

    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");

        if (splitted[0].equals("AddNeighbor")) {
            return new AddNeighborCommand(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]));
        }

        return null;
    }
}
