package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.LinkTeleportsCommand;

public class LinkTeleportsAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        if (splitted[0].equals("LinkTeleports")) {
            if (splitted.length == 3) {
                return new LinkTeleportsCommand(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]));
            }
            System.out.println("Not enough IDs for the command");
        }
        return null;
    }
}
