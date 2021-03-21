package classes.materials;

import classes.Asteroid;

public class Uranium implements Material {
    public void ExperienceExtremeHeat(Asteroid a) {
        a.Explode(); // explodes
    }
}