package egen.repository;


import egen.entity.Readings;
import egen.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface VehicleRepository {
    List<Vehicle> finaAll();

    Vehicle findByVin(String vin);
    Vehicle create(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    void delete(Vehicle vehicle);
}
