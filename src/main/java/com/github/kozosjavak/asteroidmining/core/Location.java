package com.github.kozosjavak.asteroidmining.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Location class, location is used to store celestial body, like asteroid, and teleports on a same location and it gives the coordinates for this location
 */
public class Location {
    /**
     * Game
     */
    final Game game;
    /**
     * Coordinate
     */
    final Coordinate coordinate;
    /**
     * List of the neighbor locations
     */
    final List<Location> neighbors;
    Random random;
    /**
     * Can be Asteroid, Sun
     */
    Orb celestialBody;
    /**
     * Teleport
     */
    Teleport teleport;

    /**
     * Basic constructor
     *
     * @param game Game
     * @param X    Double
     * @param Y    Double
     */
    public Location(Game game, Double X, Double Y) {
        this.game = game;
        neighbors = new ArrayList<>();
        random = new Random();
        coordinate = new Coordinate(X, Y);
    }

    /**
     * Gives back the coordinates
     *
     * @return Coordinate
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Gives back the celestial body can be Asteroid, Sun
     *
     * @return Orb/null
     */
    public Orb getCelestialBody() {
        return celestialBody;
    }

    /**
     * Set the celestial body to this location
     *
     * @param celestialBody Orb
     */
    public void setCelestialBody(Orb celestialBody) {
        this.celestialBody = celestialBody;
    }

    /**
     * Gives back the teleport
     *
     * @return Teleport/null
     */
    public Teleport getTeleport() {
        return teleport;
    }

    /**
     * Set the teleport if there is no current teleport on the location
     *
     * @param teleport Teleport
     */
    public void setTeleport(Teleport teleport) {
        this.teleport = teleport;
        if (teleport != null)
            getTeleport().setLocation(this);
    }

    /**
     * Calls the getHitByExplosion() on the celestial body and teleport on the location and clear them
     */
    public void fullClearByExplosion() {

        Asteroid asteroid = (Asteroid) celestialBody;


        celestialBody = null;
        if (teleport != null) {
            teleport.getHitByExplosion();
        }
        teleport = null;
        System.gc();
    }

    /**
     * Rewrite the neighborlist depends on the given distance, map the new neighbors
     *
     * @param distance double
     */
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
     * Return a randomly chosed neighbor location
     *
     * @return Location
     */
    public Location getRandomNeighbor() throws NoNeighborException {
        int randomNext;
        if (neighbors.size() == 0) {
            throw new NoNeighborException(this);
        }
        if (neighbors.size() == 1) {
            return neighbors.get(0);
        } else {
            randomNext = neighbors.size() - 1;
        }

        return neighbors.get(random.nextInt(randomNext));
    }

    /**
     * Gives back the list of the neighbors
     *
     * @return List<Location>
     */
    public List<Location> getNeighbors() {
        return neighbors;
    }

    /**
     * Add a neighbors in the list
     *
     * @param location new neighbor
     */
    public void addNeighbor(Location location) {
        neighbors.add(location);
    }

    /**
     * Removes the given location from the neighbors list
     *
     * @param location
     */
    public void removeNeighbor(Location location) {
        neighbors.remove(location);
    }

    /**
     * Calls the experienceSolarStorm() on the celestialbody and teleport
     */
    public void experienceSolarStorm() {
        if (getCelestialBody() != null) {
            getCelestialBody().experienceSolarStorm();
        }
        if (getTeleport() != null) {
            getTeleport().experienceSolarStorm();
        }
    }

    /**
     * Calls the experienceExtremeHeat() on the celestial body
     *
     * @throws Exception
     */
    public void experienceExtremeHeat() throws Exception {
        getCelestialBody().experienceExtremeHeat();
    }

    /**
     * Return the location structure in string
     *
     * @param depth int, needed for the correct amount of /t before the data for correct write out
     * @return String
     */
    public String toString(int depth) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";

        String out = "Location {\n";
        out += tab + "Neighbors = {";
        for (Location loc : neighbors) {
            out += game.getId(loc.getCelestialBody()) + ", ";
        }
        out += "},\n";
        out += tab + "Orb = " + (celestialBody == null ? "null" : celestialBody.toString(depth + 1, game));
        out += tab + "Teleport = " + (teleport == null ? "null\n" : teleport.toString(depth + 1, game));
        out += "},\n";
        return out;
    }

    /**
     * Gives back the celestial body
     *
     * @return Orb
     */
    public Orb getOrb() {
        return celestialBody;
    }

    /**
     * Calls the refreshNeighborsList() to repath the neighbors and calls the step() on the celestialbody and teleport
     *
     * @param distanceOfNeighbors double
     * @throws Exception
     */
    public void step(double distanceOfNeighbors) throws Exception {
        refreshNeighborsList(distanceOfNeighbors);
        getCelestialBody().step();
        getTeleport().step();
    }

    public Location getRandomNeighborWithNoTeleport() throws NoNeighborException {
        for (Location location : neighbors) {
            if (location.getTeleport() == null) {
                return location;
            }
        }
        throw new NoNeighborException(this);
    }
}
