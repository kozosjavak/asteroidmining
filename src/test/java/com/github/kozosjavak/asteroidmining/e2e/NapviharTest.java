package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Location;
import com.github.kozosjavak.asteroidmining.core.Orb;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class NapviharTest {

    @Test

    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-napvihar.txt");
        Game game = E2eTools.getGame(inputStream);

        // Asteroid 1
        {
            Location location = game.getLocation(0);
            assertNotNull(location);
            Orb celestialBody = location.getCelestialBody();
            assertEquals(Asteroid.class, celestialBody.getClass());
            Asteroid asteroid = (Asteroid) celestialBody;
            // TODO
            assertEquals("There should be no residents left", 0, asteroid.getResidence().size());
            assertNotNull(location.getTeleport());
        }

        // Asteroid 2
        {
            Location location = game.getLocation(1);
            assertNotNull(location);
            Orb celestialBody = location.getCelestialBody();
            assertEquals(Asteroid.class, celestialBody.getClass());
            Asteroid asteroid = (Asteroid) celestialBody;
            assertEquals("There should be 3 residents left", 3, asteroid.getResidence().size());
            assertNull(location.getTeleport());
        }

        // Asteroid 3
        {
            Location location = game.getLocation(2);
            assertNotNull(location);
            Orb celestialBody = location.getCelestialBody();
            assertEquals(Asteroid.class, celestialBody.getClass());
            Asteroid asteroid = (Asteroid) celestialBody;
            assertEquals("There should be no residents left", 0, asteroid.getResidence().size());
            assertNotNull(location.getTeleport());
        }
    }
}
