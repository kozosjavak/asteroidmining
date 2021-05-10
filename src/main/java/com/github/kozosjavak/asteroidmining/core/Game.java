package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.core.materials.types.Waterice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The game class everything starts here and can be manipulated from here
 */
public class Game {
    private final double maxX;
    private final double maxY;
    private final double minX = 0;
    private final double minY = 0;
    private final Random random = new Random();
    private final List<Location> locationList = new ArrayList<>();

    /**
     * List of the objects, the id is given by the object position on the list
     */
    private final List<Object> idList = new ArrayList<>();
    /**
     * Settlers stored who is alive and in the game currently
     */
    private final List<Steppable> settlers = new ArrayList<>();
    /**
     * Initializing the sun in the game
     */
    private Sun sun;
    private boolean running = true;
    private boolean isWon = false;

    /**
     * Constructor, it needs 2 coordinates to determine the maximum size of the map
     *
     * @param maxX
     * @param maxY
     */
    public Game(double maxX, double maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isWon() {
        return isWon;
    }

    public List<Steppable> getSettlers() {
        return settlers;
    }

    /**
     * Where you can add an object to the list and prints out the freshly given ID
     *
     * @param object object
     */
    public void putInIdList(Object object) {
        idList.add(object);
        System.out.println("ID: " + getId(object));
    }

    /**
     * Gives back the object ,which can be casted to the correct one, from the given id
     *
     * @param id Int id
     * @return Object/null
     */
    public Object getObjectFromID(int id) {
        if (id <= idList.size() - 1 && id >= 0)
            return idList.get(id);
        return null;
    }

    /**
     * It gives back the position of the specific object from the list
     *
     * @param object Give object
     * @return Int id
     */
    public int getId(Object object) {
        if (idList.contains(object)) {
            return idList.indexOf(object);
        }
        return -1;
    }

    /**
     * Print out all the object stored in the ID list
     */
    public void writeOutALlID() {
        for (Object object : idList) {
            System.out.println(getId(object));
        }
    }

    /**
     * Gives back the maximum X coordinate
     *
     * @return double maxX
     */
    public double getMaxX() {
        return maxX;
    }

    /**
     * Gives back the maximum Y coordinate
     *
     * @return double maxY
     */
    public double getMaxY() {
        return maxY;
    }

    /**
     * Gives back an unmodifiableList of the stored locations
     *
     * @return
     */
    public List<Location> getLocationList() {
        return Collections.unmodifiableList(locationList);
    }

    /**
     * Gives back a location from the location id
     *
     * @param id int ID
     * @return Location location
     */
    public Location getLocation(int id) {
        if (id >= 0 && id <= locationList.size() - 1) {
            return locationList.get(id);
        }
        return null;
    }

    /**
     * Add new location to the location list
     *
     * @param newLocation Location
     */
    public void addLocation(Location newLocation) {
        locationList.add(newLocation);
    }

    public boolean checkIfLocationCollide(Location location) {
        for (Location nextLocation : getLocationList()) {
            if (nextLocation != location && location.coordinate.getDistance(nextLocation.getCoordinate()) < 40) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gives back the number of settlers in the game, which is alive
     *
     * @return int
     */
    @Deprecated
    public int getNumberOfSettlers() {
        return settlers.size();
    }

    /**
     * Gives back the sun
     *
     * @return Sun
     */
    public Sun getSun() {
        return sun;
    }

    public void setSun(Sun sun) {
        this.sun = sun;
    }

    /**
     * Insert a settler in the settlers list
     *
     * @param settler Settler
     */
    @Deprecated
    public void addASettlerInGame(Settler settler) {
        settlers.add(settler);
    }

    /**
     * Removes a settler from the settlers list
     *
     * @param settler
     */
    public void removeSettlerFromGame(Settler settler) {
        settlers.remove(settler);
        if (settlers.size() == 0) {
            endGame();
        }
    }


    /**
     * Starts the game, generate the world
     */

    public void startGame(int numberOfAsteroids, int maxCrustThickness, double distanceOfNeighbors, int numberOfSettlers, int numberOfUfos) throws Exception {

        generateWorld(numberOfAsteroids, maxCrustThickness, numberOfSettlers, numberOfUfos, distanceOfNeighbors);
        //teszt
        // Robot robot = new Robot((Asteroid) getLocationList().get(3).getCelestialBody());
        new Thread(() -> {
            while (running) {
                Settler selectedSettler;
                List<Steppable> settlerListOfTheNewThread = new ArrayList<>(getSettlers());

                for (int i = 0; i < settlerListOfTheNewThread.size(); i++) {
                    selectedSettler = (Settler) settlerListOfTheNewThread.get(i);
                    selectedSettler.step();
                    while (selectedSettler.isSelected()) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Settler Done");
                }
                System.out.println("Round was done!");
                for (Location nextStep : locationList) {
                    try {
                        nextStep.step(distanceOfNeighbors);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * Win the game
     */
    public void Win() {
        sun = null;
        isWon = true;
        System.gc();
    }

    /**
     * Gives you back random boolean based on percentage given
     *
     * @param percentage Int range
     * @return boolean
     */
    Boolean randomGenerator(int percentage) {
        return random.nextInt(1000) % 100 < percentage;
    }

    private Material randomMaterial() {
        Material material;
        int rand = random.nextInt(4);
        if (rand == 0) {
            material = new Uranium();
        } else if (rand == 1) {
            material = new Coal();
        } else if (rand == 2) {
            material = new Iron();
        } else {
            material = new Waterice();
        }
        return material;
    }

    private void generateWorld(int numberOfAsteroid, int maximumCrustThickness, int numberOfSettlers, int numberOfUfos, double neighborDistance) throws Exception {
        if (numberOfAsteroid > 0) {
            Location sunLocation = new Location(this, maxX / 2, maxY / 2);
            double randX, randY;

            sun = new Sun(sunLocation);
            locationList.add(sunLocation);

            for (int i = 0; i < numberOfAsteroid; i++) {
                randX = Math.sqrt(random.nextDouble());
                randY = Math.sqrt(random.nextDouble());

                Location newLocation = new Location(this, randX * maxX, randY * maxY);
                while (checkIfLocationCollide(newLocation)) {
                    randX = Math.sqrt(random.nextDouble());
                    randY = Math.sqrt(random.nextDouble());
                    newLocation.getCoordinate().updateCoordinates(randX * maxX, randY * maxY);
                }
                Asteroid newAsteroid = new Asteroid(newLocation, 1 + random.nextInt(1 + random.nextInt(maximumCrustThickness - 1)), randomMaterial());
                locationList.add(newLocation);
            }
            for (int i = 0; i < numberOfSettlers; i++) {
                Location location = locationList.get(random.nextInt(locationList.size() - 1));
                while (location.getCelestialBody().getClass() != Asteroid.class) {
                    location = locationList.get(random.nextInt(locationList.size() - 1));
                }
                Asteroid asteroid = (Asteroid) location.getCelestialBody();
                Settler settler = new Settler(asteroid);
            }
            for (int i = 0; i < numberOfUfos; i++) {
                Location location = locationList.get(random.nextInt(locationList.size() - 1));
                while (location.getCelestialBody().getClass() != Asteroid.class) {
                    location = locationList.get(random.nextInt(locationList.size() - 1));
                }
                Asteroid asteroid = (Asteroid) location.getCelestialBody();
                Ufo settler = new Ufo(asteroid);
            }
            for (Location location : getLocationList()) {
                location.refreshNeighborsList(neighborDistance);
            }
        }
    }

    /**
     * End game
     */
    public void endGame() {
        running = false;
    }

    /**
     * Write out all of the objects toString()
     *
     * @param depth needed for the correct amount of /t before the data for correct write out
     * @return String
     */
    public String toString(int depth) {
        String out = "";
        for (Object obj : idList) {
            if (obj != null && obj.getClass().getSuperclass() == Orb.class) {
                Orb orb = (Orb) obj;
                out += orb.getLocation().toString(depth + 1);
            }
        }
        return out;
    }
}
