package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.ShowGameStateCommand;

/**
 * Az ShowGameState parancs adaptere.
 */
public class ShowGameStateAdapter implements StringCommandAdapter {

    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");

        if (splitted[0].equals("ShowGameState")) {
            return new ShowGameStateCommand();
        }

        return null;
    }
}
