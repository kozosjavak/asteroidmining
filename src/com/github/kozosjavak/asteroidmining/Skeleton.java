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
        int num = 0;
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
        Asteroid asteroid = new Asteroid(3, false, null, 0);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);
        try {
            try {
                settler.drill();
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
        Game.startGame();

        Asteroid asteroid = new Asteroid(3, false, null, 0);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);
        Game.endGame();
        settler.die();
        Game.endGame();
    }

    /**
     * WinGame use case
     */
    public void usecaseWinGame() {

        Game.startGame();

        Asteroid asteroid = new Asteroid(3, false, Materials.COAL, 0);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);
        try {
            settler.drill();
            settler.drill();
            settler.drill();
        } catch (SurfaceThicknessIsZeroException | NotEnoughMaterialException e) {
            e.printStackTrace();
        }
        try {
            settler.mine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            asteroid.insertMaterial(Materials.IRON);
            asteroid.insertMaterial(Materials.IRON);
            asteroid.insertMaterial(Materials.IRON);

            asteroid.insertMaterial(Materials.WATERICE);
            asteroid.insertMaterial(Materials.WATERICE);
            asteroid.insertMaterial(Materials.WATERICE);

            asteroid.insertMaterial(Materials.URANIUM);
            asteroid.insertMaterial(Materials.URANIUM);
            asteroid.insertMaterial(Materials.URANIUM);

            asteroid.insertMaterial(Materials.COAL);
            asteroid.insertMaterial(Materials.COAL);
            asteroid.insertMaterial(Materials.COAL);
        } catch (AsteroidNotMinedException e) {
            e.printStackTrace();
        }
        settler.buildBase();

    }

    /**
     * MineMaterial use case
     */
    public void usecaseMineMaterial() {
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, false, Materials.WATERICE, 0);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);


        try {
            settler.mine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            settler.drill();
        } catch (SurfaceThicknessIsZeroException | NotEnoughMaterialException e) {
            e.printStackTrace();
        }

        try {
            settler.mine();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * InsertMaterial use case
     */
    public void usecaseInsertMaterial() {
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, false, Materials.IRON, 0);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);
        settler.getInventory().put(Materials.COAL, 1);


        try {
            settler.drill();
        } catch (SurfaceThicknessIsZeroException | NotEnoughMaterialException e) {
            e.printStackTrace();
        }

        try {
            settler.mine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            settler.insertMaterial(Materials.IRON);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * DrillRadioactiveAsteroid use case
     */
    public void usecaseDrillRadioactiveAsteroid() {
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, true, Materials.URANIUM, 0);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);
        try {
            settler.drill();
        } catch (SurfaceThicknessIsZeroException | NotEnoughMaterialException e) {
            e.printStackTrace();
        }

    }

    /**
     * BuildRobot use case
     */
    public void usecaseBuildRobot() {
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, false, null, 0);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);
        settler.getInventory().put(Materials.IRON, 1);
        settler.getInventory().put(Materials.COAL, 1);
        settler.getInventory().put(Materials.URANIUM, 1);
        settler.buildRobot();
    }

    /**
     * MoveSettler use case
     */
    public void usecaseMoveSettler() {
        Asteroid asteroid1 = new Asteroid(3, false, null, 0);
        Asteroid asteroid2 = new Asteroid(3, false, null, 0);
        Settler settler = new Settler(asteroid1);
        asteroid1.addSpaceShip(settler);
        settler.move(asteroid2);
    }

    /**
     * DeployTeleport use case
     */
    public void usecaseDeployTeleport() {
        Asteroid asteroid1 = new Asteroid(3, false, null, 0);
        Asteroid asteroid2 = new Asteroid(3, false, null, 0);
        Settler settler = new Settler(asteroid1);
        asteroid1.addSpaceShip(settler);
        settler.getInventory().put(Materials.IRON, 2);
        settler.getInventory().put(Materials.WATERICE, 1);
        settler.getInventory().put(Materials.URANIUM, 1);
        settler.buildTeleportPair();

        settler.deployTeleport(asteroid1);
        settler.move(asteroid2);
        settler.deployTeleport(asteroid2);
    }

    /**
     * BuildTeleport use case
     */
    public void usecaseBuildTeleport() {
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, false, null, 0);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);
        settler.getInventory().put(Materials.IRON, 2);
        settler.getInventory().put(Materials.WATERICE, 1);
        settler.getInventory().put(Materials.URANIUM, 1);
        settler.buildTeleportPair();
    }

    /**
     * RemoveMaterial use case
     */
    public void usecaseRemoveMaterial() {
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, false, null, 0);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);
        try {
            asteroid.insertMaterial(Materials.COAL);
        } catch (AsteroidNotMinedException e) {
            e.printStackTrace();
        }
        try {
            asteroid.removeMaterial(Materials.COAL);
        } catch (NotEnoughMaterialException e) {
            e.printStackTrace();
        }

    }

    /**
     * BuildBase use case
     */
    public void usecaseBuildBase() {
        Game.startGame();

        Asteroid asteroid = new Asteroid(3, false, null, 0);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);
        try {
            settler.drill();
            settler.drill();
            settler.drill();
        } catch (SurfaceThicknessIsZeroException e) {
            e.printStackTrace();
        } catch (NotEnoughMaterialException e) {
            e.printStackTrace();
        }
        try {
            settler.mine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            asteroid.insertMaterial(Materials.IRON);
            asteroid.insertMaterial(Materials.IRON);
            asteroid.insertMaterial(Materials.IRON);

            asteroid.insertMaterial(Materials.WATERICE);
            asteroid.insertMaterial(Materials.WATERICE);
            asteroid.insertMaterial(Materials.WATERICE);

            asteroid.insertMaterial(Materials.URANIUM);
            asteroid.insertMaterial(Materials.URANIUM);
            asteroid.insertMaterial(Materials.URANIUM);

            asteroid.insertMaterial(Materials.COAL);
            asteroid.insertMaterial(Materials.COAL);
            asteroid.insertMaterial(Materials.COAL);
        } catch (AsteroidNotMinedException e) {
            e.printStackTrace();
        }
        settler.buildBase();
    }
}