package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Location;
import com.github.kozosjavak.asteroidmining.core.Settler;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class TeleportalasTest {
    @Ignore
    @Test
    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-teleportalas.txt");
        Game game = E2eTools.getGame(inputStream);

        // Check settler
        assertEquals(1, game.getSettlers().size());
        Settler settler = (Settler) game.getSettlers().iterator().next();
        assertEquals("Settler should have no materials", 0, settler.getInventory().getSize());

        Location location0 = game.getLocation(0);
        assertNotNull(location0.getTeleport());

        Location location1 = game.getLocation(1);
        assertNotNull(location1.getTeleport());

        // Test pairs
        assertEquals("Teleport should point to the other location", location1, location0.getTeleport().getPair().getLocation());
        assertEquals("Teleport should point to the other location", location0, location1.getTeleport().getPair().getLocation());

        // Check settler teleports
        assertNull(settler.getTeleportInventory()[0]);
        assertNull(settler.getTeleportInventory()[1]);
        assertNull(settler.getTeleportInventory()[2]);

        // Check if settler is on asteroid
        assertEquals(location1, settler.getCurrentAsteroid().getLocation());
    }
}
