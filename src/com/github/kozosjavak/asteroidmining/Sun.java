package com.github.kozosjavak.asteroidmining;

public class Sun extends Orb implements Steppable {
    protected int numberOfChildren;

    public Sun(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    @Override
    public void ExperienceSolarStrom() {
    }

    @Override
    public String GetType() {
        return "Sun";
    }

    @Override
    public void step() {

    }
}
