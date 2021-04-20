package com.github.kozosjavak.asteroidmining.core;

/**
 * Gives feedback if there is no neighbor added on the location
 */
public class NoNeighborException extends Exception {
    public NoNeighborException(Location location) {
        super("No neighbor from this Location" + location.toString());
    }
}
