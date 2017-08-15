package egen.repository;


import egen.entity.Readings;
import egen.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryimpl implements VehicleRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public List<Vehicle> finaAll() {

        TypedQuery<Vehicle> query=entityManager.createNamedQuery("Vehicle.findAll",Vehicle.class);

        return query.getResultList();
    }


    public Vehicle findByVin(String vin) {
        TypedQuery<Vehicle> query=entityManager.createNamedQuery("Vehicle.findByVin",Vehicle.class);

        query.setParameter("paramvin",vin);
         List<Vehicle> resultList = query.getResultList();
        if (resultList != null && resultList.size()==1){
            return resultList.get(0);
        }
        else
        return null;
    }


    public Vehicle create(Vehicle veh) {

        entityManager.persist(veh);
        return veh;
    }


    public Vehicle update(Vehicle veh) {

        return entityManager.merge(veh);

    }


    public void delete(Vehicle veh) {

        entityManager.remove(veh);
    }
}
