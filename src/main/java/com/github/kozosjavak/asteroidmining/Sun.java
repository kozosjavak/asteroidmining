package com.github.kozosjavak.asteroidmining;

/**
 * Nap osztály
 */
public class Sun extends Orb implements Steppable {

    /** Elsődleges szomszédok száma */
    protected int numberOfChildren;

    /**
     * Nap konstruktor
     * Beállítja az elsődleges szomszédok számát
     * @param numberOfChildren az elsődleges szomszédok száma
     */
    public Sun(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    /**
     * Napvihar átvészelése
     */
    @Override
    public void experienceSolarStrom() {
    }

    /**
     * Égitest típusának lekérdezése
     * @return az égitest típusa
     */
    @Override
    public String getType() {
        return "Sun";
    }

    /**
     * Lépés implementációja
     */
    @Override
    public void step() {

    }
}
