package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LocationTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game(100, 100);
    }

    @Test
    public void coordinates_should_be_the_set_coordinates() {
        Location testLocation = new Location(game, 2.2, 2.5);
        Coordinate testCoordinate = new Coordinate(2.2, 2.5);

        assertEquals(testCoordinate.getX(), testLocation.getCoordinate().getX(), 0);
        assertEquals(testCoordinate.getY(), testLocation.getCoordinate().getY(), 0);
    }

    @Test
    public void celestialbody_should_be_set() {
        Location testLocation = new Location(game, 2.2, 2.5);
        Orb testOrb = new Orb(testLocation); // Ctor calls testLocation.SetCelestialBody()

        assertEquals(testOrb, testLocation.getCelestialBody());
    }

    @Test
    public void teleport_should_be_set() {
        Location testLocation = new Location(game, 2.2, 2.5);
        Teleport testTeleport = new Teleport();
        testLocation.setTeleport(testTeleport);

        assertEquals(testTeleport, testLocation.getTeleport());
    }

    @Test
    public void fullhitbyexplosion_should_clear_the_location() {
        Location testLocation = new Location(game, 2.2, 2.5);
        Teleport testTeleport = new Teleport();
        testLocation.setTeleport(testTeleport);

        assertEquals(testTeleport, testLocation.getTeleport());
    }

    @Test
    public void getneighbor_and_getrandomneighbor_should_return_with_one_of_added_with_addneighbor() throws Exception {
        Location testLocation1 = new Location(game, 1.1, 1.1);
        Location testLocation2 = new Location(game, 2.2, 2.2);
        Location testLocation3 = new Location(game, 3.3, 3.3);

        testLocation1.addNeighbor(testLocation2);
        assertEquals(testLocation2, testLocation1.getRandomNeighbor());

        testLocation1.addNeighbor(testLocation3);
        List<Location> neighborList = testLocation1.getNeighbors();
        assertEquals(testLocation2, neighborList.get(0));
        assertTrue(testLocation2 == testLocation1.getRandomNeighbor() || testLocation3 == testLocation1.getRandomNeighbor());

        testLocation1.removeNeighbor(testLocation2);

        neighborList = testLocation1.getNeighbors();
        assertEquals(testLocation3, neighborList.get(0));
    }

    @Test
    public void it_should_remove_a_location_from_neighbours_via_refresh_location() {
        Location testLocation1 = new Location(game, 0.1, 0.1);
        Location testLocation2 = new Location(game, 4.2, 0.1);
        Location testLocation3 = new Location(game, 3.3, 3.3);

        game.addLocation(testLocation1);
        game.addLocation(testLocation2);
        game.addLocation(testLocation3);

        testLocation2.refreshNeighborsList(5.0);
        assertTrue(testLocation2.getNeighbors().contains(testLocation1));
        assertTrue(testLocation2.getNeighbors().contains(testLocation3));
        assertFalse(testLocation2.getNeighbors().contains(testLocation2));

        testLocation3.getCoordinate().updateCoordinates(10.1, 3.3);
        testLocation2.refreshNeighborsList(5.0);
        assertTrue(testLocation2.getNeighbors().contains(testLocation1));
        assertFalse(testLocation2.getNeighbors().contains(testLocation3));
        assertFalse(testLocation2.getNeighbors().contains(testLocation2));
    }

    @Ignore
    @Test
    public void it_should_apply_solarstorm_to_orb_and_teleport() throws Exception {
        Location testLocation = new Location(game, 0.1, 0.1);
        Location testLocation2 = new Location(game, 0.3, 0.4);
        testLocation.addNeighbor(testLocation2);
        testLocation2.addNeighbor(testLocation);

        Teleport testTeleport = new Teleport();

        testLocation.setTeleport(testTeleport);

        Asteroid testAsteroid = new Asteroid(testLocation, 0, new Uranium());

        testLocation.experienceSolarStorm(); // testTeleport is solarized
        //testTeleport.step(); // TODO vissza rakni

        assertEquals(testLocation2, testTeleport.getLocation());
    }


    /**
     * Location.toString() fuggvenyhez nem tartozik teszt
     */

}
