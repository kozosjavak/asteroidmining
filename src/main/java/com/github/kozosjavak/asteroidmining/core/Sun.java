package com.github.kozosjavak.asteroidmining.core;

import java.util.Random;

/**
 * Nap osztály
 */
public class Sun extends Orb {

    Random random;

    public Sun(Location location) {
        super(location);
        random = new Random();
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

    public void generateDirectSolarStorm(){
        experienceSolarStorm();
    }
    /**
     * Lépés implementációja
     */
    @Override
    public void step() throws CantMoveToTheSpecificLocationException {
        if (getLocation().game.randomGenerator(20)) {
            sunMoving(random.nextDouble() * getLocation().game.getMaxX(), random.nextDouble() * getLocation().game.getMaxY());
        }
        if (getLocation().game.randomGenerator(30)) {
            experienceSolarStorm();
        }

    }
}
