package hibernateDemo;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

// 3 layers class - table - Entity
@javax.persistence.Entity
@Table(name="dish_table")
public class Dish {
    @javax.persistence.Id
    int id;
    String name;

    //override column name
    @Column(name = "dish_price")
    float price;


    Provider supplier;

    // will not save the value in database
    @Transient
    int serving;

    void setId(int num){
        id = num;
    }
    int getId(){
        return id;
    }
    void setName(String temp){
        name = temp;
    }
    String getName(){
        return name;
    }
    void setPrice(float x){
        price =x;
    }
    float getPrice(){
        return price;
    }
    void setServing(int srv){
        serving = srv;
    }
    int getServing(){
        return serving;
    }
    @Override
    public String toString(){
        return "ID : "+ id + " Name : " + name + " Price : " + price + " Available at : " + supplier.getRestroName() + " Location : " + supplier.getRestroLocation() + "Contact Number : " + supplier.getRestroContactNumber();
    }

    public Provider getSupplier() {
        return supplier.copy();
    }

    public void setSupplier(Provider s) {
        supplier = s.copy();
    }
}