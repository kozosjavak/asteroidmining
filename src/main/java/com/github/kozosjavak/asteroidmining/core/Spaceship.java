package com.github.kozosjavak.asteroidmining.core;

/**
 * Spaceship class, super of Settler,Ufo,Robot
 */
public class Spaceship implements Explodeable {

    /**
     * Current asteroid
     */
    private Asteroid currentAsteroid;

    /**
     * Basic constructor
     *
     * @param asteroid Asteroid, where will be placed
     */
    public Spaceship(Asteroid asteroid) {
        asteroid.addSpaceShip(this);
        currentAsteroid = asteroid;
    }

    /**
     * ExperienceSolarStorm if the spaceship can't hide, dies
     */
    public void experienceSolarStorm() {
        if (getCurrentAsteroid().getSurfaceThickness() != 0) {
            die();
        }
    }

    /**
     * Experience extreme heat
     *
     * @throws Exception
     */
    public void experienceExtremeHeat() throws Exception {
    }


    /**
     * Spaceship dies and removed from current asteroid
     */
    public void die() {
        currentAsteroid.removeSpaceship(this);
        setCurrentAsteroid(null);
    }

    /**
     * Move to the given location, if the location is not Asteroid it won't move
     *
     * @param location Location
     */
    public void move(Location location) {
        if (location.getCelestialBody() == null) {
            System.out.println("There is no body to land on, just the waste empty void.");
        } else if (location.getCelestialBody().getClass() == Asteroid.class) {
            currentAsteroid.removeSpaceship(this);
            Asteroid destination = (Asteroid) location.getCelestialBody();
            destination.addSpaceShip(this);
            currentAsteroid = destination;
        } else if (location.getCelestialBody().getClass() == Sun.class) {
            System.out.println("The destination location is a sun");
        }
    }

    /**
     * Returns the current asteroid
     * @return Asteroid
     */
    public Asteroid getCurrentAsteroid() {
        return currentAsteroid;
    }

    /**
     * Set the current asteroid where the spaceship is
     *
     * @param newAsteroidLocation Asteroid, new asteroid
     */
    public void setCurrentAsteroid(Asteroid newAsteroidLocation) {
        this.currentAsteroid = newAsteroidLocation;
    }

    /**
     * Use the teleport on the current asteroid's location, if there is no teleport it won't move
     */
    public void teleport() {
        Teleport teleport = getCurrentAsteroid().getLocation().teleport;
        if (teleport != null && teleport.getPair() != null) {
            move(teleport.getPair().getLocation());
        } else {
            System.out.println("Teleport is not available");
        }
    }

    /**
     * If explode calls the current asteroid explode()
     */
    @Override
    public void explode() throws Exception {
        currentAsteroid.explode();
    }

    /**
     * If it hit by explosion, dies
     */
    public void getHitByExplosion() throws NoNeighborException {
        die();
    }

    /**
     * remove the substance from the current asteroid
     */
    @Override
    public void removeSubstance() {
        /**
         * HAVE TO BE EMPTY
         */
    }

    /**
     * Super of the toString
     *
     * @param depth needed for the correct amount of /t before the data for correct write out
     * @param game  needed for give the ID of itself
     * @return String
     */
    public String toString(int depth, Game game) {
        return null;
    }

    @Override
    public void step() throws Exception {
    }
}
