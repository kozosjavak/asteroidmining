package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.SpaceshipMoveCommand;

public class SpaceshipMoveAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        if (splitted[0].equals("SpaceshipMove")) {
            if (splitted.length > 2) {
                return new SpaceshipMoveCommand(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]));
            } else {
                System.out.println("Not enough IDs for the command");
            }
        }
        return null;
    }
}
