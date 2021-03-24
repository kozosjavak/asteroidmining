package com.github.kozosjavak.asteroidmining;

/**
 * Teleportpár osztály
 */
public class TeleportPair {

    /**
     * Teleport egyik vége
     */
    private Location location1;

    /**
     * Teleport másik vége
     */
    private Location location2;

    public TeleportPair() {
        location1 = null;
        location2 = null;
    }

    /**
     * Teleportkapu társítása a megadott lokációhoz
     *
     * @param location lokáció, amihez társítani szeretnénk
     */
    public void deployTeleport(Location location) {
        if (location1 == null) {
            location1 = location;
        } else {
            location2 = location;
            activateTeleport();
        }
    }

    /**
     * Teleportkapu aktiválása
     */
    public void activateTeleport() {
        location1.addNeighbor(location2);
        location2.addNeighbor(location1);
    }

    @Override
    public String toString() {
        return "TeleportPair{" +

                "\nlocation1=" + location1.toStringOnlyName() +
                "\nlocation2=" + location2.toStringOnlyName()
                ;
    }
}
