package hibernateDemo;

import javax.persistence.Embeddable;

// Embed in into the same entity table
@Embeddable
public class Provider implements Cloneable{
    String restroName;
    String restroLocation;
    String restroContactNumber;

    public String getRestroName() {
        return restroName;
    }

    public void setRestroName(String restroName) {
        this.restroName = restroName;
    }

    public String getRestroLocation() {
        return restroLocation;
    }

    public void setRestroLocation(String restroLocation) {
        this.restroLocation = restroLocation;
    }

    public String getRestroContactNumber() {
        return restroContactNumber;
    }

    public void setRestroContactNumber(String restroContactNumber) {
        this.restroContactNumber = restroContactNumber;
    }

    public Provider copy(){
        Provider p = new Provider();
        p.setRestroContactNumber(restroContactNumber);
        p.setRestroLocation(restroLocation);
        p.setRestroName(restroName);
        return p;
    }
    
    
}
