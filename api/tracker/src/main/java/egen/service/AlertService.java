package egen.service;


import egen.Priority;
import egen.entity.Alert;
import egen.entity.Readings;
import egen.entity.Tires;
import egen.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AlertService {


    List<Alert> generateAlerts(Vehicle vehicle, Readings readings);

    void ruleEngineRpm(Vehicle vehicle, Readings readings, List<Alert> alerts);

    void ruleFuelVolume(Vehicle vehicle, Readings readings, List<Alert> alerts);

    void ruleTirePressure(Vehicle vehicle, Readings readings, List<Alert> alerts);

    void ruleEngineCoolantOrLightOn(Vehicle vehicle, Readings readings, List<Alert> alerts);

}
