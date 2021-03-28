package com.github.kozosjavak.asteroidmining.core.materials;

/** Tele levő inventory kivétel */
public class InventoryIsFullException extends Exception {
    public InventoryIsFullException() {
        super("Inventory is full!");
    }
}
