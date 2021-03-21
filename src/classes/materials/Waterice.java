package classes.materials;

import classes.Asteroid;

public class Waterice implements Material {
    public void ExperienceExtremeHeat(Asteroid a) {
        a.RemoveSubstance(); // sublimates
    }
}
