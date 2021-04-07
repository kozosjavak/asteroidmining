package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.core.materials.types.Waterice;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WatericeExtremeHeatTest {

    @Test(expected =  AsteroidIsNotMineable.class)
    public void waterice_should_sublimate() throws NotEnoughMaterialException, InterruptedException, AsteroidIsNotMineable {
        Location testLocation = new Location(new Game(), 2.2, 2.5);
        Material testMaterial = new Waterice();
        Asteroid testAsteroid = new Asteroid(testLocation, 0, true, testMaterial, 0);

        testAsteroid.experienceExtremeHeat();

        testAsteroid.mine();
    }

}
