package com.lcaohoanq.fundamental.piedlclrm2;
//Herbivore không tham gia hội StudyEnthusiasts
//ví như con "bò"

public abstract class Herbivore {
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
    //dùng Abstract Method để chúng tự định nghĩa
    public abstract double study();
    
    public abstract void showLearningOutcomes();
}
