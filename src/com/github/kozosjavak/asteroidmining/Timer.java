package com.github.kozosjavak.asteroidmining;

import java.util.ArrayList;
import java.util.Collection;

public class Timer {
    private final Collection<Steppable> steppables = new ArrayList<Steppable>();

    public void addSteppable(Steppable steppable) {
        steppables.add(steppable);
    }

    public void removeSteppable(Steppable steppable) {
        steppables.remove(steppable);
    }

    public void tick() {
        for (Steppable steppable : steppables) {
            steppable.step();
        }
    }
}
