package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RobotTest {
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
    public void it_should_explode_and_move_to_random_neighbor() throws Exception {
        Location location1 = new Location(game, 1.1, 2.2);
        Location location2 = new Location(game, 1.6, 2.8);
        location1.addNeighbor(location2);
        location2.addNeighbor(location1);
        Asteroid asteroid1 = new Asteroid(location1, 0, false, new Uranium(), 1);
        Asteroid asteroid2 = new Asteroid(location2, 4, false, new Coal(), 1);
        Robot robot = new Robot(asteroid1);


        asteroid1.experienceExtremeHeat();
            asteroid1.experienceExtremeHeat();

        assertEquals(1, asteroid1.getResidence().size());
        assertEquals(0, asteroid2.getResidence().size());
        assertEquals(asteroid1, robot.getCurrentAsteroid());

        asteroid1.experienceExtremeHeat();

        assertEquals(0, asteroid1.getResidence().size());
        assertEquals(1, asteroid2.getResidence().size());
        assertEquals(asteroid2, robot.getCurrentAsteroid());


    }

    @Test
    public void it_should_drill_by_step() throws Exception {
        Location location = new Location(game, 0.0, 0.0);
        Asteroid asteroid = new Asteroid(location, 2, false, null, 0);
        Robot robot = new Robot(asteroid);
        robot.step();
        assertEquals(1, asteroid.getSurfaceThickness());
    }

    @Test
    public void it_should_move_by_step() throws Exception {
        Location location = new Location(game, 0.0, 0.0);
        Location location1 = new Location(game, 1.2, 1.1);
        game.addLocation(location);
        game.addLocation(location1);
        Asteroid asteroid1 = new Asteroid(location, 0, false, new Coal(), 0);
        Asteroid asteroid2 = new Asteroid(location1, 2, false, new Coal(), 0);
        Robot robot = new Robot(asteroid1);
        asteroid1.getLocation().refreshNeighborsList(5);
        asteroid2.getLocation().refreshNeighborsList(5);
        robot.step();
        assertEquals(robot, asteroid2.getResidence().get(0));
    }
}
