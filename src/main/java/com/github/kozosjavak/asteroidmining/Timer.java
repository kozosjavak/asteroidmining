package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.core.Steppable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Időzítő osztály
 */
public class Timer implements Runnable {

    private static final int TARGET_FPS = 60;
    private static final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
    /**
     * Léptethető elemek listája a játékban
     */
    private final Collection<Steppable> steppables = new ArrayList<>();
    private Thread thread;
    private boolean isRunning = false;

    /**
     * Léptethető elem hozzáadása a listához
     *
     * @param steppable a hozzáadandó elem
     */
    public void addSteppable(Steppable steppable) {
        steppables.add(steppable);
    }

    /**
     * Léptethető elem eltávolítása a listából
     * @param steppable az eltávolítandó elem
     */
    public void removeSteppable(Steppable steppable) {
        steppables.remove(steppable);
    }

    /**
     * Léptethető elemek léptetése
     */
    public void tick() {
        for (Steppable steppable : steppables) {
            steppable.step();
        }
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            isRunning = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long now;
        long elapsedTime;
        long wait;
        while (isRunning) {
            now = System.nanoTime();

            tick();
            //pain();

            elapsedTime = System.nanoTime() - now;
            wait = (OPTIMAL_TIME - elapsedTime) / 1000000;

            try {
                if (wait < 0) wait = 0;
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
