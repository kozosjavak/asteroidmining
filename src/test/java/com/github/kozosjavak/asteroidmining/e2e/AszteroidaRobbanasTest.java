package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Robot;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class AszteroidaRobbanasTest {

    @Test
    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-aszteroida_robbanasa.txt");
        Game game = E2eTools.getGame(inputStream);

        // Settler should die
        assertEquals(0, game.getSettlers().size());

        // Check if asteroid id:0 exploded
        assertNotNull(game.getLocation(0));
        assertNull(game.getLocation(0).getOrb());

        // Check asteroid id:1
        Asteroid asteroid1 = (Asteroid) game.getLocation(1).getCelestialBody();
        //assertEquals(1, asteroid1.getResidence().size());

        // Check robot
        assertNotNull(game.getObjectFromID(3));
        assertEquals(Robot.class, game.getObjectFromID(3).getClass());
        Robot robot = (Robot) game.getObjectFromID(3);
        assertEquals("Robot is not on asteroid 1", asteroid1, robot.getCurrentAsteroid());

    }
}
