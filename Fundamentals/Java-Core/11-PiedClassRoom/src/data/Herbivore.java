/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Luu Cao Hoang
 */
public abstract class Herbivore {
    //những gì chung
    protected String name;
    protected int yob;
    protected double weight;

    public Herbivore(String name, int yob, double weight) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public double getWeight() {
        return weight;
    }
    
    public void showInfor(){
        System.out.printf("%-14s|%4d|%6.2f", name, yob,weight);
    }
    
    //mỗi một Herbivore sẽ có mức độ tiếp thu khác nhau
    //để chúng tự định nghĩa
    public abstract double study();
    
    public abstract void showLearningOutcomes();
}
