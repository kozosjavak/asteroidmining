package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Ufo;

public class UfoStealCommand implements Command {

    private final int ufoId;

    public UfoStealCommand(int ufoId) {
        this.ufoId = ufoId;
    }

    @Override
    public void apply(Game game) {
        if (game.getObjectFromID(ufoId) instanceof Ufo ufo) {
            ufo.steal();
        } else {
            System.out.println("Invalid object ID");
        }
    }
}
