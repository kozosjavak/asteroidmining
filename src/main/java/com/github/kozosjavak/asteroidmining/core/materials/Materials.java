package com.github.kozosjavak.asteroidmining.core.materials;

import com.github.kozosjavak.asteroidmining.core.materials.types.Coal;
import com.github.kozosjavak.asteroidmining.core.materials.types.Iron;
import com.github.kozosjavak.asteroidmining.core.materials.types.Uranium;
import com.github.kozosjavak.asteroidmining.core.materials.types.Waterice;

public class Materials {
    public static final Class<? extends Material> COAL = Coal.class;
    public static final Class<? extends Material> IRON = Iron.class;
    public static final Class<? extends Material> WATERICE = Waterice.class;
    public static final Class<? extends Material> URANIUM = Uranium.class;
}
