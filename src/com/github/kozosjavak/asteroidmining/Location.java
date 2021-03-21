package com.github.kozosjavak.asteroidmining;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Location osztály */
public class Location {

    /** Szomszédok listája */
    List<Location> neighbors = new ArrayList<Location>();

    Random random = new Random();

    /**
     * Véletlenszerűen választott szomszéd lekérése
     * @return a véletlenszerűen választott szomszédot
     */
    public Location getRandomNeighbor() {
        return neighbors.get(random.nextInt(neighbors.size() - 1));
    }

    /**
     * Szomszédok listájának lekérdezése
     * @return szomszédok
     */
    public List<Location> getNeighbors() {
        return neighbors;
    }

    /**
     * Szomszéd hozzáadása
     * @param location a hozzáadandó szomszéd
     */
    public void addNeighbor(Location location) {
        neighbors.add(location);
    }

    /**
     * Szomszéd eltávolítása
     * @param location az eltávolítandó szomszéd
     */
    public void removeNeighbor(Location location) {
        neighbors.remove(location);
    }

    /**
     * A fastruktúrában alárendelt új szomszéd(ok) létrehozásakor a fa alárendelt részének a mélysége
     * @param depth a fa alárendelt részének a mélysége
     */
    public void addChildern(int depth) {
        //Underconstraction
    }

}
