package hibernateDemo;

@javax.persistence.Entity
public class Dish {
    @javax.persistence.Id
    int id;
    String name;
    float price;
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
}