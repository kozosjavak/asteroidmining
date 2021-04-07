package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.types.Waterice;
import org.junit.Test;

public class WatericeExtremeHeatTest {

    @Test(expected = AsteroidIsNotMineable.class)
    public void waterice_should_sublimate() throws Exception {
        Location testLocation = new Location(new Game(100, 100), 2.2, 2.5);
        Material testMaterial = new Waterice();
        Asteroid testAsteroid = new Asteroid(testLocation, 0, true, testMaterial, 0);

        testAsteroid.experienceExtremeHeat();

        testAsteroid.mine();
    }

}
