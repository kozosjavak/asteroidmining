package com.github.kozosjavak.asteroidmining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Főprogram
 */
public class Main {

    /**
     * Belépési pont
     * @param args az argumentumok
     */
    public static void main(String[] args) {

        // Skeleton inicializálása
        Skeleton skeleton = new Skeleton();

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            while (true) {
                try {
                    printOptions();
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
    }

    /**
     * Menü megjelenítése
     */
    public static void printOptions() {
        System.out.println("Menü:");
        System.out.println("1. Aszteroida fúrása");
        System.out.println("2. Játék elvesztése");
        System.out.println("3. Játék megnyerése");
        System.out.println("4. Nyersanyag bányászása");
        System.out.println("5. Nyersanyag visszahelyezése");
        System.out.println("6. Radioaktív aszteroida fúrás");
        System.out.println("7. Robot építés");
        System.out.println("8. Telepes mozgatása");
        System.out.println("9. Teleportkapu lehelyezése");
        System.out.println("10. Teleportkapu-pár építése");
        System.out.println("11. Üreges aszteroidából nyersanyag felvétel");
        System.out.println("12. Űrbázis építése");
        System.out.println("0. Kilépés");
        System.out.print("Melyik use-case-t szeretné futtatni? Adjon meg egy számot: ");
    }
}