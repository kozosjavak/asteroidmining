package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.materials.Materials;

/** Skeleton osztály */
public class Skeleton {


    /**
     * Use case-ek futtatása
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
        } else if (num == 2) {
            usecaseLoseGame();
        } else if (num == 3) {
            usecaseWinGame();
        } else if (num == 4) {
            usecaseMineMaterial();
        } else if (num == 5) {
            usecaseInsertMaterial();
        } else if (num == 6) {
            usecaseDrillRadioactiveAsteroid();
        } else if (num == 7) {
            usecaseBuildRobot();
        } else if (num == 8) {
            usecaseMoveSettler();
        } else if (num == 9) {
            usecaseDeployTeleport();
        } else if (num == 10) {
            usecaseBuildTeleport();
        } else if (num == 11) {
            usecaseRemoveMaterial();
        } else if (num == 12) {
            usecaseBuildBase();
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
        System.out.println(asteroid + " addSpaceShip\n");
        try {
            try {

                settler.drill();
                System.out.println(asteroid + " drill\n");
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

        Asteroid asteroid = new Asteroid(3, false, null, 0);
        System.out.println(asteroid + " ctor\n");
        System.out.println(asteroid + "addNeighbor" + Game.getTheSun() + "\n");
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        System.out.println(settler + " ctor\n");
        System.out.println(asteroid + " addSpaceShip " + settler + "\n");
        asteroid.addSpaceShip(settler);
        System.out.println("Game.endGame");
        Game.endGame();
        System.out.println(settler + "die\n");
        settler.die();
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
        Asteroid asteroid = new Asteroid(3, false, Materials.COAL, 0);
        System.out.println(asteroid + "ctor\n");
        Game.getTheSun().addNeighbor(asteroid);
        System.out.println(Game.getTheSun() + "addNeighbor" + asteroid + "\n");
        Settler settler = new Settler(asteroid);
        System.out.println(settler + "ctor\n");
        System.out.println(asteroid + "addSpaceShip" + settler + "\n");
        asteroid.addSpaceShip(settler);
        try {
            System.out.println(settler + "drill\n");
            settler.drill();
            System.out.println(settler + "drill\n");
            settler.drill();
            System.out.println(settler + "drill\n");
            settler.drill();
        } catch (SurfaceThicknessIsZeroException | NotEnoughMaterialException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(settler + "mine\n");
            settler.mine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(asteroid + "insertMaterial(IRON)\n");
            asteroid.insertMaterial(Materials.IRON);
            System.out.println(asteroid + "insertMaterial(IRON)\n");
            asteroid.insertMaterial(Materials.IRON);
            System.out.println(asteroid + "insertMaterial(IRON)\n");
            asteroid.insertMaterial(Materials.IRON);

            System.out.println(asteroid + "insertMaterial(WaterIce)\n");
            asteroid.insertMaterial(Materials.WATERICE);
            System.out.println(asteroid + "insertMaterial(WaterIce)\n");
            asteroid.insertMaterial(Materials.WATERICE);
            System.out.println(asteroid + "insertMaterial(WaterIce)\n");
            asteroid.insertMaterial(Materials.WATERICE);

            System.out.println(asteroid + "insertMaterial(Uanium)\n");
            asteroid.insertMaterial(Materials.URANIUM);
            System.out.println(asteroid + "insertMaterial(Uanium)\n");
            asteroid.insertMaterial(Materials.URANIUM);
            System.out.println(asteroid + "insertMaterial(Uanium)\n");
            asteroid.insertMaterial(Materials.URANIUM);

            System.out.println(asteroid + "insertMaterial(Coal)\n");
            asteroid.insertMaterial(Materials.COAL);
            System.out.println(asteroid + "insertMaterial(Coal)\n");
            asteroid.insertMaterial(Materials.COAL);
            System.out.println(asteroid + "insertMaterial(Coal)\n");
            asteroid.insertMaterial(Materials.COAL);
        } catch (AsteroidNotMinedException e) {
            e.printStackTrace();
        }
        System.out.println(settler + "buildBase\n");
        settler.buildBase();

    }

    /**
     * MineMaterial use case
     */
    public void usecaseMineMaterial() {
        System.out.println("4. Nyersanyag bányászása:");
        System.out.println("Game.startGame");
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, false, Materials.WATERICE, 0);
        System.out.println(asteroid + "ctor\n");
        System.out.println(Game.getTheSun() + "addNeighbor" + asteroid + "\n");
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        System.out.println(settler + "ctor\n");
        asteroid.addSpaceShip(settler);
        System.out.println(asteroid + "addSpaceShip " + settler + "\n");

        try {
            System.out.println(settler + "mine\n");
            settler.mine();
        } catch (Exception e) {
        }

        try {
            System.out.println(settler + "drill\n");
            settler.drill();
        } catch (SurfaceThicknessIsZeroException | NotEnoughMaterialException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(settler + "mine\n");
            settler.mine();
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

        Asteroid asteroid = new Asteroid(1, false, Materials.IRON, 0);
        System.out.println(asteroid + "ctor\n");
        System.out.println(Game.getTheSun() + "addNeighbor" + asteroid + "\n");
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        System.out.println(settler + "ctor\n");
        System.out.println(asteroid + "addSpaceShip " + settler + "\n");
        asteroid.addSpaceShip(settler);
        System.out.println(settler.getInventory() + "put(Coal, 1)\n");
        settler.getInventory().put(Materials.COAL, 1);


        try {
            System.out.println(settler + "drill\n");
            settler.drill();
        } catch (SurfaceThicknessIsZeroException | NotEnoughMaterialException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(settler + "mine\n");
            settler.mine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(settler + "insertMaterial(IRON)\n");
            settler.insertMaterial(Materials.IRON);
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

        Asteroid asteroid = new Asteroid(1, true, Materials.URANIUM, 0);

        System.out.println(asteroid + "ctor\n");
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        System.out.println(settler + "ctor\n");
        System.out.println(asteroid + "addSpaceShip " + settler + "\n");
        asteroid.addSpaceShip(settler);
        try {
            System.out.println(settler + "drill\n");
            settler.drill();
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
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, false, null, 0);
        System.out.println(asteroid + "ctor\n");
        System.out.println(Game.getTheSun() + "addNeighbor" + asteroid + "\n");
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        System.out.println(settler + "ctor\n");
        System.out.println(asteroid + "addSpaceShip " + settler + "\n");
        asteroid.addSpaceShip(settler);
        System.out.println(settler.getInventory() + "put(Iron)\n");
        settler.getInventory().put(Materials.IRON, 1);
        System.out.println(settler.getInventory() + "put(Coal)\n");
        settler.getInventory().put(Materials.COAL, 1);
        System.out.println(settler.getInventory() + "put(Uranium)\n");
        settler.getInventory().put(Materials.URANIUM, 1);
        System.out.println(settler + "buildRobot\n");
        settler.buildRobot();
    }

    /**
     * MoveSettler use case
     */
    public void usecaseMoveSettler() {
        System.out.println("8. Telepes mozgatása:");

        Asteroid asteroid1 = new Asteroid(3, false, null, 0);
        System.out.println(asteroid1 + "ctor\n");
        Asteroid asteroid2 = new Asteroid(3, false, null, 0);
        System.out.println(asteroid2 + "ctor\n");
        Settler settler = new Settler(asteroid1);
        System.out.println(settler + "ctor\n");
        System.out.println(asteroid1 + "addSpaceShip" + settler + "\n");
        asteroid1.addSpaceShip(settler);
        System.out.println(settler + "move" + asteroid2 + "\n");
        settler.move(asteroid2);
    }

    /**
     * DeployTeleport use case
     */
    public void usecaseDeployTeleport() {
        System.out.println("9. Teleportkapu lehelyezése:");
        Asteroid asteroid1 = new Asteroid(3, false, null, 0);
        System.out.println(asteroid1 + "ctor\n");
        Asteroid asteroid2 = new Asteroid(3, false, null, 0);
        System.out.println(asteroid2 + "ctor\n");
        Settler settler = new Settler(asteroid1);
        System.out.println(settler + "ctor\n");
        System.out.println(asteroid1 + "addSpaceShip " + settler + "\n");
        asteroid1.addSpaceShip(settler);
        System.out.println(settler.getInventory() + "put(IRON)\n");
        settler.getInventory().put(Materials.IRON, 2);
        System.out.println(settler.getInventory() + "put(WATERICE)\n");
        settler.getInventory().put(Materials.WATERICE, 1);
        System.out.println(settler.getInventory() + "put(Uranium)\n");
        settler.getInventory().put(Materials.URANIUM, 1);
        settler.buildTeleportPair();
        System.out.println(settler + "deployteleporrt" + asteroid1 + "\n");
        settler.deployTeleport(asteroid1);
        System.out.println(settler + "move" + asteroid2 + "\n");
        settler.move(asteroid2);
        System.out.println(settler + "deployteleporrt" + asteroid2 + "\n");
        settler.deployTeleport(asteroid2);
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
        asteroid.addSpaceShip(settler);
        System.out.println(settler.getInventory() + "put(IRON)\n");
        settler.getInventory().put(Materials.IRON, 2);
        System.out.println(settler.getInventory() + "put(WATERICE)\n");
        settler.getInventory().put(Materials.WATERICE, 1);
        System.out.println(settler.getInventory() + "put(URANIUM)\n");
        settler.getInventory().put(Materials.URANIUM, 1);
        System.out.println(settler + "buildTeleportPair\n");
        settler.buildTeleportPair();
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

        Asteroid asteroid = new Asteroid(3, false, null, 0);
        System.out.println(asteroid + " ctor\n");
        System.out.println(Game.getTheSun() + "addNeighbor" + asteroid + "\n");
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        System.out.println(settler + " ctor\n");
        System.out.println(asteroid + "addSpaceShip" + settler + "\n");
        asteroid.addSpaceShip(settler);
        try {
            System.out.println(settler + "drill\n");
            settler.drill();
            System.out.println(settler + "drill\n");
            settler.drill();
            System.out.println(settler + "drill\n");
            settler.drill();
        } catch (SurfaceThicknessIsZeroException e) {
            e.printStackTrace();
        } catch (NotEnoughMaterialException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(settler + "mine\n");
            settler.mine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(asteroid + "insertMaterial(IRON)\n");
            asteroid.insertMaterial(Materials.IRON);
            System.out.println(asteroid + "insertMaterial(IRON)\n");
            asteroid.insertMaterial(Materials.IRON);
            System.out.println(asteroid + "insertMaterial(IRON)\n");
            asteroid.insertMaterial(Materials.IRON);

            System.out.println(asteroid + "insertMaterial(WaterIce)\n");
            asteroid.insertMaterial(Materials.WATERICE);
            System.out.println(asteroid + "insertMaterial(WaterIce)\n");
            asteroid.insertMaterial(Materials.WATERICE);
            System.out.println(asteroid + "insertMaterial(WaterIce)\n");
            asteroid.insertMaterial(Materials.WATERICE);

            System.out.println(asteroid + "insertMaterial(Uranium)\n");
            asteroid.insertMaterial(Materials.URANIUM);
            System.out.println(asteroid + "insertMaterial(Uranium)\n");
            asteroid.insertMaterial(Materials.URANIUM);
            System.out.println(asteroid + "insertMaterial(Uranium)\n");
            asteroid.insertMaterial(Materials.URANIUM);

            System.out.println(asteroid + "insertMaterial(Coal)\n");
            asteroid.insertMaterial(Materials.COAL);
            System.out.println(asteroid + "insertMaterial(Coal)\n");
            asteroid.insertMaterial(Materials.COAL);
            System.out.println(asteroid + "insertMaterial(Coal)\n");
            asteroid.insertMaterial(Materials.COAL);
        } catch (AsteroidNotMinedException e) {
            e.printStackTrace();
        }
        System.out.println(settler + "buildbase\n");
        settler.buildBase();
    }
}