package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.SettlerBuildRobotCommand;

public class SettlerBuildRobotAdapter implements StringCommandAdapter {
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        if (splitted[0].equals("SettlerBuildRobot")) {
            if (splitted.length == 2) {
                return new SettlerBuildRobotCommand(Integer.parseInt(splitted[1]));
            } else System.out.println("Command needs a Settler ID");
        }
        return null;
    }
}