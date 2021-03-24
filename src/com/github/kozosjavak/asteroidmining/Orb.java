package com.github.kozosjavak.asteroidmining;

/**
 * Égitest osztály
 */
public class Orb extends Location {
    public Orb() {
        super();
    }

    /**
     * Napvihar elszenvedése
     */
    public void experienceSolarStrom() {
    }

    /**
     * Égitest típusának lekérdezése
     *
     * @return az égitest típusa
     */
    public String getType() {
        return "Orb";
    }

    @Override
    public String toStringOnlyName() {
        return "Orb";
    }

}
