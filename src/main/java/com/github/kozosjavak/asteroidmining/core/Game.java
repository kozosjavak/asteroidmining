package com.github.kozosjavak.asteroidmining.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Játék osztály
 */
public class Game {
    private final double maxX;
    private final double maxY;
    private final double minX = 0;
    private final double minY = 0;
    private final Random random = new Random();
    private final List<Location> locationList = new ArrayList<>();

    ///////
    //Id implementation, not stationary
    //////
    private final List<Object> idList = new ArrayList<>();

    public void putInIdList(Object object) {
        idList.add(object);
        System.out.println("ID: " + getId(object));
    }

    public int getId(Object object) {
        if (idList.contains(object)) {
            return idList.indexOf(object);
        }
        return -1;
    }

    public void writeOutALlID() {
        for (Object object : idList) {
            System.out.println(getId(object));
        }
    }
    ///////
    /**
     * A játékban levő telepesek száma
     */
    private final List<Steppable> settlers = new ArrayList<>();
    /**
     * A játékban levő nap inicializálása
     */
    private Sun theSun;
    private boolean running = true;

    public Game(double maxX, double maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public List<Location> getLocationList() {
        return Collections.unmodifiableList(locationList);
    }

    public Location getLocation(int id) {
        if (id > 0 && id < locationList.size() - 1) {
            return locationList.get(id);
        }
        return null;
    }

    public void addLocation(Location newLocation) {
        locationList.add(newLocation);
    }

    public boolean checkIfLocationCollide(Location location) {
        for (Location nextLocation : getLocationList()) {
            if (nextLocation != location && location.coordinate.getDistance(nextLocation.getCoordinate()) < 1) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfSettlers() {
        return settlers.size();
    }

    public Sun getTheSun() {
        return theSun;
    }

    public void addASettlerInGame(Settler settler) {
        settlers.add(settler);
    }

    public void removeSettlerFromGame(Settler settler) {
        settlers.remove(settler);
    }


    /**
     * Játék indítása
     */
    public void startGame(double distanceOfNeighbors) throws Exception {
        //Generate world
        while (running) {
            for (Location nextStep : locationList) {
                nextStep.step(distanceOfNeighbors);
            }
        }
    }

    public void Win() {
        // System.out.println("Win, Congrat commrad!");
        theSun = null;
        System.gc();
    }

    Boolean randomGenerator(int percentage) {
        return random.nextInt(1000) % 100 < percentage;
    }

    /**
     * Játék állapotának ellenőrzése. Ha teljesül a játék végét jelentő feltétel akkor végetér a játék.
     */
    public void endGame() {
        running = false;
    }

}
