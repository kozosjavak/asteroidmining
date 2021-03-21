package classes.bills;

import classes.materials.Material;
import classes.materials.Materials;

import java.util.Map;

public class BillOfTeleport implements BillOfMaterial {

    @Override
    public Map<Material, Integer> getMaterialsNeeded() {
        return Map.of(Materials.IRON, 2, Materials.WATERICE, 1, Materials.URANIUM, 1);
    }
}