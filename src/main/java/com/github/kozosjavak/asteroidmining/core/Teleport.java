package com.github.kozosjavak.asteroidmining.core;

/**
 * Teleportpár osztály
 */
public class Teleport {

    /**
     * Teleport egyik vége
     */
    private Location location;
    private Teleport pair;

    public Teleport(Teleport pair) {
        location = null;
        this.pair = pair;
    }

    public Teleport() {
        location = null;
        this.pair = null;
    }

    public void getHitByExplosion() {
        getPair().location = null;
        this.location = null;
        getPair().pair = null;
        pair = null;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Teleport getPair() {
        return pair;
    }

    public void setPair(Teleport pair) {
        this.pair = pair;
    }

    /**
     * Teleportkapu társítása a megadott lokációhoz
     *
     * @param location lokáció, amihez társítani szeretnénk
     */
    public void deployTeleport(Location location) {
        this.location = location;
    }

}
