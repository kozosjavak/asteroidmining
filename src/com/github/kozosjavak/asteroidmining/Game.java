package com.github.kozosjavak.asteroidmining;

public class Game {


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

    public static void startGame() {
        theSun = new Sun(numberOfChildren);
    }

    public static void Win() {
        System.out.println("Win, Congrat commrad!");
        theSun = null;
        System.gc();
    }

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
