package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.materials.Coal;
import com.github.kozosjavak.asteroidmining.materials.Uranium;

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

        settler.Drill();
    }

    public void usecaseLoseGame() {

    }

    public void usecaseWinGame() {

    }

    public void usecaseMineMaterial() {
        Asteroid asteroid = new Asteroid(3, false, new Coal(), 0);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);

        settler.Mine();
    }

    public void usecaseInsertMaterial() {
        Asteroid asteroid = new Asteroid(3, false, null, 0);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);

        settler.insertMaterial();
        //nincs kész
    }

    public void usecaseDrillRadioactiveAsteroid() {
        Asteroid asteroid = new Asteroid(3, false, new Uranium(), 0);
        Settler settler = new Settler(asteroid);
        asteroid.addSpaceShip(settler);

        settler.Drill();
    }

    public void usecaseBuildRobot() {

    }

    public void usecaseMoveSettler() {
        Asteroid asteroid1 = new Asteroid(3, false, null, 0);
        Asteroid asteroid2 = new Asteroid(3, false, null, 0);
        Settler settler = new Settler(asteroid1);
        asteroid1.addSpaceShip(settler);

        settler.Move(asteroid2);
    }

    public void usecaseDeployTeleport() {
        Asteroid asteroid1 = new Asteroid(3, false, null, 0);
        Asteroid asteroid2 = new Asteroid(3, false, null, 0);
        Settler settler = new Settler(asteroid1);
        asteroid1.addSpaceShip(settler);

        settler.BuildTeleportPair(); //ezt hogy? vagy valahogy hozzá kell adni egy teleportpárt

        settler.DeployTeleport(asteroid1);
        settler.Move(asteroid2);
        settler.DeployTeleport(asteroid2);
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