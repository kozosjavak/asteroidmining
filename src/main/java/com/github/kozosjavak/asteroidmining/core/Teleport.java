package com.github.kozosjavak.asteroidmining.core;

/**
 * Teleportpár osztály
 */
public class Teleport implements Steppable {
    private boolean solarized = false;

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
        if (getPair() != null) {
            getPair().location = null;
            getPair().pair = null;
        }
        this.location = null;
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
        location.setTeleport(this);
    }

    public void reDeployTeleport(Location location) {
        Location tempLocation = this.location;
        deployTeleport(location);
        tempLocation.setTeleport(null);
    }

    public void experienceSolarStorm() {
        solarized = true;
    }

    public void step() throws Exception {
        if (solarized) {
            reDeployTeleport(getLocation().getRandomNeighbor());
        }
    }

    public String toString(int depth, Game game) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";

        return tab + "Teleport {ID = " + game.getId(this) + ", PairID = " + game.getId(pair) + "}\n";
    }
}
