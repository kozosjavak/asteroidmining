package com.github.kozosjavak.asteroidmining.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Játék osztály
 */
public class Game {


    private final List<Location> locationList = new ArrayList<>();
    /**
     * A játékban levő nap inicializálása
     */
    private Sun theSun;
    /**
     * A játékban levő telepesek száma
     */
    private int numberOfSettlers = 0;

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
        return numberOfSettlers;
    }

    public void setNumberOfSettlers(int numberOfSetlers) {
        numberOfSettlers = numberOfSetlers;
    }

    public Sun getTheSun() {
        return theSun;
    }

    public void addASettlerInNumberOfSettler() {
        numberOfSettlers++;
    }

    public void removeASettlerInNumberOfSettler() {
        numberOfSettlers--;
    }


    /**
     * Játék indítása
     */
    public void startGame() {
        //theSun = new Sun(new Location(), numberOfChildren);
    }

    public void Win() {
       // System.out.println("Win, Congrat commrad!");
        theSun = null;
        System.gc();
    }

    /**
     * Játék állapotának ellenőrzése. Ha teljesül a játék végét jelentő feltétel akkor végetér a játék.
     */
    public void endGame() {
        if (numberOfSettlers == 0) {
            System.out.println("Loose");
            theSun = null;
            System.gc();
        } else {
            System.out.println("Game hasn't ended yet.");
        }
    }

    public void start() {
        System.out.println("Game started");
    }
}
