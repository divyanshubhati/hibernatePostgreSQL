package hibernateMappingDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
// import javax.persistence.OneToMany;

@Entity
public class Vehicle {
    @Id
    int id;
    String name;
    String number;
    String colour;
    String model;
    // @OneToMany(mappedBy = "vehicle")
    @ManyToMany(mappedBy = "vehicles")
    List<Driver>  driver = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Driver> getDr() {
        return driver;
    }

    public void setDr(List<Driver> dr) {
        this.driver = dr;
    }

    
}
