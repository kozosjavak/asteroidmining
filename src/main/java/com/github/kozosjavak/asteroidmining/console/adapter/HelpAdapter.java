package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.HelpCommand;

public class HelpAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        if (str.equalsIgnoreCase("help")) {
            return new HelpCommand();
        }
        return null;
    }
}
