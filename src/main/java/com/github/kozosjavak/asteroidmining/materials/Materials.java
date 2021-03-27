package com.github.kozosjavak.asteroidmining.materials;

import com.github.kozosjavak.asteroidmining.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.materials.types.Waterice;

public class Materials {
    public static final Class<? extends Material> COAL = Coal.class;
    public static final Class<? extends Material> IRON = Iron.class;
    public static final Class<? extends Material> WATERICE = Waterice.class;
    public static final Class<? extends Material> URANIUM = Uranium.class;
}
