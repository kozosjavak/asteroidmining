package com.github.kozosjavak.asteroidmining;

public class AsteroidNotMinedException extends Exception {
    public AsteroidNotMinedException() {
        super("Asteroid hasn't been mined!");
    }
}
