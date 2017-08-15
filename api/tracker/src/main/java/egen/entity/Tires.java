package egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Tires {

    @Id
    private String id;

    private Double frontLeft;

    private Double frontRight;

    private Double rearLeft;

    private Double rearRight;

    public Tires(){

        this.id= UUID.randomUUID().toString();

    }

    public Tires(Double frontLeft, Double frontRight, Double rearLeft, Double rearRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;
    }

    public Double getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(Double frontLeft) {
        this.frontLeft = frontLeft;
    }

    public Double getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(Double frontRight) {
        this.frontRight = frontRight;
    }

    public Double getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(Double rearLeft) {
        this.rearLeft = rearLeft;
    }

    public Double getRearRight() {
        return rearRight;
    }

    public void setRearRight(Double rearRight) {
        this.rearRight = rearRight;
    }


}
