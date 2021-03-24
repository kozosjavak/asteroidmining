package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.materials.Materials;

import java.util.HashMap;
import java.util.Map;

/**
 * Skeleton osztály
 */
public class Skeleton {


    private final Map<Integer, Integer> useCaseUsageCounter = new HashMap<>();

    public Map<Integer, Integer> getUseCaseUsageCounter() {
        return useCaseUsageCounter;
    }

    public void fillMap(int useCasesNumber) {
        for (int i = 0; i < useCasesNumber; i++) {
            getUseCaseUsageCounter().putIfAbsent(i, 0);
        }
    }

    /**
     * Use case-ek futtatása
     *
     * @param line a kiválasztott use-case
     * @throws Exception általános kivétel
     */
    public void runUsecase(String line) throws Exception {

        System.out.println("Adja meg a parancs szamat:");
        int num;
        try {
            num = Integer.parseInt(line);
        } catch (NumberFormatException ex) {
            throw new Exception("A megadott parancs nem szám!");
        }

        if (num == 1) {
            usecaseDrillAsteroid();
            useCaseUsageCounter.replace(0, useCaseUsageCounter.get(0) + 1);
        } else if (num == 2) {
            usecaseLoseGame();
            useCaseUsageCounter.replace(1, useCaseUsageCounter.get(1) + 1);
        } else if (num == 3) {
            usecaseWinGame();
            useCaseUsageCounter.replace(2, useCaseUsageCounter.get(2) + 1);
        } else if (num == 4) {
            usecaseMineMaterial();
            useCaseUsageCounter.replace(3, useCaseUsageCounter.get(3) + 1);
        } else if (num == 5) {
            usecaseInsertMaterial();
            useCaseUsageCounter.replace(4, useCaseUsageCounter.get(4) + 1);
        } else if (num == 6) {
            usecaseDrillRadioactiveAsteroid();
            useCaseUsageCounter.replace(5, useCaseUsageCounter.get(5) + 1);
        } else if (num == 7) {
            usecaseBuildRobot();
            useCaseUsageCounter.replace(6, useCaseUsageCounter.get(6) + 1);
        } else if (num == 8) {
            usecaseMoveSettler();
            useCaseUsageCounter.replace(7, useCaseUsageCounter.get(7) + 1);
        } else if (num == 9) {
            usecaseDeployTeleport();
            useCaseUsageCounter.replace(8, useCaseUsageCounter.get(8) + 1);
        } else if (num == 10) {
            usecaseBuildTeleport();
            useCaseUsageCounter.replace(9, useCaseUsageCounter.get(9) + 1);
        } else if (num == 11) {
            usecaseRemoveMaterial();
            useCaseUsageCounter.replace(10, useCaseUsageCounter.get(10) + 1);
        } else if (num == 12) {
            usecaseBuildBase();
            useCaseUsageCounter.replace(11, useCaseUsageCounter.get(11) + 1);
        } else if (num == 0) {
            System.exit(0);
        } else {
            throw new Exception("Nem megfelelő számot adott meg!");
        }
    }

    /**
     * DrillAsteroid use case
     */
    public void usecaseDrillAsteroid() {
        System.out.println("1. Aszteroida fúrása:");
        Asteroid asteroid = new Asteroid(3, false, null, 0);
        System.out.println(asteroid + " ctor\n");

        Settler settler = new Settler(asteroid);
        System.out.println(settler + " ctor\n");
        System.out.println(" addSpaceShip->\n" + asteroid);
        try {
            try {

                settler.drill();
                System.out.println("drill->\n" + asteroid);
            } catch (NotEnoughMaterialException e) {
                e.printStackTrace();
            }
        } catch (SurfaceThicknessIsZeroException e) {
            e.printStackTrace();
        }
    }

    /**
     * LoseGame use case
     */
    public void usecaseLoseGame() {
        System.out.println("2. Játék elvesztése:");
        System.out.println("Game.startGame");
        Game.startGame();
        System.out.println(Game.getTheSun() + " ctor\n");
        Asteroid asteroid = new Asteroid(3, false, Materials.IRON, 0);
        System.out.println(asteroid + " ctor\n");

        Game.getTheSun().addNeighbor(asteroid);
        System.out.println("addNeighbor->\n" + Game.getTheSun() + "\n");

        Settler settler = new Settler(asteroid);
        System.out.println(settler + " ctor\n");
        System.out.println("addSpaceShip->" + asteroid + "\n");

        System.out.println("Game.endGame");
        Game.endGame();
        System.out.println("Telepesek szama die meghivasa elott: " + Game.getNumberOfSettlers());
        settler.die();
        System.out.println(settler + "-> die\n" + "Telepesek szama:" + Game.getNumberOfSettlers());
        System.out.println("Game.endGame");
        Game.endGame();
    }

    /**
     * WinGame use case
     */
    public void usecaseWinGame() {
        System.out.println("3. Játék megnyerése:");
        System.out.println("Game.startGame");
        Game.startGame();
        System.out.println(Game.getTheSun() + " ctor\n");
        Asteroid asteroid = new Asteroid(3, false, Materials.IRON, 0);
        System.out.println(asteroid + " ctor\n");

        Game.getTheSun().addNeighbor(asteroid);
        System.out.println("addNeighbor->\n" + Game.getTheSun() + "\n");

        Settler settler = new Settler(asteroid);
        System.out.println(settler + " ctor\n");
        System.out.println("addSpaceShip->" + asteroid + "\n");

        try {

            settler.drill();
            System.out.println("drill->" + asteroid);

            settler.drill();
            System.out.println("drill->" + asteroid);

            settler.drill();
            System.out.println("drill->" + asteroid);
        } catch (SurfaceThicknessIsZeroException | NotEnoughMaterialException e) {
            e.printStackTrace();
        }
        try {
            settler.mine();
            System.out.println(settler + "->mine->");
            System.out.println(asteroid);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            asteroid.insertMaterial(Materials.IRON);
            System.out.println("insertMaterial(IRON)->\n" + asteroid);
            asteroid.insertMaterial(Materials.IRON);
            System.out.println("insertMaterial(IRON)->\n" + asteroid);
            asteroid.insertMaterial(Materials.IRON);
            System.out.println("insertMaterial(IRON)->\n" + asteroid);


            asteroid.insertMaterial(Materials.WATERICE);
            System.out.println("insertMaterial(WaterIce)->\n" + asteroid);
            asteroid.insertMaterial(Materials.WATERICE);
            System.out.println("insertMaterial(WaterIce)->\n" + asteroid);
            asteroid.insertMaterial(Materials.WATERICE);
            System.out.println("insertMaterial(WaterIce)->\n" + asteroid);


            asteroid.insertMaterial(Materials.URANIUM);
            System.out.println("insertMaterial(WaterIce)->\n" + asteroid);
            asteroid.insertMaterial(Materials.URANIUM);
            System.out.println("insertMaterial(WaterIce)->\n" + asteroid);
            asteroid.insertMaterial(Materials.URANIUM);
            System.out.println("insertMaterial(WaterIce)->\n" + asteroid);


            asteroid.insertMaterial(Materials.COAL);
            System.out.println("insertMaterial(Coal)->\n" + asteroid);
            asteroid.insertMaterial(Materials.COAL);
            System.out.println("insertMaterial(Coal)->\n" + asteroid);
            asteroid.insertMaterial(Materials.COAL);
            System.out.println("insertMaterial(Coal)->\n" + asteroid);

            settler.buildBase();
        } catch (AsteroidNotMinedException e) {
            e.printStackTrace();
        }

    }

    /**
     * MineMaterial use case
     */
    public void usecaseMineMaterial() {
        System.out.println("4. Nyersanyag bányászása:");
        System.out.println("Game.startGame");
        Game.startGame();
        System.out.println(Game.getTheSun() + " ctor\n");
        Asteroid asteroid = new Asteroid(1, false, Materials.IRON, 0);
        System.out.println(asteroid + " ctor\n");

        Game.getTheSun().addNeighbor(asteroid);
        System.out.println("addNeighbor->\n" + Game.getTheSun() + "\n");

        Settler settler = new Settler(asteroid);
        System.out.println(settler + " ctor\n");
        System.out.println("addSpaceShip->" + asteroid + "\n");

        try {
            settler.mine();
            System.out.println(settler + "mine\n");
        } catch (Exception e) {
        }

        try {
            settler.drill();
            System.out.println("drill->" + asteroid);
        } catch (SurfaceThicknessIsZeroException | NotEnoughMaterialException e) {
            e.printStackTrace();
        }

        try {
            settler.mine();
            System.out.println("mine->\n" + settler);
            System.out.println(asteroid);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * InsertMaterial use case
     */
    public void usecaseInsertMaterial() {
        System.out.println("5. Nyersanyag visszahelyezése:");
        System.out.println("Game.startGame");
        Game.startGame();
        System.out.println(Game.getTheSun() + " ctor\n");
        Asteroid asteroid = new Asteroid(1, false, Materials.IRON, 0);
        System.out.println(asteroid + " ctor\n");

        Game.getTheSun().addNeighbor(asteroid);
        System.out.println("addNeighbor->\n" + Game.getTheSun() + "\n");

        Settler settler = new Settler(asteroid);
        System.out.println(settler + " ctor\n");
        System.out.println("addSpaceShip->" + asteroid + "\n");


        try {
            settler.drill();
            System.out.println("drill->" + asteroid);
        } catch (SurfaceThicknessIsZeroException | NotEnoughMaterialException e) {
            e.printStackTrace();
        }

        try {
            settler.mine();
            System.out.println("mine->\n" + settler);
            System.out.println(asteroid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            asteroid.insertMaterial(Materials.COAL);
            System.out.println("insertMaterial(Coal)->\n" + asteroid);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * DrillRadioactiveAsteroid use case
     */
    public void usecaseDrillRadioactiveAsteroid() {
        System.out.println("6. Radióaktív aszteroida fúrás:");
        System.out.println("Game.startGame");
        Game.startGame();
        System.out.println(Game.getTheSun() + " ctor\n");
        Asteroid asteroid = new Asteroid(1, true, Materials.URANIUM, 0);
        System.out.println(asteroid + " ctor\n");

        Game.getTheSun().addNeighbor(asteroid);
        System.out.println("addNeighbor->\n" + Game.getTheSun() + "\n");

        Settler settler = new Settler(asteroid);
        System.out.println(settler + " ctor\n");
        System.out.println("addSpaceShip->" + asteroid + "\n");

        try {

            System.out.println("Number of settlers: " + Game.getNumberOfSettlers());
            settler.drill();
            //System.out.println("drill->"+asteroid);
            System.out.println(Game.getTheSun());
            System.out.println("Number of settlers: " + Game.getNumberOfSettlers());
        } catch (SurfaceThicknessIsZeroException | NotEnoughMaterialException e) {
            e.printStackTrace();
        }

    }

    /**
     * BuildRobot use case
     */
    public void usecaseBuildRobot() {
        System.out.println("7. Robot építés:");
        System.out.println("Game.startGame");
        System.out.println("Game.startGame");
        Game.startGame();
        System.out.println(Game.getTheSun() + " ctor\n");
        Asteroid asteroid = new Asteroid(1, false, Materials.COAL, 0);
        System.out.println(asteroid + " ctor\n");

        Game.getTheSun().addNeighbor(asteroid);
        System.out.println("addNeighbor->\n" + Game.getTheSun() + "\n");

        Settler settler = new Settler(asteroid);
        System.out.println(settler + " ctor\n");
        System.out.println("addSpaceShip->" + asteroid + "\n");

        System.out.println(settler.getInventory());
        settler.getInventory().put(Materials.IRON, 1);
        System.out.println("put(Iron) ->" + settler.getInventory());

        settler.getInventory().put(Materials.COAL, 1);
        System.out.println("put(Coal) ->" + settler.getInventory());

        settler.getInventory().put(Materials.URANIUM, 1);
        System.out.println("put(Uranium) ->" + settler.getInventory());

        System.out.println(settler + "->buildRobot\n");
        settler.buildRobot();
        System.out.println(asteroid);
    }

    /**
     * MoveSettler use case
     */
    public void usecaseMoveSettler() {
        System.out.println("8. Telepes mozgatása:");


        System.out.println("Game.startGame");
        Game.startGame();
        System.out.println(Game.getTheSun() + " ctor\n");

        Asteroid asteroid1 = new Asteroid(1, false, Materials.COAL, 0);
        System.out.println(asteroid1 + " ctor\n");
        Game.getTheSun().addNeighbor(asteroid1);
        System.out.println("addNeighbor->\n" + Game.getTheSun() + "\n");

        Asteroid asteroid2 = new Asteroid(1, false, Materials.WATERICE, 0);
        System.out.println(asteroid2 + " ctor\n");
        Game.getTheSun().addNeighbor(asteroid2);
        System.out.println("addNeighbor->\n" + Game.getTheSun() + "\n");

        Settler settler = new Settler(asteroid1);
        System.out.println(settler + " ctor\n");
        System.out.println("addSpaceShip->" + asteroid1 + "\n");

        System.out.println(asteroid1 + "->move->");
        settler.move(asteroid2);
        System.out.println(asteroid2 + "\n");
        System.out.println("Indulasi aszteroida: " + asteroid1);
    }

    /**
     * DeployTeleport use case
     */
    public void usecaseDeployTeleport() {
        System.out.println("9. Teleportkapu lehelyezése:");
        System.out.println("Game.startGame");
        Game.startGame();
        System.out.println(Game.getTheSun() + " ctor\n");

        Asteroid asteroid1 = new Asteroid(1, false, Materials.COAL, 0);
        System.out.println(asteroid1 + " ctor\n");
        Game.getTheSun().addNeighbor(asteroid1);
        System.out.println("addNeighbor->\n" + Game.getTheSun() + "\n");

        Asteroid asteroid2 = new Asteroid(1, false, Materials.WATERICE, 0);
        System.out.println(asteroid2 + " ctor\n");
        Game.getTheSun().addNeighbor(asteroid2);
        System.out.println("addNeighbor->\n" + Game.getTheSun() + "\n");

        Settler settler = new Settler(asteroid1);
        System.out.println(settler + " ctor\n");
        System.out.println("addSpaceShip->" + asteroid1 + "\n");


        System.out.println(settler.getInventory() + "put(IRON)\n");
        settler.getInventory().putIfAbsent(Materials.IRON, 0);
        settler.getInventory().computeIfPresent(Materials.IRON, (material1, amount) -> amount + 2);
        System.out.println(settler.getInventory() + "put(WATERICE)\n");
        settler.getInventory().putIfAbsent(Materials.WATERICE, 0);
        settler.getInventory().computeIfPresent(Materials.WATERICE, (material1, amount) -> amount + 1);
        System.out.println(settler.getInventory() + "put(URANIUM)\n");
        settler.getInventory().putIfAbsent(Materials.URANIUM, 0);
        settler.getInventory().computeIfPresent(Materials.URANIUM, (material1, amount) -> amount + 1);
        System.out.println(settler);
        settler.buildTeleportPair();
        System.out.println(settler);
        System.out.println("Buildtelepor->\n" + settler);
        System.out.println(settler + "->deployteleport->");
        settler.deployTeleport(asteroid1);
        System.out.println("\n" + asteroid1.toStringOnlyName());

        System.out.println(settler + "->move->" + asteroid2.toStringOnlyName() + "\n");
        settler.move(asteroid2);
        System.out.println(settler + "->deployteleport->");
        settler.deployTeleport(asteroid2);
        System.out.println("\n" + asteroid1.toStringOnlyName());
    }

    /**
     * BuildTeleport use case
     */
    public void usecaseBuildTeleport() {
        System.out.println("10. Teleportkapu-pár építése:");
        System.out.println("Game.startGame");
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, false, null, 0);
        System.out.println(asteroid + "ctor\n");
        System.out.println(asteroid + "addNeighbor" + Game.getTheSun() + "\n");
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        System.out.println(settler + "ctor\n");
        System.out.println(asteroid + "addSpaceShip " + settler + "\n");

        System.out.println(settler.getInventory() + "put(IRON)\n");
        settler.getInventory().putIfAbsent(Materials.IRON, 0);
        settler.getInventory().computeIfPresent(Materials.IRON, (material1, amount) -> amount + 2);
        System.out.println(settler.getInventory() + "put(WATERICE)\n");
        settler.getInventory().putIfAbsent(Materials.WATERICE, 0);
        settler.getInventory().computeIfPresent(Materials.WATERICE, (material1, amount) -> amount + 1);
        System.out.println(settler.getInventory() + "put(URANIUM)\n");
        settler.getInventory().putIfAbsent(Materials.URANIUM, 0);
        settler.getInventory().computeIfPresent(Materials.URANIUM, (material1, amount) -> amount + 1);
        System.out.println(settler + "buildTeleportPair\n");
        settler.buildTeleportPair();
        System.out.println(settler);
    }

    /**
     * RemoveMaterial use case
     */
    public void usecaseRemoveMaterial() {
        System.out.println("11. Üreges aszteroidából nyersanyag felvétel:");
        System.out.println("Game.startGame");
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, false, null, 0);
        System.out.println(asteroid + "ctor\n");
        System.out.println(Game.getTheSun() + "addNeighbor\n" + asteroid);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        System.out.println(settler + "ctor\n");
        System.out.println(asteroid + "addSpaceShip" + settler + "\n");
        asteroid.addSpaceShip(settler);
        try {
            System.out.println(asteroid + "insertMaterial(Coal)\n");
            asteroid.insertMaterial(Materials.COAL);
        } catch (AsteroidNotMinedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(asteroid + "removeMaterial(Coal)\n");
            asteroid.removeMaterial(Materials.COAL);
        } catch (NotEnoughMaterialException e) {
            e.printStackTrace();
        }

    }

    /**
     * BuildBase use case
     */
    public void usecaseBuildBase() {
        System.out.println("12. Űrbázis építése:");
        System.out.println("Game.startGame");
        Game.startGame();
        System.out.println(Game.getTheSun() + " ctor\n");
        Asteroid asteroid = new Asteroid(3, false, Materials.IRON, 0);
        System.out.println(asteroid + " ctor\n");

        Game.getTheSun().addNeighbor(asteroid);
        System.out.println("addNeighbor->\n" + Game.getTheSun() + "\n");

        Settler settler = new Settler(asteroid);
        System.out.println(settler + " ctor\n");
        System.out.println("addSpaceShip->" + asteroid + "\n");

        try {

            settler.drill();
            System.out.println("drill->" + asteroid);

            settler.drill();
            System.out.println("drill->" + asteroid);

            settler.drill();
            System.out.println("drill->" + asteroid);
        } catch (SurfaceThicknessIsZeroException | NotEnoughMaterialException e) {
            e.printStackTrace();
        }
        try {
            settler.mine();
            System.out.println(settler + "->mine->");
            System.out.println(asteroid);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            asteroid.insertMaterial(Materials.IRON);
            System.out.println("insertMaterial(IRON)->\n" + asteroid);
            asteroid.insertMaterial(Materials.IRON);
            System.out.println("insertMaterial(IRON)->\n" + asteroid);
            asteroid.insertMaterial(Materials.IRON);
            System.out.println("insertMaterial(IRON)->\n" + asteroid);


            asteroid.insertMaterial(Materials.WATERICE);
            System.out.println("insertMaterial(WaterIce)->\n" + asteroid);
            asteroid.insertMaterial(Materials.WATERICE);
            System.out.println("insertMaterial(WaterIce)->\n" + asteroid);
            asteroid.insertMaterial(Materials.WATERICE);
            System.out.println("insertMaterial(WaterIce)->\n" + asteroid);


            asteroid.insertMaterial(Materials.URANIUM);
            System.out.println("insertMaterial(WaterIce)->\n" + asteroid);
            asteroid.insertMaterial(Materials.URANIUM);
            System.out.println("insertMaterial(WaterIce)->\n" + asteroid);
            asteroid.insertMaterial(Materials.URANIUM);
            System.out.println("insertMaterial(WaterIce)->\n" + asteroid);


            asteroid.insertMaterial(Materials.COAL);
            System.out.println("insertMaterial(Coal)->\n" + asteroid);
            asteroid.insertMaterial(Materials.COAL);
            System.out.println("insertMaterial(Coal)->\n" + asteroid);
            asteroid.insertMaterial(Materials.COAL);
            System.out.println("insertMaterial(Coal)->\n" + asteroid);

            settler.buildBase();
        } catch (AsteroidNotMinedException e) {
            e.printStackTrace();
        }

    }
}