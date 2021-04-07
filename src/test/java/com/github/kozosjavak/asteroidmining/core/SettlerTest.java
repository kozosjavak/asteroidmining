package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.core.materials.types.Waterice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class SettlerTest {

    private Game game;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
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
    public void settler_mine_material_after_that_check_inventory() throws AsteroidIsNotMineable, InventoryIsFullException {
        Location location1 = new Location(game, 5.4, 3.2);
        Asteroid asteroid1 = new Asteroid(location1, 0, false, new Coal(), 1);
        Settler settler = new Settler(asteroid1);
        settler.mine();
        assertEquals("Coal", settler.getInventory().getList().get(0).toString());
    }
    @Test
    public void setteler_drill_in_current_asteroid_decrease_surfacethickness() throws SurfaceThicknessIsZeroException, NotEnoughMaterialException, AsteroidIsNotMineable, InventoryIsFullException {
        Location location1 = new Location(game, 5.4, 3.2);
        Asteroid asteroid1 = new Asteroid(location1, 1, false, new Coal(), 1);
        Settler settler = new Settler(asteroid1);
        settler.drill();
        settler.mine();
        assertEquals("Coal", settler.getInventory().getList().get(0).toString());
    }
    @Test
    public void settler_build_one_teleport_pair() throws InventoryIsFullException, NotEnoughMaterialException {
        Location location1 = new Location(game, 5.4, 3.2);
        Asteroid asteroid1 = new Asteroid(location1, 0, false, new Coal(), 1);
        Settler settler = new Settler(asteroid1);
        settler.getInventory().add(new Uranium());
        settler.getInventory().add(new Waterice());
        settler.getInventory().add(new Iron());
        settler.getInventory().add(new Iron());
        settler.buildTeleportPair();
        assertEquals(settler.getTeleportInventory()[0].getPair(),settler.getTeleportInventory()[1]);
    }
    @Test
    public void settler_cant_build_teleport_cause_TeleportInvetnory_full() throws InventoryIsFullException, NotEnoughMaterialException {
        Location location1 = new Location(game, 5.4, 3.2);
        Asteroid asteroid1 = new Asteroid(location1, 0, false, new Coal(), 1);
        Settler settler = new Settler(asteroid1);
        settler.getInventory().add(new Uranium());
        settler.getInventory().add(new Waterice());
        settler.getInventory().add(new Iron());
        settler.getInventory().add(new Iron());
        settler.buildTeleportPair();
        settler.getInventory().add(new Uranium());
        settler.getInventory().add(new Waterice());
        settler.getInventory().add(new Iron());
        settler.getInventory().add(new Iron());
        settler.buildTeleportPair();
//matreial isnt tested.
        assertEquals("Not enough space in teleport inventory", outContent.toString().trim());
    }

    @Test
    public void settler_build_base_and_win_the_game() throws AsteroidIsNotMineable, InventoryIsFullException, AsteroidNotMinedException, NotEnoughMaterialException {
        Location location1 = new Location(game, 5.4, 3.2);
        Asteroid asteroid1 = new Asteroid(location1, 0, false, new Coal(), 1);
        Settler settler = new Settler(asteroid1);
        settler.mine();
        asteroid1.insertMaterial(new Iron());
        asteroid1.insertMaterial(new Iron());
        asteroid1.insertMaterial(new Iron());
        asteroid1.insertMaterial(new Waterice());
        asteroid1.insertMaterial(new Waterice());
        asteroid1.insertMaterial(new Waterice());
        settler.getInventory().add(new Uranium());
        settler.getInventory().add(new Uranium());
        settler.getInventory().add(new Uranium());
        settler.getInventory().add(new Coal());
        settler.getInventory().add(new Coal());
        settler.buildBase();
        assertEquals("Base builded!", outContent.toString().trim());
    }
    @Test
    public void settler_deploy_teleport() throws InventoryIsFullException, NotEnoughMaterialException {
        Location location1 = new Location(game, 5.4, 3.2);
        Asteroid asteroid1 = new Asteroid(location1, 0, false, new Coal(), 1);
        Settler settler = new Settler(asteroid1);
        settler.getInventory().add(new Uranium());
        settler.getInventory().add(new Waterice());
        settler.getInventory().add(new Iron());
        settler.getInventory().add(new Iron());
        settler.buildTeleportPair();
        settler.deployTeleport(0);
        assertEquals(location1.getTeleport().getPair(),settler.getTeleportInventory()[1]);
        //deploy teleport módosítva!
    }
}
