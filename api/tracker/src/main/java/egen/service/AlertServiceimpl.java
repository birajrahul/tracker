package egen.service;


import egen.Priority;
import egen.Rule;
import egen.entity.Alert;
import egen.entity.Readings;
import egen.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertServiceimpl implements AlertService{



    public List<Alert> generateAlerts(Vehicle vehicle, Readings readings) {

        List<Alert> alerts = new ArrayList<Alert>();

        ruleEngineRpm(vehicle,readings,alerts);
        ruleFuelVolume(vehicle,readings,alerts);
        ruleTirePressure(vehicle,readings,alerts);
        ruleEngineCoolantOrLightOn(vehicle,readings,alerts);
        return alerts;
    }

    public void ruleEngineRpm(Vehicle vehicle, Readings readings, List<Alert> alerts) {

        if(readings.getEngineRpm()>vehicle.getRedlineRpm()){

            Alert alert = new Alert();
            alert.setVehicle(vehicle);
            alert.setReadings(readings);
            alert.setPriority(Priority.HIGH.name());
            alert.setRule(Rule.HIGHRPM.name());

            alerts.add(alert);
        }
    }

    public void ruleFuelVolume(Vehicle vehicle, Readings readings, List<Alert> alerts) {
        if(readings.getFuelVolume() < (0.1 * vehicle.getMaxFuelVolume())){

            Alert alert = new Alert();
            alert.setVehicle(vehicle);
            alert.setReadings(readings);
            alert.setPriority(Priority.MEDIUM.name());
            alert.setRule(Rule.LOWFUEL.name());

            alerts.add(alert);
        }
    }

    public Boolean checkTirePressure(Double tire){

        return tire < 32 || tire > 36;
    }

    public void ruleTirePressure(Vehicle vehicle, Readings readings, List<Alert> alerts) {
        if(checkTirePressure(readings.getTires().getFrontLeft())
                || checkTirePressure(readings.getTires().getFrontRight())
                || checkTirePressure(readings.getTires().getRearLeft())
                || checkTirePressure(readings.getTires().getRearRight())) {

            Alert alert = new Alert();
            alert.setVehicle(vehicle);
            alert.setReadings(readings);
            alert.setPriority(Priority.LOW.name());
            alert.setRule(Rule.TIREPRESSURE.name());

            alerts.add(alert);

        }

    }

    public void ruleEngineCoolantOrLightOn(Vehicle vehicle, Readings readings, List<Alert> alerts) {

        if(readings.getEngineCoolantLow() || readings.getCheckEngineLightOn()){
            Alert alert = new Alert();
            alert.setVehicle(vehicle);
            alert.setReadings(readings);
            alert.setPriority(Priority.LOW.name());
            alert.setRule(Rule.LOWENGINECOOLANT_ENGINELIGHTON.name());

            alerts.add(alert);

        }
    }


}



