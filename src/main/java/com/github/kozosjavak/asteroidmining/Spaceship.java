package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.materials.NotEnoughMaterialException;

/**
 * Űrhajó osztály
 */
public class Spaceship {

        /**
         * Aktuális aszteroida, melyen az űrhajó tartózkodik
         */
        private Asteroid currentAsteroid;

        /**
         * Spaceship konstruktor
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

        /**
         * Robbanás elszenvedése
         */
        public void getHitByExplosion() {
        }

        /**
         * Megsemmisülés
         */
        public void die() {
        }

        /**
         * Űrhajó mozgatása egy másik aszteroidára
         * @param destination aszteroida, amelyre akarjuk mozgatni az űrhajót
         */
        public void move(Asteroid destination) {
                currentAsteroid.removeSpaceship(this);
                destination.addSpaceShip(this);
                currentAsteroid = destination;
        }

        /**
         * Fúrás
         * Az aktuális aszteroidán (amelyen tartózkodik) próbálja csökkenteni a köpenyvastagságot
         */
        public void drill() throws SurfaceThicknessIsZeroException, NotEnoughMaterialException {

                currentAsteroid.drill();
        }

        /**
         * Űrhajó típusának lekérdezése
         * @return az űrhajó típusa
         */
        public String getType() {
                return "Spaceship";
        }

        /**
         * Visszaadja az aszteroidát, amelyen tartózkodik az űrhajó
         * @return az aszteroida, amelyen tartózkodik az űrhajó
         */
        public Asteroid getCurrentAsteroid() {
                return currentAsteroid;
        }

        /**
         * Beállítja, hogy a telepes melyik aszteroidán gondolja magát
         * @param newAsteroidLocation az új aszteroida, melyen szeretnénk, hogy a telepes legyen
         */
        public void setCurrentAsteroid(Asteroid newAsteroidLocation) {
                this.currentAsteroid = newAsteroidLocation;
        }
}
