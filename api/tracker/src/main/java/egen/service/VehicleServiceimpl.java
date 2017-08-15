package egen.service;


import egen.entity.Readings;
import egen.entity.Vehicle;
import egen.exception.BadRequestException;
import egen.exception.ResourceNotFoundException;
import egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Service has the responsibilty of esxception handling

@Service
public class VehicleServiceimpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicle> finaAll() {
        return repository.finaAll();
    }

    @Transactional(readOnly = true)
    public Vehicle findOne(String id) {
        Vehicle existing= repository.findByVin(id);
        if(existing==null){
            // exception handling 404
            throw new ResourceNotFoundException("Vehicle with "+id + " doesn't exist");
        }
        return existing;
    }

    @Transactional
    public Vehicle create(Vehicle vehicle) {

        Vehicle existing = repository.findByVin(vehicle.getVin());
        if (existing != null) {
//            // esception handling 400 Bad request
//            throw new BadRequestException("Vehicle with " + veh.getVin() + " already exists");
                return this.update(vehicle);

        }
        return repository.create(vehicle);

    }

    @Transactional
    public Vehicle update(Vehicle vehicle) {

        return repository.update(vehicle);
    }



    @Transactional
    public void delete(String vin) {
        Vehicle existing= repository.findByVin(vin);
        if(existing==null){
            // exception handling 404
            throw new ResourceNotFoundException("Vehicle with "+vin + " doesn't exist");

        }
        repository.delete(existing);

    }
}
