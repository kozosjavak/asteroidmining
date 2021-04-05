package com.github.kozosjavak.asteroidmining.core;

public class CantMoveToTheSpecificLocationException extends Exception {
    public CantMoveToTheSpecificLocationException(Coordinate coordinate) {
        super("Location would collide on the following coordinate= X= " + coordinate.getX() + ", Y= " + coordinate.getY());
    }
}