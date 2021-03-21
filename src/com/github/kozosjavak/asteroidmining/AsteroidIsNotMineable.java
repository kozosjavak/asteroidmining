package com.github.kozosjavak.asteroidmining;

public class AsteroidIsNotMineable extends Exception {
    public AsteroidIsNotMineable() {
        super("Asteroid has no mineable drill site!");
    }
}
