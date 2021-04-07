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
        game = new Game();
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
        Asteroid asteroid1 = new Asteroid(location1, 0, false, new Coal(), 1);
        Ufo ufo = new Ufo(asteroid1);
        ufo.mine();
        assertEquals("Coal", ufo.getInventory().getList().get(0).toString());
    }

    @Test
    public void ufo_get_experience_extreme_heat() throws InventoryIsFullException, NotEnoughMaterialException {
        Location location1 = new Location(game, 5.4, 3.2);
        Asteroid asteroid1 = new Asteroid(location1, 0, false, new Coal(), 1);
        Ufo ufo = new Ufo(asteroid1);
        ufo.getInventory().add(new Uranium());
        ufo.experienceExtremeHeat();
        ufo.experienceExtremeHeat();
        ufo.experienceExtremeHeat();
        assertNull(ufo.getCurrentAsteroid());
    }
}
