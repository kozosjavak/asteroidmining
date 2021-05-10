package com.github.kozosjavak.asteroidmining.core;

public class AsteroidAlreadyMinedException extends Exception {
    public AsteroidAlreadyMinedException() {
        super("Asteroid is already mined!");
    }
}
