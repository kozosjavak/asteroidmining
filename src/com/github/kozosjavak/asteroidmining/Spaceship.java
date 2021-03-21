package com.github.kozosjavak.asteroidmining;

public class Spaceship {
        private Asteroid currentAsteroid;

        public Spaceship(Asteroid asteroid) {
                asteroid.addSpaceShip(this);
                currentAsteroid = asteroid;
        }

        public void experienceSolarStorm() {
        }

        public void getHitByExplosion() {
        }

        public void die() {
        }

        /**
         * Moves a spaceship one asteroid to the other
         *
         * @param destination the new asteroid
         */
        public void move(Asteroid destination) {
                currentAsteroid.removeSpaceship(this);
                destination.addSpaceShip(this);
                currentAsteroid = destination;
        }

        /**
         * calls the current asteroid's drill method, to remove a layer of crust
         */
        public void drill() throws SurfaceThicknessIsZeroException {

                currentAsteroid.drill();

        }

        public String getType() {
                return "Spaceship";
        }

        public Asteroid getCurrentAsteroid() {
                return currentAsteroid;
        }

        public void setCurrentAsteroid(Asteroid newAsteroidLocation) {
                this.currentAsteroid = newAsteroidLocation;
        }
}
