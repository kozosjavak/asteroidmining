package com.github.kozosjavak.asteroidmining.core;

/**
 * Robot class
 */
public class Robot extends Spaceship {
    /**
     * Robot constructor
     *
     * @param asteroid Asterooid, where the robot will be placed
     */
    public Robot(Asteroid asteroid) {
        super(asteroid);
    }

    /**
     * Step, it drill till the asteroid is mineable, then fly to the next Asteroid
     */
    @Override
    public void step() throws Exception {
        if (getCurrentAsteroid().getSurfaceThickness() > 0) {
            getCurrentAsteroid().drill();
        } else {
            move(getCurrentAsteroid().getLocation().getRandomNeighbor());
        }
    }

    /**
     * To string where only the specified robot object given back in string
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Robot @" + Integer.toHexString(hashCode());
    }

    /**
     * To string where the structure of the robot class given back in string
     *
     * @param depth int, needed for the correct amount of /t before the data for correct write out
     * @param game  Game
     * @return String
     */
    @Override
    public String toString(int depth, Game game) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";
        return tab + "Robot {ID = " + game.getId(this) + "}";
    }

    /**
     * hit by explosion and fly to the next random location
     */
    @Override
    public void getHitByExplosion() throws NoNeighborException {
        move(getCurrentAsteroid().getLocation().getRandomNeighbor());
    }
}
