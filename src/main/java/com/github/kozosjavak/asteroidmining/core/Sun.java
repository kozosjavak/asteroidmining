package com.github.kozosjavak.asteroidmining.core;

import java.util.Random;

/**
 * Sun class
 */
public class Sun extends Orb {

    Random random;

    /**
     * Basic constructor
     *
     * @param location Location where will be placed
     */
    public Sun(Location location) {
        super(location);
        random = new Random();
    }

    /**
     * Moving in the new coordinate in the space
     *
     * @param newX double new X coordinate
     * @param newY double new Y coordinate
     * @throws CantMoveToTheSpecificLocationException if can't move the specific coordinate
     */
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
     * Calls experienceSolarStorm() on all it's neighbors
     */
    @Override
    public void experienceSolarStorm() {
        for (Location location : getLocation().getNeighbors()) {
            location.experienceSolarStorm();
        }
    }

    @Override
    public void experienceExtremeHeat() throws Exception {
        for (Location location : getLocation().getNeighbors()) {
            location.experienceExtremeHeat();
        }
    }

    /**
     * Implementation of the step(), randomly moving or generate solarstorm
     */
    @Override
    public void step() throws Exception {

        if (getLocation().game.randomGenerator(20)) {
            sunMoving(random.nextDouble() * getLocation().game.getMaxX(), random.nextDouble() * getLocation().game.getMaxY());
        }
        if (getLocation().game.randomGenerator(30)) {
            experienceSolarStorm();
        }

    }

    /**
     * Return the sun structure in string
     *
     * @param depth needed for the correct amount of /t before the data for correct write out
     * @param game  needed for give the ID of itself
     * @return String
     */
    @Override
    public String toString(int depth, Game game) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";

        return tab + "Sun {ID = " + game.getId(this) + "}\n";
    }
}
