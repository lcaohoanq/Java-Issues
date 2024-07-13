package data;
//StudentV1 là cái khuôn sinh viên bình thường
//đúc ra sinh viên bình thường
public class StudentV1 {
    //props
    private String id;
    private String fName;
    private String lName;
    private double score;
    
    //constructor: cái phễu | người xây dựng
    public StudentV1(String id, String fName, String lName, double score) {
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
}
