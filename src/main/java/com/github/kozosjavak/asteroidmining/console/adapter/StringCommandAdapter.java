package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;

/**
 * Interface of the adapters
 */

public interface StringCommandAdapter {
    /**
     * Get a string and if the str contains the command returns the specific command
     *
     * @param str String
     * @return Command
     */
    Command parse(String str);
}
