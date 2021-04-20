package com.github.kozosjavak.asteroidmining.core;

/**
 * Exception, it gives you feedback if mine() can't be executed
 */
public class AsteroidIsNotMineable extends Exception {
    public AsteroidIsNotMineable() {
        super("Asteroid has no mineable drill site!");
    }
}
