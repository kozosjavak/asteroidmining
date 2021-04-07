package com.github.kozosjavak.asteroidmining.core;

/**
 * Robot osztály
 */
public class Robot extends Spaceship implements Steppable {
    /**
     * Robot konstruktor
     *
     * @param asteroid aszteroida, amire a robot kerül
     */
    public Robot(Asteroid asteroid) {
        super(asteroid);
    }


    /**
     * Napvihar elszenvedése
     */
    @Override
    public void experienceSolarStorm() {
    }


    /**
     * Lépés implementációja
     */
    @Override
    public void step() throws Exception {
        if (getCurrentAsteroid().getSurfaceThickness() > 0) {
            getCurrentAsteroid().drill();
        } else {
            move(getCurrentAsteroid().getLocation().getRandomNeighbor());
        }
    }

    @Override
    public String toString() {
        return "Robot @" + Integer.toHexString(hashCode());
    }

    @Override
    public void explode() throws Exception {
        move(getCurrentAsteroid().getLocation().getRandomNeighbor());
    }
}
