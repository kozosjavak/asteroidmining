package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.materials.Inventory;
import com.github.kozosjavak.asteroidmining.core.materials.Material;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.core.materials.types.Waterice;

public class ResourceTable {
    private final BitmapFont font;
    private final SpriteBatch batch;
    private final int[] settlerMaterials;
    private final int[] asteroidMaterials;
    String settlerText;
    String asteroidText;
    int teleportCount;


    public ResourceTable(SpriteBatch batch) {
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        this.batch = batch;
        settlerMaterials = new int[4];
        asteroidMaterials = new int[4];
        settlerMaterials[0] = 0;
        settlerMaterials[1] = 0;
        settlerMaterials[2] = 0;
        settlerMaterials[3] = 0;
        asteroidMaterials[0] = 0;
        asteroidMaterials[1] = 0;
        asteroidMaterials[2] = 0;
        asteroidMaterials[3] = 0;
        teleportCount = 0;
        settlerText = "Coal: " + settlerMaterials[0] + "\n" + "Iron: " + settlerMaterials[1] + "\n" + "Uranium: " + settlerMaterials[2] + "\n" + "Waterice: " + settlerMaterials[3] + "\n" + "Teleports: " + teleportCount;
        asteroidText = "Coal: " + asteroidMaterials[0] + "\n" + "Iron: " + asteroidMaterials[1] + "\n" + "Uranium: " + asteroidMaterials[2] + "\n" + "Waterice: " + asteroidMaterials[3];
    }

    public void draw() {

        font.draw(batch, "Settler Inventory\n" + settlerText, 820, 360);
        font.draw(batch, "Asteroid Inventory\n" + asteroidText, 820, 250);

    }

    public void setInventory(Inventory asteroidInventory, Settler settler) {

        if (settler.getInventory() != null) {
            settlerMaterials[0] = 0;
            settlerMaterials[1] = 0;
            settlerMaterials[2] = 0;
            settlerMaterials[3] = 0;
            asteroidMaterials[0] = 0;
            asteroidMaterials[1] = 0;
            asteroidMaterials[2] = 0;
            asteroidMaterials[3] = 0;
            for (Material material : settler.getInventory().getList()) {
                if (material.getClass() == Coal.class) {
                    settlerMaterials[0]++;
                } else if (material.getClass() == Iron.class) {
                    settlerMaterials[1]++;
                } else if (material.getClass() == Uranium.class) {
                    settlerMaterials[2]++;
                } else if (material.getClass() == Waterice.class) {
                    settlerMaterials[3]++;
                }
            }
            for (Material material : asteroidInventory.getList()) {
                if (material.getClass() == Coal.class) {
                    asteroidMaterials[0]++;
                } else if (material.getClass() == Iron.class) {
                    asteroidMaterials[1]++;
                } else if (material.getClass() == Uranium.class) {
                    asteroidMaterials[2]++;
                } else if (material.getClass() == Waterice.class) {
                    asteroidMaterials[3]++;
                }
            }
        }
        teleportCount = 0;
        for (int i = 0; i < settler.getTeleportInventory().length; i++) {
            if (settler.getTeleportInventory()[i] != null) {
                teleportCount++;
            }
        }
        settlerText = "Coal: " + settlerMaterials[0] + "\n" + "Iron: " + settlerMaterials[1] + "\n" + "Uranium: " + settlerMaterials[2] + "\n" + "Waterice: " + settlerMaterials[3] + "\n" + "Teleports: " + teleportCount;
        asteroidText = "Coal: " + asteroidMaterials[0] + "\n" + "Iron: " + asteroidMaterials[1] + "\n" + "Uranium: " + asteroidMaterials[2] + "\n" + "Waterice: " + asteroidMaterials[3];
    }
}
