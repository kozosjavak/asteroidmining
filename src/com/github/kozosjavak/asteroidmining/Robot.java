package com.github.kozosjavak.asteroidmining;

public class Robot extends Spaceship implements Steppable {
    public Robot(Asteroid asteroid) {
        super(asteroid);
    }


    @Override

    public void move(Asteroid asteroid) {
        Asteroid randomAsteroid = (Asteroid) asteroid.getRandomNeighbor();
        randomAsteroid.addSpaceShip(this);
        setCurrentAsteroid(randomAsteroid);

    }

    @Override
    public void experienceSolarStorm() {
    }

    @Override
    public void getHitByExplosion() {
    }

    @Override
    public void drill() {
    }

    @Override
    public String getType() {
        return "robot";
    }

    @Override
    public void step() {

    }
}
