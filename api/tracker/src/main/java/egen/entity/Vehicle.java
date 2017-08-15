package egen.entity;

import javax.persistence.*;


@Entity
@NamedQueries({
                    @NamedQuery(name = "Vehicle.findAll",query = "SELECT veh from Vehicle veh ORDER BY veh.vin desc"),
                    @NamedQuery(name = "Vehicle.findByVin",query = "SELECT veh from Vehicle veh where veh.vin=:paramvin")

})

public class Vehicle {

    @Id //primary key
    //@Column(columnDefinition = "VARCHAR(36)")
    private String vin;

    private String make;
    private String model;

    private String year;

    private String redlineRpm;

    private String maxFuelVolume;

    private String lastServiceDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Readings readings;

    public Readings getReadings() {
        return readings;
    }

    public void setReadings(Readings readings) {
        this.readings = readings;
    }

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

    public String getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(String redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public String getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(String maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", redlineRpm='" + redlineRpm + '\'' +
                ", maxFuelVolume='" + maxFuelVolume + '\'' +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                '}';
    }
}
