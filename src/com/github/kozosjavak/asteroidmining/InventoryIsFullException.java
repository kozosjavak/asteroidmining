package com.github.kozosjavak.asteroidmining;

public class InventoryIsFullException extends Exception {
    public InventoryIsFullException() {
        super("Inventory is full!");
    }
}
