package com.github.kozosjavak.asteroidmining.core;

public class AsteroidNotMinedException extends Exception {
    public AsteroidNotMinedException() {
        super("Asteroid hasn't been mined!");
    }
}
