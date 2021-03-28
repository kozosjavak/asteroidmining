package com.github.kozosjavak.asteroidmining.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Location osztály
 */
public class Location {

    /**
     * Szomszédok listája
     */
    List<Location> neighbors;
    Random random;
    Orb celestialBody;
    Teleport teleport;

    public Location() {
        neighbors = new ArrayList<Location>();
        random = new Random();
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

    public String toStringOnlyName() {
        return "Location";
    }

}
