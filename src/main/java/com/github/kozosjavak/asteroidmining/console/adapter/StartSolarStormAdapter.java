package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.StartSolarStormCommand;
public class StartSolarStormAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        if (str.equals("StartSolarStorm")) {
            return new StartSolarStormCommand();
        }
        return null;
    }
}
