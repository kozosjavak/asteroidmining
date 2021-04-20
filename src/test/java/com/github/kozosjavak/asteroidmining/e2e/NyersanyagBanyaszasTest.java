package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.*;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Iron;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class NyersanyagBanyaszasTest {

    @Test
    @Ignore
    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-nyersanyag_banyaszasa.txt");
        Game game = E2eTools.getGame(inputStream);

        // Settler
        assertEquals(1, game.getSettlers().size());
        final Settler settler = (Settler) game.getSettlers().iterator().next();
        assertEquals("Settler should have 10 materials", 10, settler.getInventory().getSize());
        assertEquals("Settler should have 10 coal", 10, settler.getInventory().getList().stream()
                .filter(material -> Coal.class.equals(material.getClass()))
                .count());


        // Asteroid 1
        {
            Location location = game.getLocation(0);
            assertNotNull(location);
            Orb celestialBody = location.getCelestialBody();
            assertEquals(Asteroid.class, celestialBody.getClass());
            Asteroid asteroid = (Asteroid) celestialBody;
            assertEquals(0, asteroid.getSurfaceThickness());
            assertNull("There should be material left", asteroid.getSubstance());
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
            assertEquals("There should be settlers", 1, asteroid.getResidence().size());
            assertEquals("Settler should be on this asteroid", settler, asteroid.getResidence().iterator().next());
        }
    }
}
