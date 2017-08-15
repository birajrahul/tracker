package egen.repository;


import egen.entity.Readings;
import egen.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    List<Vehicle> finaAll();

    Vehicle findByVin(String vin);
    Vehicle create(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    void delete(Vehicle vehicle);
}
