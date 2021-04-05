package com.github.kozosjavak.asteroidmining.core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class LocationTest {

    @Test
    public void coordinates_should_be_the_set_coordinates() {
        Location testLocation = new Location(2.2,2.5);
        Coordinate testCoordinate = new Coordinate(2.2, 2.5);

        assertEquals(testCoordinate.getX(), testLocation.getCoordinate().getX(), 0);
        assertEquals(testCoordinate.getY(), testLocation.getCoordinate().getY(), 0);
    }

    @Test
    public void celestialbody_should_be_set() {
        Location testLocation = new Location(2.2,2.5);
        Orb testOrb = new Orb(testLocation); // Ctor calls testLocation.SetCelestialBody()

        assertEquals(testOrb, testLocation.getCelestialBody());
    }

    @Test
    public void teleport_should_be_set() {
        Location testLocation = new Location(2.2,2.5);
        Teleport testTeleport = new Teleport();
        testLocation.setTeleport(testTeleport);

        assertEquals(testTeleport, testLocation.getTeleport());
    }

    @Test
    public void fullhitbyexplosion_should_clear_the_location() {
        Location testLocation = new Location(2.2,2.5);
        Teleport testTeleport = new Teleport();
        testLocation.setTeleport(testTeleport);

        assertEquals(testTeleport, testLocation.getTeleport());
    }

    @Test
    public void getneighbor_and_getrandomneighbor_should_return_with_one_of_added_with_addneighbor() {
        Location testLocation1 = new Location(1.1,1.1);
        Location testLocation2 = new Location(2.2,2.2);
        Location testLocation3 = new Location(3.3,3.3);

        testLocation1.addNeighbor(testLocation2);
        assertEquals(testLocation2, testLocation1.getRandomNeighbor());

        testLocation1.addNeighbor(testLocation3);
        List<Location> neighborList = testLocation1.getNeighbors();
        assertEquals(testLocation2, neighborList.get(0));

        testLocation1.removeNeighbor(testLocation2);

        neighborList = testLocation1.getNeighbors();
        assertEquals(testLocation3, neighborList.get(0));
    }


    /**
     * Location.toString() fuggvenyhez nem tartozik teszt
     */

}
