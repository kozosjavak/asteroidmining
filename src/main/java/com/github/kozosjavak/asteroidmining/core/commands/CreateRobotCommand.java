package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Robot;

public class CreateRobotCommand implements Command {
    private final int asteroidID;

    public CreateRobotCommand(int asteroidID) {
        this.asteroidID = asteroidID;
    }

    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(asteroidID).getClass() == Asteroid.class) {
            Robot robot = new Robot((Asteroid) game.getObjectFromID(asteroidID));
            game.putInIdList(robot);
        } else {
            System.out.println("Wrong asteroid ID!");
        }

    }
}
