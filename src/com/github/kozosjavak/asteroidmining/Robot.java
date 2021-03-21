package com.github.kozosjavak.asteroidmining;

public class Robot extends Spaceship implements Steppable{
    public Robot(Asteroid asteroid) {
        super(asteroid);
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
