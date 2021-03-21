package com.github.kozosjavak.asteroidmining;

import com.github.kozosjavak.asteroidmining.materials.Material;

import java.util.ArrayList;
import java.util.List;

public class Asteroid extends Orb {

    private final boolean inSunZone;
    private final int numberOfChildren;
    private final List<Material> materials = new ArrayList<>();
    private final List<Spaceship> residence = new ArrayList<>();
    private int surfaceThickness;
    private Material substance;

    public Asteroid(int surfaceThickness, boolean inSunZone, Material substance, int numberOfChildren) {
        this.surfaceThickness = surfaceThickness;
        this.inSunZone = inSunZone;
        this.substance = substance;
        this.numberOfChildren = numberOfChildren;
    }

    public void addSpaceShip(Spaceship spaceShip) {
        residence.add(spaceShip);
    }

    public void removeSpaceship(Spaceship spaceShip) {
        residence.remove(spaceShip);
    }

    public Material mine() {
        if (surfaceThickness == 0 && substance != null) {
            Material temp = substance;
            substance = null;
            return temp;
        } else {
            return null;
        }
    }

    public void drill() {
        if (surfaceThickness > 0)
            surfaceThickness--;
    }

    public void Explode() {
        //kesobb
    }

    public void insertMaterial(Material material) {
        materials.add(material);
    }

    public void removeMaterial(Material material) {
        materials.remove(material);
    }

    public void buildBase() {
        //kesobb
    }

    @Override
    public void ExperienceSolarStrom() {
        super.ExperienceSolarStrom();
    }

    @Override
    public String GetType() {
        return "Asteroid";
    }
}
