package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

/**
 * Égitest osztály
 */
public class Orb {
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

    public void experienceExtremeHeat() throws NotEnoughMaterialException {
    }


}
