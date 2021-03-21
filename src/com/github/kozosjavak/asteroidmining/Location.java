package com.github.kozosjavak.asteroidmining;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Location {
    List<Location> neighbors = new ArrayList<Location>();
    Random random = new Random();

    public Location getRandomNeighbor() {
        return neighbors.get(random.nextInt(neighbors.size() - 1));
    }

    public List<Location> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Location location) {
        neighbors.add(location);
    }

    public void removeNeighbor(Location location) {
        neighbors.remove(location);
    }

    public void addChildern(int depth) {
        //Underconstraction
    }

}
