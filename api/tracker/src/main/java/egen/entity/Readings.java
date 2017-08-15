package egen.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Readings {

//    @Id
//    private String id;

//    @Transient
    @Id
    private String vin;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    private Double latitude;
    private Double longitude;
    private Date timestamp;
    private Double fuelVolume;
    private Double speed;
    private Double engineHp;
    private Boolean checkEngineLightOn;
    private Boolean engineCoolantLow;
    private Boolean cruiseControlOn;
    private int engineRpm;

    @OneToOne(cascade = CascadeType.ALL)
    private Tires tires;

    public Readings(){

   //     this.id = UUID.randomUUID().toString();
    }


    public Readings(Double latitude, Double longitude, Date timestamp, Double fuelVolume, Double speed, Double engineHp, Boolean checkEngineLightOn, Boolean engineCoolantLow, Boolean cruiseControlOn, int engineRpm, Tires tires) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
        this.fuelVolume = fuelVolume;
        this.speed = speed;
        this.engineHp = engineHp;
        this.checkEngineLightOn = checkEngineLightOn;
        this.engineCoolantLow = engineCoolantLow;
        this.cruiseControlOn = cruiseControlOn;
        this.engineRpm = engineRpm;
        this.tires = tires;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(Double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(Double engineHp) {
        this.engineHp = engineHp;
    }

    public Boolean getCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(Boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public Boolean getEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(Boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public Boolean getCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(Boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }



}
