package com.github.kozosjavak.asteroidmining;

import java.util.ArrayList;
import java.util.List;

public class Settler extends Spaceship implements Steppable {
    private final List<Material> carriedMaterials = new ArrayList<>();
    Collection<Bills> bills = new ArrayList<Bills>();
    private TeleportPair teleportPair;

    public Material GetCarriedMaterial() {
        return carriedMaterials.get(0);
    }

    public void Mine() {
        if (carriedMaterials.size() < 10) {
            //    carriedMaterials.add(Asteroid::mine());
        }
    }

    public void BuildTeleportPair() {
        //kettő cuccot keresni arraylistben nem vágom potosan hogy kell
        //lényeg így nézem meg hint alapján, hogy van-e 2 vas:
      /*  Iterator<Material> it = carriedMaterials.iterator();
        int waterCounter=0;
        while(it.hasNext()){
            if(it.next().equals(Iron)){
                waterCounter=waterCounter+1;
            }
        }
        it.remove();
        if(teleportPair==null&&waterCounter>=2&&
                carriedMaterials.contains(Uranium)&&
                carriedMaterials.contains("Waterice")
        ){
        //add teleport pair
            carriedMaterials.remove("Uranium");
            carriedMaterials.remove("Waterice");
            carriedMaterials.remove("Iron");
            carriedMaterials.remove("Iron");
        }*/
    }

    public void BuildBase() {
    }

    public void BuildRobot() {

    }

    public void InsertMaterial(Material material) {
     /*   Asteroid::insertMaterial(material);
        RemoveMaterial(material);*/
    }

    public void RemoveMaterial(Material material) {
        carriedMaterials.remove(material);
    }

    public void DeployTeleport(Asteroid asteroid) {
    }

    @Override
    public void Die() {
        //SetnumOfSettler(numOfSettler-1);
    }

    @Override
    public void GetHitByExplosion() {
    }

    @Override
    public void Drill() {
    }

    @Override
    public void ExperienceSolarStorm() {
    }

    @Override
    public String GetType() {
        return "Settler";
    }

    @Override
    public void step() {

    }
}

