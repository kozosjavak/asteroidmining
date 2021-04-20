package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Location;
import com.github.kozosjavak.asteroidmining.core.Orb;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Iron;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class NapkozelsegTest {

    @Test
    @Ignore
    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-napkozelseg_hatasa_nyersanyagokra.txt");
        Game game = E2eTools.getGame(inputStream);

        // Check if all settlers have deceased
        assertEquals("All settlers should be deceased", 0, game.getSettlers().size());

        // Asteroid 1
        {
            Location location = game.getLocation(0);
            assertNotNull(location);
            Orb celestialBody = location.getCelestialBody();
            assertEquals(Asteroid.class, celestialBody.getClass());
            Asteroid asteroid = (Asteroid) celestialBody;
            assertEquals(0, asteroid.getSurfaceThickness());
            assertNotNull("There should be material left", asteroid.getSubstance());
            assertEquals("There should be 1 coal left", Coal.class, asteroid.getSubstance().getClass());
            assertEquals("There should be no settlers", 0, asteroid.getResidence().size());
        }

        // Asteroid 2
        {
            Location location = game.getLocation(1);
            assertNotNull(location);
            Orb celestialBody = location.getCelestialBody();
            assertEquals(Asteroid.class, celestialBody.getClass());
            Asteroid asteroid = (Asteroid) celestialBody;
            assertEquals(0, asteroid.getSurfaceThickness());
            assertNotNull("There should be material left", asteroid.getSubstance());
            assertEquals("There should be 1 iron left", Iron.class, asteroid.getSubstance().getClass());
            assertEquals("There should be no settlers", 0, asteroid.getResidence().size());
        }

        // Asteroid 3
        {
            Location location = game.getLocation(2);
            assertNotNull(location);
            Orb celestialBody = location.getCelestialBody();
            assertEquals(Asteroid.class, celestialBody.getClass());
            Asteroid asteroid = (Asteroid) celestialBody;
            assertEquals(0, asteroid.getSurfaceThickness());
            assertNull("There should be no materials left", asteroid.getSubstance());
            assertEquals("There should be no settlers", 0, asteroid.getResidence().size());
        }

        // Asteroid 4
        {
            Location location = game.getLocation(3);
            assertNotNull(location);
            assertNull("Asteroid should explode", location.getCelestialBody());
        }

    }
}
