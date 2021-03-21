package com.github.kozosjavak.asteroidmining;

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
            usecaseInserMaterial();
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
        } else {
            throw new Exception("Nem megfelelő számot adott meg!");
        }
    }

    public void usecaseDrillAsteroid() {

    }

    public void usecaseLoseGame() {

    }

    public void usecaseWinGame() {

    }

    public void usecaseMineMaterial() {

    }

    public void usecaseInserMaterial() {

    }

    public void usecaseDrillRadioactiveAsteroid() {

    }

    public void usecaseBuildRobot() {

    }

    public void usecaseMoveSettler() {

    }

    public void usecaseDeployTeleport() {

    }

    public void usecaseBuildTeleport() {

    }

    public void usecaseRemoveMaterial() {

    }

    public void usecaseBuildBase() {

    }
}