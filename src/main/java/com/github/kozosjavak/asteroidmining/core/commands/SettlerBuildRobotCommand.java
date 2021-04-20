package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Robot;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

public class SettlerBuildRobotCommand implements Command {

    private final int settlerId;

    public SettlerBuildRobotCommand(int settlerId) {
        this.settlerId = settlerId;
    }

    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(settlerId).getClass() == Settler.class) {
            Settler settler = (Settler) game.getObjectFromID(settlerId);
            try {
                Robot robot = settler.buildRobot();
                game.putInIdList(robot);
            } catch (NotEnoughMaterialException e) {
                System.err.println("Not enough materials to build the robot");
            }

        } else System.out.printf("Invalid object ID");
    }
}
