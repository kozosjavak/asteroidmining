package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrbTest {

    // Init test locations
    private final Location testLocation1 = new Location(1.0, 3.0);
    private final Location testLocation2 = new Location(2.0, 5.0);

    @Test
    public void it_should_return_the_set_location_and_change_to_the_other() {
        Orb testOrb = new Orb(testLocation1);
        assertEquals(testLocation1, testOrb.getLocation());

        testOrb.setLocation(testLocation2);
        assertEquals(testLocation2, testOrb.getLocation());
    }

    @Test
    public void exprerience_solar_storm_test() {
        /**
         * Orb.experienceSolarStrom() is not implemented yet
         */
    }

    @Test
    public void exprerience_extreme_heat_test() throws NotEnoughMaterialException {
        /**
         * Orb.experienceExtremeHeat() is not implemented yet
         */
    }
}
