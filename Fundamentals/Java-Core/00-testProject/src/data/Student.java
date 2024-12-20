/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Student {

    private String id;
    private String name;
    private double gpa;
    private String gmail;

    public Student(String id, String name, double gpa, String gmail) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.gmail = gmail;
    }

    public Student() {
    }
    
    

    public static void inputStudent() {
        String id;
        Scanner sc = new Scanner(System.in);

        System.out.println("Input id");
        id = sc.nextLine();

        System.out.println("Student id: " + id);
    }
}
