package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.CreateSunCommand;

public class CreateSunAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        if (str.equals("CreateSun")) {
            return new CreateSunCommand();
        }
        return null;
    }
}
