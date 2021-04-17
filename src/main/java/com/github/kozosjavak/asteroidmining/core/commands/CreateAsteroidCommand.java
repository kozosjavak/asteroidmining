package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Asteroid;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.Location;
import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;


//Itt mar a command listaba mentett command Objektum (fontos kiemelni hogy ez mar egy letezo objektum sajat adatokkal amit megadott neki az adapter)
public class CreateAsteroidCommand implements Command {
    private final int surfaceThickness;
    private final int substanceID;

    //csinalunk egy construktort a commandhoz amit az adapter szepen kitolt
    public CreateAsteroidCommand(int surfaceThickness, int subsctanceID) {
        this.surfaceThickness = surfaceThickness;
        this.substanceID = subsctanceID;
    }

    //Itt fut le a command! Vegig megy a command listan es mindegyiken lefuttatja az apply-t, fontos kiemelni hogy ez mar effektiven a jatekon valtoztat ez a vegcel
    @Override
    public void apply(Game game) {
        Location loc = new Location(game, 0.0, 0.0);

        //Itt kene az id listan atmenni es leelenorizni hogy az substance-e es ha igen berakni ide: Most a pelda miatt egy sima coalt rakok be de erre figyleni kell
        Asteroid asteroid = new Asteroid(loc, surfaceThickness, false, new Coal()/*Itt kene az idban meghatarozott Subtance Objektumor berakni*/, 0);
        //es legvegso soron hozzadjuk az uj lokaciot az uj aszteroidaval egyetembe a jatekhoz
        game.addLocation(loc);
    }
}
