package classes;

import java.util.ArrayList;
import java.util.Collection;

public class BillOfBase implements BillOfMaterial {
    public Collection<Material> isNeeded(Collection<Material> m) {
        final Collection<Material> materials = new ArrayList<Material>();
        materials.add(new Iron());
        materials.add(new Iron());
        materials.add(new Iron());
        materials.add(new Waterice());
        materials.add(new Waterice());
        materials.add(new Waterice());
        materials.add(new Uranium());
        materials.add(new Uranium());
        materials.add(new Uranium());

        materials.removeAll(m);

        return materials;
    }
}
