package classes;

import java.util.Collection;

public class Settler extends Spaceship implements Steppable{
    Collection<Bills> bills = new Collection<Bills>();
    Collection<Material> carriedMaterial = new Collection<Material>();
    private TeleportPair teleportpair;

    public Material GetCarriedMaterial(){
        return carriedMaterial.get(0);
    }
    public void GetHitByExplosion(){};
    public void Drill(){};
    public void Mine(){};
    public String GetType(){
        return "Settler";
    }
    public void BuildTeleportPair(){};
    public void BuildBase(){};
    public void BuildRobot(){};
    public void Step(){};
    public void Die(){};
    public void InsertMaterial(Material material){};
    public void RemoveMaterial(Material material){};
    public void DeployTeleport(Asteroid asteroid){};
    public void ExperienceSolarStorm(){};

    @Override
    public void step() {

    }
}

