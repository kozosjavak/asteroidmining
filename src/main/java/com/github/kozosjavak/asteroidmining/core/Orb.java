package com.github.kozosjavak.asteroidmining.core;

/**
 * Super class for the Sun and Asteroid
 */
public class Orb implements Steppable {
    private Location location;

    /**
     * Basic constructor
     *
     * @param location
     */
    public Orb(Location location) {
        this.location = location;
        location.setCelestialBody(this);
    }

    /**
     * Give the location back
     *
     * @return Location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the location
     *
     * @param location Location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Experience solar storm
     */
    public void experienceSolarStorm() {
    }

    /**
     * Experience extreme heat
     *
     * @throws Exception
     */
    public void experienceExtremeHeat() throws Exception {
    }

    /**
     * Step
     *
     * @throws CantMoveToTheSpecificLocationException
     */
    @Override
    public void step() throws Exception {
    }

    /**
     * to string
     *
     * @param depth int, needed for the correct amount of /t before the data for correct write out
     * @param game  Game
     * @return String
     */
    public String toString(int depth, Game game) {
        return null;
    }
}
