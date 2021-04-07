package com.github.kozosjavak.asteroidmining.core;

public class NoNeighborException extends Exception {
    public NoNeighborException(Location location) {
        super("No neighbor from this Location" + location.toString());
    }
}
