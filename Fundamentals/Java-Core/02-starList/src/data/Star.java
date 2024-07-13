//chế ra cái khuôn đầu tiên tên là Star
//cái khuôn này dùng để đúc ra các người nổi tiếng
//và trong số đó tui muốn đúc ra anh Sơn Tùng, Chipuc
package data;

public class Star {
    
    //props | field | attribute: thuộc tính
    
    private String name;
    public int yob; 
    public static String gender; 
    public String hotSong;

    //chế cái phễu để nhận giá trị từ người dùng
    //rót vào chỗ tương ứng của cái khuôn
    //constructor (cái phễu) - hàm - method
    //1. phễu phải public: cái phễu ở trong cái khuôn sao mà xài má ??
    //2. phễu có cùng tên với class: muốn đúc star phải có phễu star
    //this : ám chỉ chính nó, ám chỉ class chứa nó
    public Star (String name, int yob, 
                 String gender, String hotSong ){
        //inpName là giá trị mà người dùng muốn truyền vào ngăn name
        this.name = name;
        this.yob = yob;
        this.gender = gender;
        this.hotSong = hotSong; 
    }
    
    //getter và setter
    public String getName(){
        return this.name;
    }
    public void setName (String newName, int password){
        if(password == 1){
            this.name = newName;
        }
    }
    
    public void showInfor(){
        System.out.println("Tôi tên "+name+ ", Tôi sinh  "+ yob +
                            ", Giới tính "+ gender +
                            ", Hot song  "+ hotSong);
    }
    
}
