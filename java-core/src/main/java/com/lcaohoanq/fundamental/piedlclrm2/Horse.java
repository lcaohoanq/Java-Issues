package com.lcaohoanq.fundamental.piedlclrm2;

import java.util.Random;
//giả sử tất cả các con ngựa trên đời này đều ham học
//nên sẽ cho Horse tham gia clb
//extends(props riêng, method riêng, override method(implement))
//implements(chỉ bao gồm các implement method, hàm mà con đã vá)

public class Horse extends Herbivore implements StudentEnthusiasts{
    private String colorSaddle;
    //con ngựa có khả năng tiếp thu kém -> 30%
    public static final double RECEPTIVE = 30;

    public Horse(String name, int yob, double weight, String colorSaddle) {
        super(name, yob, weight);
        this.colorSaddle = colorSaddle;
    }

    public String getColorSaddle() {
        return colorSaddle;
    }
    
    
    
    @Override
    public double study() {
        return new Random().nextDouble()*RECEPTIVE;
    }

    @Override
    public void showLearningOutcomes() {
        String str = String.format("Horse        |%-15s|%4d|%6.2f|%6.2f|%5s",
                                        name,yob,weight,study(),colorSaddle );
        System.out.println(str);
    }

    @Override
    public double studyHard() {
        return study()*1.5;
    }

    @Override
    public void showProfile() {
        String str = String.format("Horse        |%-15s|%4d|%6.2f|%6.2f|%5s",
                                        name,yob,weight,studyHard(),colorSaddle );
        System.out.println(str);
    }
    
    
    
}
