package com.github.kozosjavak.asteroidmining.core;

/**
 * Give you feedback if the location ,you want to move, has no asteroid on it
 */
public class CantMoveToTheSpecificLocationException extends Exception {
    public CantMoveToTheSpecificLocationException(Coordinate coordinate) {
        super("Location would collide on the following coordinate= X= " + coordinate.getX() + ", Y= " + coordinate.getY());
    }
}