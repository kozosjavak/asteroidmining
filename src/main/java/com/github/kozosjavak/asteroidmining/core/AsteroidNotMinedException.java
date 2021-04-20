package com.github.kozosjavak.asteroidmining.core;

/**
 * Give you feedback if you want to call something which cant be performed if the asteroid not mined
 */
public class AsteroidNotMinedException extends Exception {
    public AsteroidNotMinedException() {
        super("Asteroid hasn't been mined!");
    }
}
