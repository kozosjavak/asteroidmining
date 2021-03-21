package com.github.kozosjavak.asteroidmining;

public class Sun extends Orb implements Steppable {
    protected int numberOfChildren;

    public Sun(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    @Override
    public void experienceSolarStrom() {
    }

    @Override
    public String getType() {
        return "Sun";
    }

    @Override
    public void step() {

    }
}
