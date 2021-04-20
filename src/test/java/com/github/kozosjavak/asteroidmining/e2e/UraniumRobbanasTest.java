package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.Game;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class UraniumRobbanasTest {

    @Test
    @Ignore
    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-uran_robbanasa.txt");
        Game game = E2eTools.getGame(inputStream);

        // Settler should die
        assertEquals(0, game.getSettlers().size());

        // UFO should die
        assertNull(game.getObjectFromID(7));

        // Check if asteroid id:0 exploded
        assertNotNull(game.getLocation(0));
        assertNull(game.getLocation(0).getOrb());

        // Check if asteroid id:1 exploded
        assertNotNull(game.getLocation(1));
        assertNull(game.getLocation(1).getOrb());

        // Check if asteroid id:2 exploded
        assertNotNull(game.getLocation(2));
        assertNull(game.getLocation(2).getOrb());
    }
}
