package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UfoTest {
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
    public void ufo_mine_material() throws AsteroidIsNotMineable, InventoryIsFullException {
        Location location1 = new Location(game, 5.4, 3.2);
        Asteroid asteroid1 = new Asteroid(location1, 0, new Coal());
        Ufo ufo = new Ufo(asteroid1);
        ufo.mine();
        assertEquals("Coal", ufo.getInventory().getList().get(0).toString());
    }

    @Test
    public void ufo_get_experience_extreme_heat() throws Exception {
        Location location1 = new Location(game, 5.4, 3.2);
        Asteroid asteroid1 = new Asteroid(location1, 0, new Coal());
        Ufo ufo = new Ufo(asteroid1);
        ufo.getInventory().add(new Uranium());
        ufo.experienceExtremeHeat();
        ufo.experienceExtremeHeat();
        ufo.experienceExtremeHeat();
        assertNull(ufo.getCurrentAsteroid());
    }

    @Test
    public void it_should_mine_by_step() throws Exception {
        Location location = new Location(game, 1.1, 1.1);
        Asteroid asteroid1 = new Asteroid(location, 0, new Coal());
        Ufo ufo = new Ufo(asteroid1);
        ufo.step();
        assertNull(asteroid1.getSubstance());
        assertEquals(Coal.class, ufo.getInventory().getList().get(0).getClass());
    }

    @Test
    public void it_shouldnt_mine_by_step() throws Exception {
        Location location = new Location(game, 1.1, 1.1);
        Asteroid asteroid1 = new Asteroid(location, 1, new Coal());
        Ufo ufo = new Ufo(asteroid1);
        ufo.step();
    }

    @Test
    public void it_should_experience_extreme_heat() throws Exception {
        Location location = new Location(game, 1.1, 1.1);
        Asteroid asteroid1 = new Asteroid(location, 0, new Uranium());
        Ufo ufo = new Ufo(asteroid1);
        ufo.step();
        ufo.experienceExtremeHeat();
        ufo.experienceExtremeHeat();
        ufo.experienceExtremeHeat();
        assertEquals(0, asteroid1.getResidence().size());
    }
}
