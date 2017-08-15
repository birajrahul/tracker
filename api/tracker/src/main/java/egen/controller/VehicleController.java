package egen.controller;


import egen.entity.Readings;
import egen.entity.Vehicle;
import egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


// Vehicle Controller to do CRUD operations
// Responsebody for putting data in body since its rest api can be written to each method or to a class as an whole
// RequestMapping for each method to recognize each url
// spring ll put automatically puts slashes //
//Controller is a component
// instead of using @controller and @responseBody seperately we can use @RestController
// path and value are one and the same

//Controller has the responsibilty of mapping

@CrossOrigin(origins = "http://mocker.egen.io")
@RestController
@RequestMapping() // common for all method if extra it ll append it
public class VehicleController {

    @Autowired
    VehicleService service;

    // Consumes and produces are not required for latest update of spring
    @RequestMapping(method = RequestMethod.GET,value = "vehicles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public List<Vehicle> findAll(){

        return service.finaAll();
    }

    @RequestMapping(method = RequestMethod.GET,value = "{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    // path variable for converting the link id to String
    public Vehicle findOne(@PathVariable("vin") String vin){
        return service.findOne(vin);
    }

    // Consumes not required for latest update of spring
    @RequestMapping(method = RequestMethod.PUT, value = "vehicles", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> loadVehicleDetails(@RequestBody List<Vehicle> vehicles){ //Request body to convert json to java from the body

        List<Vehicle> updatedVehicles = new ArrayList<Vehicle>();

        for (Vehicle vehicle : vehicles) {
             updatedVehicles.add(service.create(vehicle));
        }
        return updatedVehicles;
    }


    @RequestMapping(method = RequestMethod.POST, value = "readings", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void loadVehicleReadings(@RequestBody Readings readings){ //Request body to convert json to java from the body
        Vehicle vehicle = service.findOne(readings.getVin());
        if(vehicle != null){
            //readings.setId(vehicle.getReadings().getId());
            vehicle.setReadings(readings);
            service.update(vehicle);
        }
        else
            System.out.println("Vehicle with vin "+readings.getVin()+ "not found");

    }


    @RequestMapping(method = RequestMethod.DELETE,value = "{vin}")

    public void delete(@PathVariable("vin") String vin){

        service.delete(vin);
    }

}
