package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Location {
    List<Location> neighbors = new ArrayList<Location>();
    Random random = new Random();

    public Location GetRandomNeighbor (Location location){
        return neighbors.get(random.nextInt(neighbors.size()-1));
    }
    public List<Location> GetNeighbors(){
        return neighbors;
    }
    public void AddNeighbor(Location location){
        neighbors.add(location);
    }
    public void RemoveNeighbor(Location location){
        neighbors.remove(location);
    }
    public void AddChildern(int depth){
        //Underconstraction
    }

}
