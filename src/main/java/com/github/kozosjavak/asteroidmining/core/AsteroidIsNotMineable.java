package com.github.kozosjavak.asteroidmining.core;

public class AsteroidIsNotMineable extends Exception {
    public AsteroidIsNotMineable() {
        super("Asteroid has no mineable drill site!");
    }
}
