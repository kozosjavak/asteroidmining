package com.github.kozosjavak.asteroidmining.core;

/**
 * Égitest osztály
 */
public class Orb implements Steppable {
    private Location location;

    public Orb(Location location) {
        this.location = location;
        location.setCelestialBody(this);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Napvihar elszenvedése
     */
    public void experienceSolarStorm() {
    }

    public void experienceExtremeHeat() throws Exception {
    }


    @Override
    public void step() throws CantMoveToTheSpecificLocationException {
    }
}
