package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Location;
import com.github.kozosjavak.asteroidmining.core.Orb;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class JatekElveszteseTest {

    @Test
    @Ignore
    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-jatek_elvesztese.txt");
        Game game = E2eTools.getGame(inputStream);

        // TODO fix
        assertFalse("Game should not be running", game.isRunning());

        // Check if all settlers have deceased
        assertEquals("All settlers should be deceased", 0, game.getSettlers().size());

        // Check asteroid
        Location location = game.getLocation(0);
        assertNotNull(location);
        Orb celestialBody = location.getCelestialBody();
        assertNull(celestialBody);
    }
}
