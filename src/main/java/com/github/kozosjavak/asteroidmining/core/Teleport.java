package com.github.kozosjavak.asteroidmining.core;

/**
 * Teleport class
 */
public class Teleport implements Steppable {
    /**
     * If hit by solar storm it will be true
     */
    private boolean solarized = false;

    /**
     * Location where the teleport is
     */
    private Location location;
    /**
     * Pair of the teleport
     */
    private Teleport pair;

    /**
     * Basic constructor
     *
     * @param pair pair
     */
    public Teleport(Teleport pair) {
        location = null;
        this.pair = pair;
    }

    /**
     * Constructor with no given param
     */
    public Teleport() {
        location = null;
        this.pair = null;
    }

    /**
     * Implementation of getHitByExplosion(), it dies
     */
    public void getHitByExplosion() {
        if (getPair() != null) {
            getPair().location = null;
            getPair().pair = null;
        }
        this.location = null;
        pair = null;
    }

    /**
     * Gives back the location where the teleport is
     *
     * @return Location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the location of the teleport
     *
     * @param location Location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Returns of the pair of the teleport
     *
     * @return Teleport/null
     */
    public Teleport getPair() {
        return pair;
    }

    /**
     * Set the pair of the location
     *
     * @param pair Teleport
     */
    public void setPair(Teleport pair) {
        this.pair = pair;
    }

    /**
     * Deploy teleport to the location
     *
     * @param location Location
     */
    public void deployTeleport(Location location) {
        setLocation(location);
        location.setTeleport(this);
        //Teleport-deployteleport
    }

    /**
     * Redeploy teleport on a new location
     *
     * @param location
     */
    public void reDeployTeleport(Location location) {
        Location tempLocation = this.location;
        deployTeleport(location);
        tempLocation.setTeleport(null);
    }

    /**
     * Implementation of the experienceSolarStorm() it set solarized true
     */
    public void experienceSolarStorm(){
        solarized = true;
        try{
            step(); // TODO torold ki
        }catch (Exception e){
        }

    }

    /**
     * Implementation of the step(), if solarized the teleport will redeployed on a new neighbor location
     *
     * @throws Exception
     */
    public void step() throws Exception {
        if (solarized) { // TODO
            reDeployTeleport(getLocation().getRandomNeighborWithNoTeleport());
        }
    }

    /**
     * Return the teleport structure in string
     *
     * @param depth needed for the correct amount of /t before the data for correct write out
     * @param game  needed for give the ID of itself
     * @return String
     */
    public String toString(int depth, Game game) {
        String tab = "";
        for (int i = 0; i < depth; i++) tab += "\t";

        return tab + "Teleport {ID = " + game.getId(this) + ", PairID = " + game.getId(pair) + "}\n";
    }
}
