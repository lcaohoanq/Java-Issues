/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Luu Cao Hoang
 */
public class Student {
    String Student_ID;
    String Student_Name;
    String MID;

    public Student() {
    }

    public Student(String Student_ID, String Student_Name, String MID) {
        this.Student_ID = Student_ID;
        this.Student_Name = Student_Name;
        this.MID = MID;
    }
    
    
    
    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String Student_ID) {
        this.Student_ID = Student_ID;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String Student_Name) {
        this.Student_Name = Student_Name;
    }

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }
    
}
