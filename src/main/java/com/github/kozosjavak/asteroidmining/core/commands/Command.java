package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;

import java.io.Serializable;


public interface Command extends Serializable {
    void apply(Game game) throws Exception;
}
