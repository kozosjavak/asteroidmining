package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.console.ConsoleCommandExecutor;
import com.github.kozosjavak.asteroidmining.core.Game;

import java.util.Map;

/**
 * Főprogram
 */
public class Main {

    /**
     * Belépési pont
     * @param args az argumentumok
     */
    public static void main(String[] args) {
        Game game = new Game();
        ConsoleCommandExecutor cce = new ConsoleCommandExecutor(game);
        cce.attachToConsole();


        // Skeleton inicializálása
        /*Skeleton skeleton = new Skeleton();
        skeleton.fillMap(12);
        Map<Integer, Integer> useCaseUsageCounter = skeleton.getUseCaseUsageCounter();


        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            while (true) {
                try {
                    printOptions(useCaseUsageCounter);
                    String line = br.readLine();
                    if (line == null) break;
                    skeleton.runUsecase(line);


                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println();
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }


    /**
     * Menü megjelenítése
     */
    public static void printOptions(Map<Integer, Integer> useCaseUsageCounter) {
        System.out.println("Menü:");
        System.out.println("Sorszám->\tProbak szama->\tUse-case neve");
        System.out.println("1.\t" + useCaseUsageCounter.get(0) + "\tAszteroida fúrása");
        System.out.println("2.\t" + useCaseUsageCounter.get(1) + "\tJáték elvesztése");
        System.out.println("3.\t" + useCaseUsageCounter.get(2) + "\tJáték megnyerése");
        System.out.println("4.\t" + useCaseUsageCounter.get(3) + "\tNyersanyag bányászása");
        System.out.println("5.\t" + useCaseUsageCounter.get(4) + "\tNyersanyag visszahelyezése");
        System.out.println("6.\t" + useCaseUsageCounter.get(5) + "\tRadioaktív aszteroida fúrás");
        System.out.println("7.\t" + useCaseUsageCounter.get(6) + "\tRobot építés");
        System.out.println("8.\t" + useCaseUsageCounter.get(7) + "\tTelepes mozgatása");
        System.out.println("9.\t" + useCaseUsageCounter.get(8) + "\tTeleportkapu lehelyezése");
        System.out.println("10.\t" + useCaseUsageCounter.get(9) + "\tTeleportkapu-pár építése");
        System.out.println("11.\t" + useCaseUsageCounter.get(10) + "\tÜreges aszteroidából nyersanyag felvétel");
        System.out.println("12.\t" + useCaseUsageCounter.get(11) + "\tŰrbázis építése");
        System.out.println("0.\tKilépés");
        System.out.print("Melyik use-case-t szeretné futtatni? Adjon meg egy számot: ");
    }

}