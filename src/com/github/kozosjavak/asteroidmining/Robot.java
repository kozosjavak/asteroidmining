package com.github.kozosjavak.asteroidmining;
/**
 * Robot osztály
 */
public class Robot extends Spaceship implements Steppable {
    /**
     * Robot konstruktor
     * @param asteroid aszteroida, amire a robot kerül
     */
    public Robot(Asteroid asteroid) {
        super(asteroid);
    }


    @Override

    public void move(Asteroid asteroid) {
        Asteroid randomAsteroid = (Asteroid) asteroid.getRandomNeighbor();
        randomAsteroid.addSpaceShip(this);
        setCurrentAsteroid(randomAsteroid);

    }
    /**
     * Napvihar elszenvedése
     */
    @Override
    public void experienceSolarStorm() {
    }

    /**
     * Robbanás elszenvedése
     */
    @Override
    public void getHitByExplosion() {
    }

    /**
     * Aszteroida fúrása
     */
    @Override
    public void drill() {
    }

    /**
     * Űrhajó típusának lekérdezése
     * @return az űrhajó típusa
     */
    @Override
    public String getType() {
        return "robot";
    }

    /**
     * Lépés implementációja
     */
    @Override
    public void step() {

    }
}
