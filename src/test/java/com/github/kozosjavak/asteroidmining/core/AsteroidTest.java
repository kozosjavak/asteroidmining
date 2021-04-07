package com.github.kozosjavak.asteroidmining.core;

import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.core.materials.types.Waterice;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AsteroidTest {

    private Location testLocation1;
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        testLocation1 = new Location(game, 1.0, 3.0);
    }

    @Test
    public void should_get_back_set_spaceships() {
        Location testLocation = new Location(game, 2.2, 2.5);
        Asteroid testAsteroid = new Asteroid(testLocation, 2, false, null, 0);
        Settler testSpaceship = new Settler(testAsteroid); // addSpaceship()

        assertEquals(testSpaceship, testAsteroid.getResidence().get(0));

        Robot testSpaceship2 = new Robot(testAsteroid); // addSpaceship()
        testAsteroid.removeSpaceship(testSpaceship);

        assertEquals(testSpaceship2, testAsteroid.getResidence().get(0));
    }

    @Test(expected = AsteroidIsNotMineable.class)
    public void shouldnt_be_able_to_mine_if_not_fully_drilled() throws AsteroidIsNotMineable {
        Location testLocation = new Location(game, 2.2, 2.5);
        Material testMaterial = new Iron();
        Asteroid testAsteroid = new Asteroid(testLocation, 1, false, testMaterial, 0);

        Material mined = testAsteroid.mine();
    }

    @Test
    public void should_mine_only_if_fully_drilled() throws AsteroidIsNotMineable, SurfaceThicknessIsZeroException, NotEnoughMaterialException {
        Location testLocation = new Location(game, 2.2, 2.5);
        Material testMaterial = new Iron();
        Asteroid testAsteroid = new Asteroid(testLocation, 1, false, testMaterial, 0);

        testAsteroid.drill();
        Material mined = testAsteroid.mine();

        assertEquals(mined, testMaterial);
    }

    @Test
    public void explosion_should_clear_location_also() {
        Location testLocation = new Location(game, 2.2, 2.5);
        Teleport testTeleport = new Teleport();
        testLocation.setTeleport(testTeleport);
        Asteroid testAsteroid = new Asteroid(testLocation, 1, false, null, 0);

        testAsteroid.explode();

        assertEquals(null, testLocation.getTeleport());
    }

    @Test
    public void should_be_able_to_insert_and_remove_materials() throws AsteroidNotMinedException, InventoryIsFullException, NotEnoughMaterialException {
        Location testLocation = new Location(game, 2.2, 2.5);
        Material testMaterial1 = new Iron();
        Material testMaterial2 = new Coal();
        Asteroid testAsteroid = new Asteroid(testLocation, 0, false, null, 0);

        testAsteroid.insertMaterial(testMaterial1);
        testAsteroid.insertMaterial(testMaterial2);
        List<Material> comparatorList = new ArrayList<>();
        comparatorList.add(testMaterial1);
        comparatorList.add(testMaterial2);
        assertEquals(comparatorList, testAsteroid.getMaterials());

        testAsteroid.removeMaterial(testMaterial1);
        comparatorList.remove(testMaterial1);
        assertEquals(comparatorList, testAsteroid.getMaterials());
    }

    /**
     * buildBase is not tested here
     */

    /**
     * experienceSolarStrom is an empty implementation, can't be tested
     */

    @Test(expected = AsteroidIsNotMineable.class)
    public void waterice_should_disappear() throws NotEnoughMaterialException, AsteroidIsNotMineable {
        Location testLocation = new Location(game, 2.2, 2.5);
        Material testMaterial = new Waterice();
        Asteroid testAsteroid = new Asteroid(testLocation, 0, true, testMaterial, 0);

        testAsteroid.experienceExtremeHeat();

        testAsteroid.mine();
    }

    @Test
    public void uranium_should_explode() throws NotEnoughMaterialException, InterruptedException {
        Location testLocation = new Location(game, 2.2, 2.5);
        Material testMaterial = new Uranium();
        Asteroid testAsteroid = new Asteroid(testLocation, 0, true, testMaterial, 0);

        testAsteroid.experienceExtremeHeat();

        assertEquals(testAsteroid, testLocation.getCelestialBody());

        testAsteroid.experienceExtremeHeat();
        testAsteroid.experienceExtremeHeat();

        assertEquals(null, testLocation.getCelestialBody());
    }
}
