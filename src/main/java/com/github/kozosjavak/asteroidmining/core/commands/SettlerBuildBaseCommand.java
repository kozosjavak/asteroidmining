package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Settler;

public class SettlerBuildBaseCommand implements Command {

    private final int settlerId;

    public SettlerBuildBaseCommand(int settlerId) {
        this.settlerId = settlerId;
    }

    @Override
    public void apply(Game game) throws Exception {
        if (game.getObjectFromID(settlerId).getClass() == Settler.class) {
            Settler settler = (Settler) game.getObjectFromID(settlerId);
            settler.buildBase();
        } else System.out.printf("Invalid object ID");
    }
}
