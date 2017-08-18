package egen.service;


import egen.entity.Readings;
import egen.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VehicleService {


    List<Vehicle> finaAll();

    Vehicle findOne(String id);

    Vehicle create(Vehicle veh);

    Vehicle update(Vehicle veh);

    void delete(String id);
}
