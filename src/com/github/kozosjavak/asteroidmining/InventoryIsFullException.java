package com.github.kozosjavak.asteroidmining;

/** Tele levő inventory kivétel */
public class InventoryIsFullException extends Exception {
    public InventoryIsFullException() {
        super("Inventory is full!");
    }
}
