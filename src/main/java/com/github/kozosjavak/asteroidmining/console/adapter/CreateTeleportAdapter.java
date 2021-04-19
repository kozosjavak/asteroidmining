package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.CreateTeleportCommand;

public class CreateTeleportAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        if (str.equals("CreateTeleport")) {
            return new CreateTeleportCommand();
        }
        return null;
    }
}
