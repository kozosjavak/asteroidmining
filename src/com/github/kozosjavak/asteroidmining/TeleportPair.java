package com.github.kozosjavak.asteroidmining;

public class TeleportPair {

    private Location location1 = null;
    private Location location2 = null;

    public void deployTeleport(Location location) {
        if (location1 == null) {
            location1 = location;
        } else {
            location2 = location;
            activateTeleport();
        }
    }

    public void activateTeleport() {
        location1.addNeighbor(location2);
        location2.addNeighbor(location1);
    }
}
