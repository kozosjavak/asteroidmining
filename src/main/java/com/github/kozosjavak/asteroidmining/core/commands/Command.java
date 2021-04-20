package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;

import java.io.Serializable;

/**
 * Interface of the Commands
 */
public interface Command extends Serializable {
    /**
     * Can be call for execute the specific command
     *
     * @param game game
     */
    void apply(Game game);
}
