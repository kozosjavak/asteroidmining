package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.core.materials.types.Waterice;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SpaceShipTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Game game;

    @Before
    public void setUp() {
        game = new Game(100, 100);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void it_should_be_on_the_asteroid() {
        Location location1 = new Location(game, 1.1, 2.2);
        Asteroid asteroid1 = new Asteroid(location1, 3, new Coal());
        Settler settler = new Settler(asteroid1);
        assertEquals(asteroid1.getLocation(), settler.getCurrentAsteroid().getLocation());
    }

    @Test
    public void it_should_move_to_an_other_Asteroid() {
        Location location1 = new Location(game, 1.1, 2.2);
        Asteroid asteroid1 = new Asteroid(location1, 3, new Coal());
        Spaceship sp = new Spaceship(asteroid1);
        Location location2 = new Location(game, 1.2, 2.3);
        Asteroid asteroid2 = new Asteroid(location2, 4, new Waterice());
        sp.move(asteroid2.getLocation());
        assertEquals(asteroid2.getLocation(), sp.getCurrentAsteroid().getLocation());
    }

    @Test
    public void it_shouldnt_move_to_the_sun() {
        Location location1 = new Location(game, 1.1, 2.2);
        Asteroid asteroid1 = new Asteroid(location1, 3, new Coal());
        Spaceship sp = new Spaceship(asteroid1);
        Location location2 = new Location(game, 1.3, 2.4);
        Sun thesun = new Sun(location2);

        sp.move(thesun.getLocation());
        assertEquals(asteroid1.getLocation(), sp.getCurrentAsteroid().getLocation());
        assertEquals("The destination location is a sun", outContent.toString().trim());
    }

    @Test
    public void it_shouldnt_move_to_empty_location() {
        Location location1 = new Location(game, 1.1, 2.2);
        Asteroid asteroid1 = new Asteroid(location1, 3, new Coal());
        Spaceship sp = new Spaceship(asteroid1);
        Location location2 = new Location(game, 1.3, 2.4);

        sp.move(location2);
        assertEquals(asteroid1.getLocation(), sp.getCurrentAsteroid().getLocation());
        assertEquals("There is no body to land on, just the waste empty void.", outContent.toString().trim());
    }

    @Test
    public void it_should_be_removed_from_asteroid_by_dying() {
        Location location1 = new Location(game, 1.1, 2.2);
        Asteroid asteroid1 = new Asteroid(location1, 3, new Coal());
        Spaceship sp = new Spaceship(asteroid1);
        assertEquals(sp, asteroid1.getResidence().get(0));
        sp.die();
        assertEquals(0, asteroid1.getResidence().size());
        assertNull(sp.getCurrentAsteroid());
    }

    @Test
    public void it_should_return_current_asteroid() {
        Location location1 = new Location(game, 1.1, 2.2);
        Asteroid asteroid1 = new Asteroid(location1, 3, new Coal());
        Spaceship sp = new Spaceship(asteroid1);
        assertEquals(asteroid1, sp.getCurrentAsteroid());
    }

    @Test
    public void it_should_set_new_current_asteroid() {
        Location location1 = new Location(game, 1.1, 2.2);
        Location location2 = new Location(game, 1.6, 2.8);
        Asteroid asteroid1 = new Asteroid(location1, 3, new Coal());
        Asteroid asteroid2 = new Asteroid(location2, 4, new Coal());
        Spaceship sp = new Spaceship(asteroid1);
        sp.setCurrentAsteroid(asteroid2);
        assertEquals(asteroid2, sp.getCurrentAsteroid());
    }

    @Ignore
    @Test
    public void it_should_teleport_to_new_asteroid() {
        Location location1 = new Location(game, 1.1, 2.2);
        Location location2 = new Location(game, 1.6, 2.8);
        Asteroid asteroid1 = new Asteroid(location1, 3, new Coal());
        Asteroid asteroid2 = new Asteroid(location2, 4, new Coal());
        Spaceship sp = new Spaceship(asteroid1);
        Teleport teleport1 = new Teleport();
        Teleport teleport2 = new Teleport(teleport1);
        teleport1.setPair(teleport2);
        asteroid1.getLocation().setTeleport(teleport1);
        asteroid2.getLocation().setTeleport(teleport2);

        sp.teleport();
        assertEquals(asteroid2, sp.getCurrentAsteroid());
    }

    @Ignore
    @Test
    public void it_shouldnt_teleport_because_teleport_pair_is_not_available() {
        Location location1 = new Location(game, 1.1, 2.2);
        Asteroid asteroid1 = new Asteroid(location1, 3, new Coal());

        Spaceship sp = new Spaceship(asteroid1);

        Teleport teleport1 = new Teleport();
        asteroid1.getLocation().setTeleport(teleport1);

        sp.teleport();
        assertEquals("Teleport is not available", outContent.toString().trim());
    }

    @Test
    public void it_should_explode_and_die() throws Exception {
        Location location1 = new Location(game, 1.1, 2.2);
        Asteroid asteroid1 = new Asteroid(location1, 0, new Uranium());
        Spaceship sp = new Spaceship(asteroid1);


        asteroid1.experienceExtremeHeat();
        asteroid1.experienceExtremeHeat();

        assertEquals(1, asteroid1.getResidence().size());
        assertEquals(asteroid1, sp.getCurrentAsteroid());

        asteroid1.experienceExtremeHeat();

        assertEquals(0, asteroid1.getResidence().size());
        assertNull(sp.getCurrentAsteroid());


    }

    @Test
    public void it_should_hide_or_die_because_of_solarstrom() throws Exception {
        Location location1 = new Location(game, 1.1, 2.2);
        Asteroid asteroid1 = new Asteroid(location1, 1, null);

        Spaceship sp1 = new Spaceship(asteroid1);
        assertEquals(sp1, asteroid1.getResidence().get(0));
        asteroid1.experienceSolarStorm();
        assertEquals(0, asteroid1.getResidence().size());
        assertNull(sp1.getCurrentAsteroid());

        Spaceship sp2 = new Spaceship(asteroid1);
        assertEquals(sp2, asteroid1.getResidence().get(0));

        asteroid1.drill();

        asteroid1.experienceSolarStorm();
        assertEquals(1, asteroid1.getResidence().size());
        assertEquals(sp2, asteroid1.getResidence().get(0));
    }
}
