package de.reuters.ejb.dao;

import de.reuters.ejb.entity.Service;
import javax.ejb.Local;
import java.util.List;

/**
 * Created by annpo on 02.05.2016.
 */

@Local
public interface ServiceDao {

    void fuegeServiceHinzu(Service service);

    void aktualisierService(Service service);

    void entfernService(Service service);

    List<Service> liesServices(List<String> kundeServices);
}
