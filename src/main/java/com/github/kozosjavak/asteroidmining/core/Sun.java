package com.github.kozosjavak.asteroidmining.core;

/**
 * Nap osztály
 */
public class Sun extends Orb implements Steppable {

    public Sun(Location location) {
        super(location);
    }

    public void sunMoving(double newX, double newY) throws CantMoveToTheSpecificLocationException {
        double x = getLocation().getCoordinate().getX();
        double y = getLocation().getCoordinate().getY();
        getLocation().getCoordinate().updateCoordinates(newX, newY);
        if (getLocation().game.checkIfLocationCollide(getLocation())) {
            getLocation().getCoordinate().updateCoordinates(x, y);
            throw new CantMoveToTheSpecificLocationException(new Coordinate(newX, newY));
        }
    }

    /**
     * Napvihar átvészelése
     */
    @Override
    public void experienceSolarStorm() {
        for (Location location : getLocation().getNeighbors()) {
            location.experienceSolarStorm();
        }
    }


    /**
     * Lépés implementációja
     */
    @Override
    public void step() {


    }
}
