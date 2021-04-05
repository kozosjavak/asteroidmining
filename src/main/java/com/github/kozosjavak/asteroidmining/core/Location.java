package com.github.kozosjavak.asteroidmining.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Location osztály
 */
public class Location {
    final Game game;
    final Coordinate coordinate;
    /**
     * Szomszédok listája
     */
    final List<Location> neighbors;
    Random random;
    Orb celestialBody;
    Teleport teleport;

    public Location(Game game, Double X, Double Y) {
        this.game = game;
        neighbors = new ArrayList<Location>();
        random = new Random();
        coordinate = new Coordinate(X, Y);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Orb getCelestialBody() {
        return celestialBody;
    }

    public void setCelestialBody(Orb celestialBody) {
        this.celestialBody = celestialBody;
    }

    public Teleport getTeleport() {
        return teleport;
    }

    public void setTeleport(Teleport teleport) {
        this.teleport = teleport;
        getTeleport().setLocation(this);
    }

    public void fullClearByExplosion() {
        celestialBody = null;
        if (teleport != null) {
            teleport.getHitByExplosion();
        }
        System.gc();
    }


    public void refreshNeighborsList(double distance) {
        if (distance > 1) {
            neighbors.clear();
            for (Location newNeighbor : game.getLocationList()) {
                if (newNeighbor.getCoordinate().getDistance(getCoordinate()) <= distance && newNeighbor != this) {
                    addNeighbor(newNeighbor);
                }
            }
        }
    }

    /**
     * Véletlenszerűen választott szomszéd lekérése
     *
     * @return a véletlenszerűen választott szomszédot
     */
    public Location getRandomNeighbor() {
        int randomNext;
        if (neighbors.size() == 1) {
            randomNext = 1;
        } else {
            randomNext = neighbors.size() - 1;
        }

        return neighbors.get(random.nextInt(randomNext));
    }

    /**
     * Szomszédok listájának lekérdezése
     *
     * @return szomszédok
     */
    public List<Location> getNeighbors() {
        return neighbors;
    }

    /**
     * Szomszéd hozzáadása
     *
     * @param location a hozzáadandó szomszéd
     */
    public void addNeighbor(Location location) {
        neighbors.add(location);
    }

    /**
     * Szomszéd eltávolítása
     *
     * @param location az eltávolítandó szomszéd
     */
    public void removeNeighbor(Location location) {
        neighbors.remove(location);
    }

    public void experienceSolarStorm() {
        getCelestialBody().experienceSolarStorm();
        //getTeleport().experienceSolarStorm();
    }

    public String toString() {
        return "Sun @" + Integer.toHexString(hashCode()) + "{" +
                (
                        "\n" + "neighbors=\n" + neighbors
                ).indent(4) +
                '}';
    }

}
