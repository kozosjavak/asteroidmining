package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;

/**
 * Űrhajó osztály
 */
public class Spaceship implements Explodeable {

        /**
         * Aktuális aszteroida, melyen az űrhajó tartózkodik
         */
        private Asteroid currentAsteroid;

        /**
         * Spaceship konstruktor
         *
         * @param asteroid aszteroida, melyre a telepes kerül
         */
        public Spaceship(Asteroid asteroid) {
                asteroid.addSpaceShip(this);
                currentAsteroid = asteroid;
        }

        /**
         * Napvihar elszenvedése
         */
        public void experienceSolarStorm() {
        }

        public void experienceExtremeHeat() throws NotEnoughMaterialException {
        }


        /**
         * Megsemmisülés
         */
        public void die() {
                getCurrentAsteroid().removeSpaceship(this);
        }


        public void move(Location location) {
                if (location.getCelestialBody().getClass() == Asteroid.class) {
                        currentAsteroid.removeSpaceship(this);
                        Asteroid destination = (Asteroid) location.getCelestialBody();
                        destination.addSpaceShip(this);
                        currentAsteroid = destination;
                } else if (location.getCelestialBody().getClass() == Sun.class) {
                        System.out.println("The destination location is a sun");
                } else if (location.getCelestialBody().getClass() == null) {
                        System.out.println("There is no body to land on, just the waste empty void.");
                }
        }

        /**
         * Visszaadja az aszteroidát, amelyen tartózkodik az űrhajó
         *
         * @return az aszteroida, amelyen tartózkodik az űrhajó
         */
        public Asteroid getCurrentAsteroid() {
                return currentAsteroid;
        }

        public void Teleport() {
                Teleport teleport = getCurrentAsteroid().getLocation().teleport;
                if (teleport != null && teleport.getPair() != null) {
                        move(teleport.getPair().getLocation());
                } else {
                        System.out.println("Teleport is not available");
                }
        }


        /**
         * Beállítja, hogy a telepes melyik aszteroidán gondolja magát
         *
         * @param newAsteroidLocation az új aszteroida, melyen szeretnénk, hogy a telepes legyen
         */
        public void setCurrentAsteroid(Asteroid newAsteroidLocation) {
                this.currentAsteroid = newAsteroidLocation;
        }

        @Override
        public void explode() {

        }
}
