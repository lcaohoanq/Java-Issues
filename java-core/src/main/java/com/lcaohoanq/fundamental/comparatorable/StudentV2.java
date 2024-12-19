package com.lcaohoanq.fundamental.comparatorable;
//StudentV2 là cái khuôn sinh viên 
//có tính đố kỵ

//Comparable: tính đố kị interface
//chứa abs method: compareTo
//Comparable: hội những người thích đố kỵ

public class StudentV2 implements Comparable<StudentV2>{
    //props
    private String id;
    private String fName;
    private String lName;
    private double score;
    
    //constructor: cái phễu | người xây dựng
    public StudentV2(String id, String fName, String lName, double score) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.score = score;
    }

    //getter
    public String getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public double getScore() {
        return score;
    }
    
    //method showInfor
    public void showInfor(){
        String str = String.format("%-11s|%-11s|%-11s|%5.2f",
                                    id,fName,lName,score );
        System.out.println(str);
    }

    @Override
    public int compareTo(StudentV2 that) {
        if(this.getId().compareTo(that.getId()) > 0){
            return 1;
        }
        return -1;
    }
}
