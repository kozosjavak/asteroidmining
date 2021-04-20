package com.github.kozosjavak.asteroidmining.core;

/**
 * Basic role of the position determine of the world of space, given two double param
 */
public class Coordinate {
    private double x;
    private double y;

    /**
     * Basic constructor of the coordinate
     *
     * @param x double X coordinate
     * @param y double Y Coordinate
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gives back the x coordinate
     *
     * @return double X
     */
    public double getX() {
        return x;
    }

    /**
     * Gives back the y coordinate
     *
     * @return double Y
     */
    public double getY() {
        return y;
    }

    /**
     * Gives back the distance between this coordinate and the given coordinate
     *
     * @param coor Coordinate: the other coordinate which you want to know the distance from this coordinate
     * @return double distance
     */
    public double getDistance(Coordinate coor) {
        return Math.sqrt((this.x - coor.x) * (this.x - coor.x) + (this.y - coor.y) * (this.y - coor.y));
    }

    /**
     * Give new coordinate datas, like if you want to give new position for something which implements coordinates
     *
     * @param x double X coordinate
     * @param y double Y coordinate
     */
    public void updateCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
