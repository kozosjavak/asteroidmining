package com.github.kozosjavak.asteroidmining.core;

/**
 * Interface for explode, it need to be implemented by all class which interact with explosions
 */
public interface Explodeable {
    /**
     * Basic explosion
     *
     * @throws Exception
     */
    void explode() throws Exception;

    /**
     * Remove substance
     */
    void removeSubstance();
}
