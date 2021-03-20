package classes;

public class Robot extends Spaceship implements Steppable{

    public void ExperienceSolarStorm(){};
    public void GetHitByExplosion(){};
    public void Drill(){};
    public String GetType(){
        return "robot";
    }
    @Override
    public void step() {

    }
}
