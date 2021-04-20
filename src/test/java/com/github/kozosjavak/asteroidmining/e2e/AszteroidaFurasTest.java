package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.*;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AszteroidaFurasTest {

    @Test
    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-aszteroida_furasa.txt");
        Game game = E2eTools.getGame(inputStream);

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
