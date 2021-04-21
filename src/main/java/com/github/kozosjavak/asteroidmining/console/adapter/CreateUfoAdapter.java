package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.CreateSettlerCommand;
import com.github.kozosjavak.asteroidmining.core.commands.CreateUfoCommand;

public class CreateUfoAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        if (splitted[0].equals("CreateUfo")) {
            if (splitted.length == 2) {
                return new CreateUfoCommand(Integer.parseInt(splitted[1]));
            }
            System.out.println("No id has given!\n");
        }
        return null;
    }
}
