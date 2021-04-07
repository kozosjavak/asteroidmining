package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.core.Steppable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Időzítő osztály
 */
public class Timer {

    /** Léptethető elemek listája a játékban */
    private final Collection<Steppable> steppables = new ArrayList<Steppable>();

    /**
     * Léptethető elem hozzáadása a listához
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
    public void tick() throws Exception {
        for (Steppable steppable : steppables) {
            steppable.step();
        }
    }
}
