package egen.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@NamedQueries({@NamedQuery(name = "Vehicle.findAll",query = "SELECT veh from Vehicle veh ORDER BY veh.vin desc"),
        @NamedQuery(name = "Vehicle.findByVin",query = "SELECT veh from Vehicle veh where veh.vin=:paramvin")})
public class Vehicle {

    @Id //primary key
    //@Column(columnDefinition = "VARCHAR(36)")
    private String vin;

    private String make;

    private String model;

    private String year;

    private Double redlineRpm;

    private Double maxFuelVolume;

    private Date lastServiceDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Readings> readings = new ArrayList<Readings>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alert> alerts = new ArrayList<Alert>();

    public Vehicle(){

    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(Double redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public Double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(Double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public List<Readings> getReadings() {
        return readings;
    }

    public void setReadings(List<Readings> readings) {
        this.readings = readings;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", redlineRpm=" + redlineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", lastServiceDate=" + lastServiceDate +
                ", readings=" + readings +
                ", alerts=" + alerts +
                '}';
    }
}
