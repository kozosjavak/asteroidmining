package com.github.kozosjavak.asteroidmining.core;

public class Coordinate {
    private double x;
    private double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance(Coordinate coor) {
        return Math.sqrt((this.x - coor.x) * (this.x - coor.x) + (this.y - coor.y) * (this.y - coor.y));
    }

    public void updateCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
