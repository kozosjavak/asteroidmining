package com.github.kozosjavak.asteroidmining.core.bills;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BillsNamesTest {
    @Test
    public void test_names() {
        assertEquals("Bill of Base", Bills.BASE.toString());
        assertEquals("Bill of Robot", Bills.ROBOT.toString());
        assertEquals("Bill of Teleport", Bills.TELEPORT.toString());
    }
}
