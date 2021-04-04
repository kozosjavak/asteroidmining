package com.github.kozosjavak.asteroidmining.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {
    @Test
    public void it_should_give_back_what_it_gets_from_constructor() {
        Coordinate coor = new Coordinate(13.4, 0.1);
        assertEquals(13.4, coor.getX(), 0.1);
        assertEquals(0.1, coor.getY(), 0.1);
    }

    @Test
    public void it_should_give_back_the_distance_between_two_coordinates() {
        Coordinate coorPositive1 = new Coordinate(1.1, 123.034);
        Coordinate coorPositive2 = new Coordinate(15.13, 0.0);
        Coordinate coorNegative1 = new Coordinate(-15.13, 0.0);
        Coordinate coorNegative2 = new Coordinate(-1.004, -125.53);
        //P1 - P2
        assertEquals(123.831, coorPositive1.getDistance(coorPositive2), 0.001);
        assertEquals(123.831, coorPositive2.getDistance(coorPositive1), 0.001);
        //N1-P1
        assertEquals(124.1, coorNegative1.getDistance(coorPositive1), 0.1);
        assertEquals(124.1, coorPositive1.getDistance(coorNegative1), 0.1);
        //N1-N2
        assertEquals(126.322, coorNegative1.getDistance(coorNegative2), 0.001);
        assertEquals(126.322, coorNegative2.getDistance(coorNegative1), 0.001);
    }

    @Test
    public void it_should_update_the_coordinates() {
        Coordinate coor = new Coordinate(13.4, 0.1);
        assertEquals(13.4, coor.getX(), 0.1);
        assertEquals(0.1, coor.getY(), 0.1);
        coor.updateCoordinates(1.1, 2.2);
        assertEquals(1.1, coor.getX(), 0.1);
        assertEquals(2.2, coor.getY(), 0.1);

    }

}
