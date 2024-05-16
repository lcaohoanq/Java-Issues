package data;
//PetManagement: là 1 cái khuôn tạo ra anh 
//               quản lý danh sách các con pet

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Scanner;
import java.util.StringTokenizer;
import tool.Inputter;

//anh quản lý này sẽ có các method giúp thao tác
//với danh sách mà ảnh quản lý
/*
    Viết 1 chương trình quản lý thú cưng (DOG | CAT)
    1. Thêm mới 1 con cún
    2. Thêm mới 1 con mèo
    3. in ra danh sách thú cưng
    4. tìm kiếm thú cưng theo tên
    5. update thú cưng theo id
    6. remove thú cưng theo id
    7. sắp xếp thú cưng theo trọng lượng
    8. save file and quit
*/
public class PetManagement {
    //props
    ArrayList<Pet> petList = new ArrayList<>();
    
    //method giúp xử lí petList
    //dùng để test khi đang build 
    //sẽ thay thế bằng một file txt 
    public void initData(){
        petList.add(new Dog("D001", "Tuấn" , "Red"  , 6.3, "I <3 U"));
        petList.add(new Dog("D002", "Toàn" , "Yélầu", 2.2, "Yellow"));
        petList.add(new Cat("C001", "Tùng" , "Nâu"  , 4.2, "Mỹ Diệu"));
        petList.add(new Cat("C002", "Thông", "Tím"  , 5.2, "Thông tìm"));
    }
    
    //method3: in danh sách
    public void showPetList(){
        if(petList.isEmpty()){
            System.out.println("Nothing to print");
            return;
        }
        System.out.println("----Pet List----");
        for (Pet item : petList) {
            item.showInfor(); //nếu kh
        }
    }
    
    //method7: sắp xếp danh sách theo cân nặng
    public void sortPetListByWeight(){
        //tạo trọng tài
        Comparator<Pet> orderByWeight = new Comparator<Pet>() {
            @Override
            public int compare(Pet t1, Pet t2) {
                if(t1.getWeight() > t2.getWeight()){
                    return 1;
                    //nếu t1 > t2 thì swap
                    //return 1 có nghĩa là swap
                }
                //không swap
                return -1;
            }
        };
        //nạp anh trọng tài vào collections
        Collections.sort(petList, orderByWeight);
        //có in ra không?
        //SẮP XẾP LÀ SẮP XẾP / KO IN RA
        
        System.out.println("Sorted");
    }
    
    //method 4 tìm kiếm
    //nếu nhận id sai thì sao?? Lỗi ko chạy được
    //cần phải nâng cấp bài của a Điệp lên nữa
    //1. nhận id tìm vị trí
    public int searchPetIndexById(String keyId){
        for(int i = 0; i <= petList.size()-1; i++){
            if(petList.get(i).getId().equals(keyId)){
                return i;
            }
        }
        return -1;
    }; 
    
    //2. nhận id tìm object
    public Pet searchPetByID(String keyId){
        int pos = this.searchPetIndexById(keyId);
        return pos == -1 ? null : petList.get(pos);
    }
    
    //3. xin id in object
    //làm 2 hàm trên là chuẩn bị cho hàm dưới này ^^
    //cùng tên nhưng khác parameter => overload
    public void searchPetByID(){
        String keyId = Inputter.getString("Input id you wanna find: ",
                                            "That field is required!");
        Pet pet = this.searchPetByID(keyId);
        if(pet == null){
            System.out.println("This pet not exist");
        }
        System.out.println("Pet Information");
        pet.showInfor();
    }
    
    //xóa
    public void removePetByID(){
        String keyId = Inputter.getString("Input id you wanna remove: ", "That field is required!");
        Pet pet = this.searchPetByID(keyId);
        if(pet == null){
            System.out.println("This pet not exist");
        }
        System.out.println("Pet Information deleting: ");
        pet.showInfor();
        petList.remove(pet);
        System.out.println("Removed");
    }
    
    //update => bản chất là tìm kiếm
    //tìm được => update
    public void updatePetByID(){
        String keyId = Inputter.getString("Input id you wanna update: ", "That field is required!");
        Pet pet = this.searchPetByID(keyId);
        if(pet == null){
            System.out.println("This pet not exist");
        }else{
            System.out.println("Pet Information before updating: ");
            pet.showInfor();
            System.out.println("Updating");
            //không biết con vật là chó hay mèo        
            String nOwner  = Inputter.getString("Input new owner", "that field is requiered!");
            String nColor  = Inputter.getString("Input new color", "that field is requiered!");
            Double nWeight = Inputter.getADouble("Input new weight", "that field is requiered!", 1,100);
            
            //build lại setter
            pet.setOwner(nOwner);
            pet.setColor(nColor); 
            pet.setWeight(nWeight);
            
            //cập nhật necklace hay ribbon
            //dữ liệu ở đây có sẵn chữ D, C
            //từ đó có thể căn cứ để tìm được là chó hay mèo
            //nhưng nếu ngược lại thì sao?
            //qua chó cập nhập setter vòng cổ
            //mèo cập nhật setter ribbon
            if(pet instanceof Dog){
                String nNecklace = Inputter.getString("Input new necklace", "that field is requiered!");
                ((Dog)pet).setNecklace(nNecklace);
            }else{
                //chỉnh cho mèo
                String nRibbon = Inputter.getString("Input new neckRibbon", "that field is requiered!");
                ((Cat)pet).setRibbon(nRibbon);
            }
            System.out.println("Updating successful");
        }
    }
    
    //thêm chó
    public void addNewDog(){
        boolean isDup = false;
        String id; //id cho con chó mới
        do{
            isDup = false; //reset
            id = Inputter.getString("Input your dog's id", "Your id must to match DXXX", "[dD]\\d{3}").toUpperCase();
            //nhập chữ thường hoặc chữ hoa
            //lưu trữ bắt buộc chữ hoa
            
            for (Pet item : petList) {
                if(item.getId().equals(id)){
                    isDup = true;
                    System.out.println("Id is duplicate");
                }
            }
            
        }while(isDup); //còn thỏa là còn làm //còn trùng lặp thì chạy tiếp 
        
        //xong một cái id ngon
        //tiếp theo cần phải để người dùng nhập các thông tin còn lại
        String onwer    = Inputter.getString ("Input owner"    , "That fielid is requiered!");
        String color    = Inputter.getString ("Input color"    , "That fielid is requiered!");
        Double weight   = Inputter.getADouble("Input weight"   , "That fielid is requiered!");
        String necklace = Inputter.getString ("Input necklace" , "That fielid is requiered!");
        
        //tạo Dog
        Dog nDog = new Dog(id, onwer, color, weight, necklace);
        petList.add(nDog); //thêm vào danh sách
        
        System.out.println("-------------Add Dog Successful-------------");
    }
    
    //thêm mèo
    public void addNewCat(){
        boolean isDup = false;
        String id; //id cho con chó mới
        do{
            isDup = false; //reset
            id = Inputter.getString("Input your cat's id", "Your id must to match CXXX", "[cC]\\d{3}").toUpperCase();
            //nhập chữ thường hoặc chữ hoa
            //lưu trữ bắt buộc chữ hoa
            
            for (Pet item : petList) {
                if(item.getId().equals(id)){
                    isDup = true;
                    System.out.println("Id is duplicate");
                }
            }
            
        }while(isDup); //còn thỏa là còn làm //còn trùng lặp thì chạy tiếp 
        
        //xong một cái id ngon
        //tiếp theo cần phải để người dùng nhập các thông tin còn lại
        String onwer    = Inputter.getString ("Input owner"  , "That fielid is requiered!");
        String color    = Inputter.getString ("Input color"  , "That fielid is requiered!");
        Double weight   = Inputter.getADouble("Input weight" , "That fielid is requiered!");
        String ribbon   = Inputter.getString ("Input ribbon" , "That fielid is requiered!");
        
        //tạo Dog
        Cat nCat = new Cat(id, onwer, color, weight, ribbon);
        petList.add(nCat); //thêm vào danh sách
        
        System.out.println("-------------Add Cat Successful-------------");
    }
    
    //loadFile: hàm đọc file
    public boolean loadFromFile(String url){
        //tạo obj file
        File f = new File(url); //f là file
        //ko thể đọc f được
        //nếu muốn đọc => BufferReader : giúp em đọc từng hàng line by line
        //trong quá trình đọc sẽ có lỗi
        //try-cach
        try{
            //đọc file
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine(); //trả ra một dòng trong file
            while(line != null){
                //xử lí hàng
                //băm ra từng mảnh từng khúc
                StringTokenizer st = new StringTokenizer(line, "|");
                
                String id = st.nextToken().trim();
                String owner = st.nextToken().trim();
                String color = st.nextToken().trim();
                Double weight = Double.parseDouble(st.nextToken().trim());
                
                //special là necklace hoặc ribbon, không biết thuộc về ai
                String special = st.nextToken().trim();
                
                Pet pet = null;
                
                if(id.matches("[Dd]\\d{3}")){
                    pet = new Dog(id, owner, color, weight, special);
                }else{
                    pet = new Cat(id, owner, color, weight, special);
                }
                
                petList.add(pet);

                //line đọc lại 1 dòng, nếu là null thì lên while rồi dừng
                line = reader.readLine();
            }
            return true;
        } catch(Exception e){
            System.out.println("Errored file");
            return false;
        }
    }
    //file không thay đổi =))))) làm thêm một hàm
    public boolean saveToFile(String url){
        File f = new File(url); //f là file của mình
        //buffer reader chỉ giúp cho mình đọc
        //muốn viết thì có OutputStreamWriter: hỗ trợ viết lên file
        try{
            //đọc file
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            //Lấy dữ liệu ra -> file trắng hết
            for (Pet item : petList) {
                writer.write(item.toString());
                writer.write("\n");
            }
            writer.flush();//đợi save xong mới đóng
            return true;
        }catch(Exception e){
            System.out.println("Loi luu file"+e);
            return false;
        }
    }
}
