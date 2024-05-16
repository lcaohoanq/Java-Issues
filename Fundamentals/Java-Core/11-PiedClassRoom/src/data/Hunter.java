package data;
//bác thợ săn không kế thừa Herbivore
//nhưng có các thuộc tính giống Herbivore

import java.util.Random;

public class Hunter {
    private String name;
    private int yob;
    private double weight;
    private String gear;
    
    public static final double RECEPTIVE = 50;

    public Hunter(String name, int yob, double weight, String gear) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
        this.gear = gear;
    }
    
    public double study() {
        return new Random().nextDouble()*RECEPTIVE;
    }

    public void showLearningOutcomes() {
        String str = String.format("Hunter       |%-15s|%4d|%6.2f|%6.2f|%s",name,yob,weight,study(),gear);
        System.out.println(str);
    }
}
