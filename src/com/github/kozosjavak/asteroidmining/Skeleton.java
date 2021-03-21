package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.materials.Materials;

public class Skeleton {


    public void runUsecase(String line) throws Exception {


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

    public void usecaseDrillAsteroid() {
        Asteroid asteroid = new Asteroid(3, false, null, 0);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);
        try {
            settler.drill();
        } catch (SurfaceThicknessIsZeroException e) {
            e.printStackTrace();
        }
    }

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

    public void usecaseWinGame() {

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
        }
        try {
            settler.mine();
        } catch (InventoryIsFullException e) {
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

    public void usecaseMineMaterial() {
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, false, Materials.WATERICE, 0);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);

        try {
            settler.mine();
        } catch (InventoryIsFullException e) {
            e.printStackTrace();
        }

        try {
            settler.drill();
        } catch (SurfaceThicknessIsZeroException e) {
            e.printStackTrace();
        }

        try {
            settler.mine();
        } catch (InventoryIsFullException e) {
            e.printStackTrace();
        }


    }

    public void usecaseInsertMaterial() {
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, false, Materials.WATERICE, 0);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);

        try {
            settler.mine();
        } catch (InventoryIsFullException e) {
            e.printStackTrace();
        }

        try {
            settler.drill();
        } catch (SurfaceThicknessIsZeroException e) {
            e.printStackTrace();
        }

        try {
            settler.mine();
        } catch (InventoryIsFullException e) {
            e.printStackTrace();
        }

        try {
            settler.insertMaterial(Materials.IRON);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void usecaseDrillRadioactiveAsteroid() {
        Game.startGame();

        Asteroid asteroid = new Asteroid(1, true, Materials.URANIUM, 0);
        Game.getTheSun().addNeighbor(asteroid);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);
    }

    public void usecaseBuildRobot() {

    }

    public void usecaseMoveSettler() {
        Asteroid asteroid1 = new Asteroid(3, false, null, 0);
        Asteroid asteroid2 = new Asteroid(3, false, null, 0);
        Settler settler = new Settler(asteroid1);
        asteroid1.addSpaceShip(settler);

        settler.move(asteroid2);
    }

    public void usecaseDeployTeleport() {
        Asteroid asteroid1 = new Asteroid(3, false, null, 0);
        Asteroid asteroid2 = new Asteroid(3, false, null, 0);
        Settler settler = new Settler(asteroid1);
        asteroid1.addSpaceShip(settler);

        settler.buildTeleportPair(); //ezt hogy? vagy valahogy hozzá kell adni egy teleportpárt

        settler.deployTeleport(asteroid1);
        settler.move(asteroid2);
        settler.deployTeleport(asteroid2);
    }

    public void usecaseBuildTeleport() {

    }

    public void usecaseRemoveMaterial() {
        Asteroid asteroid = new Asteroid(3, false, null, 0);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);
        asteroid.insertMaterial();

        settler.removeMaterial();
        //nincs kész
    }

    public void usecaseBuildBase() {

    }
}