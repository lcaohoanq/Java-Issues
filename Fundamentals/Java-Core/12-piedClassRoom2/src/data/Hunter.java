package data;
//bác thợ săn không kế thừa Herbivore
//nhưng có các thuộc tính giống Herbivore

import java.util.Random;
//giả định tất cả bác thợ săn đều mê học
public class Hunter implements StudentEnthusiasts{
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

    @Override
    public double studyHard() {
        return study()*1.5;
    }

    @Override
    public void showProfile() {
        String str = String.format("Hunter       |%-15s|%4d|%6.2f|%6.2f|%s",
                            name,yob,weight,studyHard(),gear);
        System.out.println(str);    
    }
}
