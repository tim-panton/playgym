package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import models.Assessment;

@Entity
public class Member extends Model
{
    public String firstname;
    public String lastname;
    public String email;
    public String password;
    public String address;
    public double height;
    public double startingWeight;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Assessment> assessmentlist = new ArrayList<Assessment>();

    public Member(String firstname, String lastname, String email, String password, String address, double height, double startingWeight)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.height = height;
        this.startingWeight = startingWeight;
    }

    public static Member findByEmail(String email)
    {
        return find("email", email).first();
    }

    public boolean checkPassword(String password)
    {
        return this.password.equals(password);
    }


}