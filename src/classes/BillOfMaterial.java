package classes;

import java.util.Collection;

public interface BillOfMaterial {
    Collection<Material> isNeeded(Collection<Material> m);
}
