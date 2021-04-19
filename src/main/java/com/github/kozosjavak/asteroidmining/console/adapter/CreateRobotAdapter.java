package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.CreateRobotCommand;

public class CreateRobotAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        if (splitted[0].equals("CreateRobot")) {
            if (splitted.length == 2) {
                return new CreateRobotCommand(Integer.parseInt(splitted[1]));
            }
        }
        return null;
    }
}
