package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Location;
import com.github.kozosjavak.asteroidmining.core.Settler;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class UrhajoMozgasTest {

    @Test
    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-urhajo_mozgatasa.txt");
        Game game = E2eTools.getGame(inputStream);

        // Check settler
        assertEquals(1, game.getSettlers().size());
        Settler settler = (Settler) game.getSettlers().iterator().next();

        Location location = game.getLocation(1);

        // Check if settler is on asteroid
        assertEquals(location, settler.getCurrentAsteroid().getLocation());
    }
}
