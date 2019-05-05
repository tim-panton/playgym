package models;
import play.db.jpa.Model;
import javax.persistence.Entity;

@Entity
public class Assessment extends Model
{
    public Double weight;
    public Double chest;
    public Double thigh;
    public Double upperArm;
    public Double waist;
    public Double hips;

    public Assessment(Double weight, Double chest, Double thigh, Double upperArm, Double waist, Double hips)
    {
        this.weight = weight;
        this.chest = chest;
        this.thigh = thigh;
        this.upperArm = upperArm;
        this.waist = waist;
        this.hips = hips;
    }
}