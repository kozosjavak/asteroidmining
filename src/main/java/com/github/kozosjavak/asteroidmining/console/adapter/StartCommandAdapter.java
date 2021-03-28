package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.StartCommand;

public class StartCommandAdapter implements StringCommandAdapter {

    @Override
    public Command parse(String str) {
        if (str.equals("start")) {
            return new StartCommand();
        }
        return null;
    }
}
