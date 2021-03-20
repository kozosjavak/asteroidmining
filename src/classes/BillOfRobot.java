package classes;

import java.util.ArrayList;
import java.util.Collection;

public class BillOfRobot implements BillOfMaterial {
    public Collection<Material> isNeeded(Collection<Material> m) {
        final Collection<Material> materials = new ArrayList<Material>();
        materials.add(new Iron());
        materials.add(new Coal());
        materials.add(new Uranium());

        materials.removeAll(m);

        return materials;
    }
}