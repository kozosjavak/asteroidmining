package com.github.kozosjavak.asteroidmining.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TeleportTest {
    @Test
    public void it_should_link_two_teleport_into_pair() {
        Teleport teleport1 = new Teleport();
        Teleport teleport2 = new Teleport(teleport1);
        teleport1.setPair(teleport2);

        assertEquals(teleport2, teleport1.getPair());
        assertEquals(teleport1, teleport2.getPair());
    }

    @Test
    public void it_should_return_the_linked_teleport_location() {
        Teleport teleport1 = new Teleport();
        Teleport teleport2 = new Teleport(teleport1);
        Location location = new Location(1.1, 1.1);
        teleport2.setLocation(location);
        teleport1.setPair(teleport2);

        assertEquals(location, teleport1.getPair().getLocation());
    }

    @Test
    public void it_should_destroy_the_pair() {
        Teleport teleport1 = new Teleport();
        Teleport teleport2 = new Teleport(teleport1);
        teleport1.setPair(teleport2);

        teleport1.getHitByExplosion();

        assertNull(teleport1.getPair());
        assertNull(teleport2.getPair());

        assertNull(teleport1.getLocation());
        assertNull(teleport2.getLocation());
    }

    @Test
    public void it_should_get_new_location() {
        Teleport teleport1 = new Teleport();
        Teleport teleport2 = new Teleport(teleport1);
        teleport1.setPair(teleport2);
        Location location = new Location(1.1, 1.1);
        teleport2.setLocation(location);

        assertEquals(location, teleport1.getPair().getLocation());
        Location location2 = new Location(1.2, 1.2);
        teleport2.setLocation(location2);
        assertEquals(location2, teleport1.getPair().getLocation());
    }
}
