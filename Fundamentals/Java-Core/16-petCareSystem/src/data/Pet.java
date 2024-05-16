package data;

import java.util.Scanner;

public abstract class Pet {
    protected String id;
    protected String owner;
    protected String color;
    protected double weight;
    

    public Pet(String id, String owner, String color, double weight) {
        this.owner = owner;
        this.color = color;
        this.weight = weight;
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    //setter
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //method: showInfor
    public abstract void showInfor();

}
