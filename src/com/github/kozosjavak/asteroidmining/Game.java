package com.github.kozosjavak.asteroidmining;

/**
 * Játék osztály
 */
public class Game {



    /** A játékban levő nap inicializálása */
    private static Sun theSun;
    private static int numberOfSettlers = 0;
    private static int numberOfChildren;


    public static Sun getTheSun() {
        return theSun;
    }

    public static int getNumberOfChildren() {
        return numberOfChildren;
    }

    public static void setNumberOfChildren(int numberOfChildren) {
        Game.numberOfChildren = numberOfChildren;
    }


    public static void setNumberOfSettlers(int numberOfSetlers) {
        numberOfSettlers = numberOfSetlers;
    }

    public static void addASettlerInNumberOfSettler() {
        numberOfSettlers++;
    }

    public static void removeASettlerInNumberOfSettler() {
        numberOfSettlers--;
    }


    public static void removeSettler() {
        numberOfSettlers--;
    }

    /** A játékban levő telepesek száma */
    private static int numberOfSettlers;

    /** Játék indítása */
    public static void startGame() {
        theSun = new Sun(numberOfChildren);
    }

    public static void Win() {
        System.out.println("Win, Congrat commrad!");
        theSun = null;
        System.gc();
    }

    /** Játék állapotának ellenőrzése. Ha teljesül a játék végét jelentő feltétel akkor végetér a játék. */
    public static void endGame() {
        if (numberOfSettlers == 0) {
            System.out.println("Loose");
            theSun = null;
            System.gc();
        } else {
            System.out.println("Game hasn't ended yet.");
        }
    }

}
