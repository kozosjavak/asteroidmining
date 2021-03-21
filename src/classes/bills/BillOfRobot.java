package classes.bills;

import classes.materials.Material;
import classes.materials.Materials;

import java.util.Map;

public class BillOfRobot implements BillOfMaterial {

    @Override
    public Map<Material, Integer> getMaterialsNeeded() {
        return Map.of(Materials.IRON, 1, Materials.COAL, 1, Materials.URANIUM, 1);
    }
}