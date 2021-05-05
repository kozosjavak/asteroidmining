package com.github.kozosjavak.asteroidmining.core;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SunTest {
    private Game game;
    private Sun sun;

    @Before
    public void setUp() throws Exception {
        game = new Game(100, 100);
        Location sunLocation = new Location(game, 0.0, 0.0);
        game.addLocation(sunLocation);
        sun = new Sun(sunLocation);
    }

    @Ignore
    @Test
    public void sun_should_move() throws CantMoveToTheSpecificLocationException {
        Location location1 = new Location(game, 1.1, 3.2);
        Location location2 = new Location(game, 3.1, 1.2);
        game.addLocation(location1);
        game.addLocation(location2);
        sun.sunMoving(4.4, 1.1, 1);
        assertEquals(4.4, sun.getLocation().getCoordinate().getX(), 0.1);
        assertEquals(1.1, sun.getLocation().getCoordinate().getY(), 0.1);
    }

    @Test(expected = CantMoveToTheSpecificLocationException.class)
    public void sun_shouldnt_move() throws CantMoveToTheSpecificLocationException {
        Location location1 = new Location(game, 1.1, 3.2);
        Location location2 = new Location(game, 3.1, 1.2);
        game.addLocation(location1);
        game.addLocation(location2);
        sun.sunMoving(1.2, 2.9, 1);
    }
}
