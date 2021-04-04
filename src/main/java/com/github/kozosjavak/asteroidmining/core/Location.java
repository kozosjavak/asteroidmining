package com.github.kozosjavak.asteroidmining.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Location osztály
 */
public class Location {

    final Coordinate coordinate;
    /**
     * Szomszédok listája
     */
    final List<Location> neighbors;
    Random random;
    Orb celestialBody;
    Teleport teleport;

    public Location(Double X, Double Y) {
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
    }

    public void fullClearByExplosion() {
        celestialBody = null;
        if (teleport != null) {
            teleport.getHitByExplosion();
        }
        System.gc();
    }

    /**
     * Véletlenszerűen választott szomszéd lekérése
     *
     * @return a véletlenszerűen választott szomszédot
     */
    public Location getRandomNeighbor() {
        return neighbors.get(random.nextInt(neighbors.size() - 1));
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


    public String toString() {
        return "Sun @" + Integer.toHexString(hashCode()) + "{" +
                (
                        "\n" + "neighbors=\n" + neighbors
                ).indent(4) +
                '}';
    }

}
