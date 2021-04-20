package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.*;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class NyersanyagVisszahelyezesTest {

    @Test
    @Ignore
    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-nyersanyag_visszahelyezese.txt");
        Game game = E2eTools.getGame(inputStream);

        // Settler
        assertEquals(1, game.getSettlers().size());
        final Settler settler = (Settler) game.getSettlers().iterator().next();
        assertEquals("Settler should have 1 material", 1, settler.getInventory().getSize());
        assertEquals("Settler should have 1 uranium", Uranium.class, settler.getInventory().getList().iterator().next().getClass());


        // Asteroid 1
        {
            Location location = game.getLocation(0);
            assertNotNull(location);
            Orb celestialBody = location.getCelestialBody();
            assertEquals(Asteroid.class, celestialBody.getClass());
            Asteroid asteroid = (Asteroid) celestialBody;
            assertEquals(0, asteroid.getSurfaceThickness());
            assertNull("There should be material left", asteroid.getSubstance());
            assertEquals("There should be settlers", 1, asteroid.getResidence().size());
            assertEquals("Settler should be on this asteroid", settler, asteroid.getResidence().iterator().next());
        }
    }
}
