package com.github.kozosjavak.asteroidmining.core;

/**
 * Nap osztály
 */
public class Sun extends Orb implements Steppable {

    /**
     * Elsődleges szomszédok száma
     */
    protected int numberOfChildren;

    /**
     * Nap konstruktor
     * Beállítja az elsődleges szomszédok számát
     *
     * @param numberOfChildren az elsődleges szomszédok száma
     */
    public Sun(Location location, int numberOfChildren) {
        super(location);
        this.numberOfChildren = numberOfChildren;
    }

    public void getLoco() {
        //a nap megorul;
        //random hogy most megorule
        //ha megorul helyet valtoztat
    }

    /**
     * Napvihar átvészelése
     */
    @Override
    public void experienceSolarStrom() {
    }


    /**
     * Lépés implementációja
     */
    @Override
    public void step() {
        getLoco();

    }
}
