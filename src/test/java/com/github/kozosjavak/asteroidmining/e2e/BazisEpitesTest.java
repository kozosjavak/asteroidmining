package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.*;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class BazisEpitesTest {

    @Test
    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-bazis_epitese.txt");
        Game game = E2eTools.getGame(inputStream);

        // Game is won
        assertTrue("Game should be won", game.isWon());

        // Check settler
        assertEquals(1, game.getSettlers().size());
        Settler settler = (Settler) game.getSettlers().iterator().next();
        Asteroid settlerCurrentAsteroid = settler.getCurrentAsteroid();

        // Check asteroid
        Location location = game.getLocation(0);
        assertNotNull(location);
        Orb celestialBody = location.getCelestialBody();
        assertEquals(Asteroid.class, celestialBody.getClass());
        Asteroid asteroid = (Asteroid) celestialBody;
        assertEquals(0, asteroid.getSurfaceThickness());

        // Check if settler is on asteroid
        assertEquals(settlerCurrentAsteroid, asteroid);
    }
}
