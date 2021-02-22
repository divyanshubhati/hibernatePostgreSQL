package HQLdemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gadgets {
    @Id
    int id;
    String name;
    int yearOfPurchase;
    int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfPurchase() {
        return yearOfPurchase;
    }

    public void setYearOfPurchase(int yearOfPurchase) {
        this.yearOfPurchase = yearOfPurchase;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " Id : "+ id + " Name : "+ name + " Year of Purchase : " + yearOfPurchase + " Price : "+ price;
    }

    
    
}
