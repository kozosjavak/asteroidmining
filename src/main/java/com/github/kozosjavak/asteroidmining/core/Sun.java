package com.github.kozosjavak.asteroidmining.core;

import java.util.Random;

/**
 * Sun class
 */
public class Sun extends Orb {

    Random random;

    Boolean isSolarStorm = false;

    public Boolean isSolarStorm() {
        return isSolarStorm;
    }

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
    public void sunMoving(double newX, double newY, int counter) throws CantMoveToTheSpecificLocationException {
        //csunya javitasra szorul
        double x = getLocation().getCoordinate().getX();
        double y = getLocation().getCoordinate().getY();
        if (x + newX < getLocation().game.getMaxX() && y + newY < getLocation().game.getMaxY() && getLocation().game.randomGenerator(50)) {
            getLocation().getCoordinate().updateCoordinates(x + newX, y + newY);
            // System.out.println("Sun: Elso");
        } else if (x - newX > 0 && y + newY < getLocation().game.getMaxY() && getLocation().game.randomGenerator(50)) {
            getLocation().getCoordinate().updateCoordinates(x - newX, y + newY);
            //System.out.println("Sun: masodik");
        } else if (x + newX < getLocation().game.getMaxX() && y - newY > 0 && getLocation().game.randomGenerator(50)) {
            getLocation().getCoordinate().updateCoordinates(x + newX, y - newY);
            // System.out.println("Sun: harmadik");
        } else if (x - newX > 0 && y - newY > 0 && getLocation().game.randomGenerator(50)) {
            getLocation().getCoordinate().updateCoordinates(x - newX, y - newY);
            // System.out.println("Sun: negyedik");
        }
        if (getLocation().game.checkIfLocationCollide(getLocation()) && counter > 0) {
            getLocation().getCoordinate().updateCoordinates(x, y);
            sunMoving(random.nextDouble() * getLocation().game.getMaxX() * 0.2, random.nextDouble() * getLocation().game.getMaxY() * 0.2, --counter);
        } else if (getLocation().game.checkIfLocationCollide(getLocation()) && counter == 0) {
            throw new CantMoveToTheSpecificLocationException(new Coordinate(newX, newY));
        } else {
            //System.out.println("Hupsz(sun)");
            return;
        }
    }

    /**
     * Calls experienceSolarStorm() on all it's neighbors
     */
    @Override
    public void experienceSolarStorm() {
        //Solar storm radius!! refresh the sun neighbors list
        getLocation().refreshNeighborsList(200);
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
            try {
                sunMoving(random.nextDouble() * getLocation().game.getMaxX() * 0.2, random.nextDouble() * getLocation().game.getMaxY() * 0.2, 20);
            } catch (Exception e) {
                if (e.getClass() == CantMoveToTheSpecificLocationException.class) {
                    System.out.println("Sun couldn't move!");
                }
            }

        }
        if (getLocation().game.randomGenerator(30)) {
            isSolarStorm = true;
            experienceSolarStorm();
        } else {
            isSolarStorm = false;
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

        return "Sun {ID = " + game.getId(this) + "},\n";
    }
}
