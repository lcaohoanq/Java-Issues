/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lcaohoanq.fundamental.piedclrm;

import java.util.Random;

/**
 *
 * @author Luu Cao Hoang
 */
public class Horse extends Herbivore {

    private String colorSaddle;
    
    //con ngựa có khả năng tiếp thu kém -> 30%
    
    //
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
        return new Random().nextDouble() * RECEPTIVE;
    }

    @Override
    public void showLearningOutcomes() {
        String str = String.format("Horse        |%-15s|%4d|%6.2f|%6.2f|%5s", name, yob, weight, study(), colorSaddle);
        System.out.println(str);
    }

}
