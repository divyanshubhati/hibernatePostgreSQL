package hibernateMappingDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
// import javax.persistence.ManyToOne;

@Entity
public class Driver {
    @Id
    int id;
    String name;
    String dob;
    String licenseExpiresOn;
    // @ManyToOne
    // Vehicle vehicle;
    @ManyToMany
    List <Vehicle> vehicles = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLicenseExpiresOn() {
        return licenseExpiresOn;
    }

    public void setLicenseExpiresOn(String licenseExpiresOn) {
        this.licenseExpiresOn = licenseExpiresOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehicle> getCar() {
        return vehicles;
    }

    public void setCar(List<Vehicle> car) {
        this.vehicles = car;
    }

}
