package com.lcaohoanq.fundamental.petcaresystem;

public class Program {

    public static void main(String[] args) {
        String url = "D:\\PIED\\JAVA\\Java Project\\16-petCareSystem\\petListDoc.txt";
        PetManagement pm = new PetManagement();
        //pm.initData();

        pm.loadFromFile(url);

//        pm.sortPetListByWeight();
//        pm.showPetList();
//        //nhận vị trí in luôn, nếu ko sẽ mất
//        System.out.println(pm.searchPetIndexById("C003"));
//        System.out.println(pm.searchPetByID("C004"));
//        
//        //pm.searchPetByID();
//        
//        //test nhập
//        String check = Inputter.getString("Nhập đi: ", "Ngu","D\\d{3}");
//        System.out.println("check = " +check);

//        pm.showPetList();
//        pm.updatePetByID();
//        pm.showPetList();

        Menu menu = new Menu("Pet care System Menu");
        menu.addNewOption("Add new dog");
        menu.addNewOption("Add new cat");
        menu.addNewOption("Print pet list");
        menu.addNewOption("Search pet by id");
        menu.addNewOption("Update by id");
        menu.addNewOption("Remove");
        menu.addNewOption("Sort by weight");
        menu.addNewOption("Save file and quit");

        int choice;
        while (true) {
            menu.print();
            choice = menu.getChoice();
            switch (choice) {
                case 1: {
                    pm.addNewDog();
                    break;
                }
                case 2: {
                    pm.addNewCat();
                    break;
                }
                case 3: {
                    pm.showPetList();
                    break;
                }
                case 4: {
                    pm.searchPetByID();
                    break;
                }
                case 5: {
                    pm.updatePetByID();
                    break;
                }
                case 6: {
                    pm.removePetByID();
                    break;
                }
                case 7: {
                    pm.sortPetListByWeight();
                    break;
                }
                case 8: {
                    //đề bài yêu cầu lưu khi bấm thoát chương trình
                    pm.saveToFile(url);
                    System.out.println("File Saved, See you again <3");
                    break;
                }
            }
        }
    }
}
/*
    Viết 1 chương trình quản lý thú cưng (DOG | CAT)
    1. Thêm mới 1 con cún (cân nhắc để cuối)
    2. Thêm mới 1 con mèo (cân nhắc để cuối)
    3. in ra danh sách thú cưng "DONE-1"
    4. tìm kiếm thú cưng theo tên : dễ nhất trong các cái khó, đảm bảo ít nhất đủ 3 điều kiện
        +Nhận id tìm vị trí
        +Nhận id tìm object
        +Xin  id in  object
            
    5. update thú cưng theo id
    6. remove thú cưng theo id
    7. sắp xếp thú cưng theo trọng lượng "comparator tạo trọng tài, tùy biến" DONE
    8. save file and quit

    khi thêm mới id của pet k được trùng với id ở trong danh sách
    id của pet phải thỏa theo format "D001| C001" //regex
    một con Pet có nhửng thuộc tính owner , color, weight, BMI
    
    Dog: necklace
    Cat: ribbon (ruy băng)

    yêu cầu chung: nhập chuẩn | nhập bậy bạ là chữi
*/