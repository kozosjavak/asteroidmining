package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.*;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class TeleportEpitesTest {

    @Test
    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-teleport_epitese.txt");
        Game game = E2eTools.getGame(inputStream);

        // Check settler
        assertEquals(1, game.getSettlers().size());
        Settler settler = (Settler) game.getSettlers().iterator().next();
        assertEquals("Settler should have no materials", 0, settler.getInventory().getSize());
        Asteroid settlerCurrentAsteroid = settler.getCurrentAsteroid();

        // Check asteroid
        Location location = game.getLocation(0);
        assertNotNull(location);
        Orb celestialBody = location.getCelestialBody();
        assertEquals(Asteroid.class, celestialBody.getClass());
        Asteroid asteroid = (Asteroid) celestialBody;
        assertEquals(1, asteroid.getSurfaceThickness());
        assertEquals("There should be no materials left", 0, asteroid.getMaterials().size());

        // Check teleports
        assertNotNull(settler.getTeleportInventory()[0]);
        assertNotNull(settler.getTeleportInventory()[1]);
        assertNull(settler.getTeleportInventory()[2]);

        // Check if settler is on asteroid
        assertEquals(settlerCurrentAsteroid, asteroid);
    }
}
