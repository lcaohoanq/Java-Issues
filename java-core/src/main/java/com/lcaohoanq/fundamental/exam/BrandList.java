package com.lcaohoanq.fundamental.exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
BrandList: người quản lí danh sách các Brand
 */
public class BrandList {

    ArrayList<Brand> brandList = new ArrayList<>(); //thông thường
    //method giúp thao tác với danh sách brandList

    //nếu có 2 constructor => cần tạo thêm constructor rỗng
    //nếu không thì đã tự có sẵn constructor rỗng 
    //ở đây ta không cần tạo thêm nữa, tự khi gọi sẽ hiểu gọi constructor rỗng
    
    //hàm đọc file
    public boolean loadFromFile(String url) {
        File f = new File(url);
        //Muốn đọc file dùng BufferedReader
        try {
            //đọc file
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ","); //nhát băm đầu tiên được id
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                String str = st.nextToken().trim();
                //hash stage 2
                st = new StringTokenizer(str, ":");
                String sound = st.nextToken().trim();
                Double price = Double.parseDouble(st.nextToken().trim());

                //dùng dữ kiện đúc brand
                Brand nBrand = new Brand(id, name, sound, price);

                brandList.add(nBrand); //bỏ vào danh sách
                line = reader.readLine();
            }
            return true;
        } catch (Exception e) {
            System.out.println("File Brand Error" + e);
            return false;
        }
    }

    //hàm lưu file làm cuối cùng
    public boolean saveToFile(String url) {
        File f = new File(url);

        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            for (Brand item : brandList) {
                writer.write(item.toString());
                writer.write("\n");
            }
            writer.flush();
            return true;
        } catch (Exception e) {
            System.out.println("File error" + e);
            return false;
        }
    }

    //hàm in dễ nhất nên làm trước
    public void listBrands() {
        if (brandList.isEmpty()) {
            System.out.println("Nothing to print");
            return;
        }
        System.out.println("---------------------------[BRAND LIST]---------------------------");
        System.out.println(ConsoleColors.GREEN + "brandID   , brandName                     , soundBrand     : price" + ConsoleColors.RESET);
        for (Brand item : brandList) {
            //item.toString(); //hứng lại
            //System.out.println(item.toString()); sout sẽ tự gọi toString nếu như hàm chứa toString
            System.out.println(item);
        }
    }
    
    //hàm tìm
    public int searchID(String bID) {
        for (int i = 0; i <= brandList.size() - 1; i++) {
            if (this.brandList.get(i).getBrandID().equals(bID)) {
                return i;
            }
        }
        return -1;
    }

    //hàm thêm
    public void addBrand() {
        //id
        //xử lí id
        boolean isDup = false;
        String id;
        do {
            isDup = false; //reset lại =))))))) 
            id = Inputter.getString("Input brand id: ",
                    "That field not required");
            //checkDup
            for (Brand item : brandList) {
                if (item.getBrandID().equals(id)) {
                    isDup = true;
                    System.out.println("ID is duplicate");
                }
            }
        } while (isDup);

        //name 
        //sound
        //price
        String name = Inputter.getString("Input BrandName", "That field not required");
        String sound = Inputter.getString("Input sound", "That field not required");

        double price;
        do {
            price = Inputter.getADouble("Input price", "That field not required");

            if (price < 0) {
                System.out.println("Price must to Positive real number");
            }
        } while (price < 0);

        //nạp vô khuôn
        Brand nBrand = new Brand(id, name, sound, price);
        brandList.add(nBrand);
        System.out.println("Adding Brand is Successful");
    }

    //hàm update này require một hàm bên trong là searchID
    public void updateBrand() {
        //không update id
        String keyId = Inputter.getString("Input Id you want update", "That field not required");

        //this là ám chỉ class chứa nó => gọi đến class BrandList => method searchID
        int pos = this.searchID(keyId);

        if (pos == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Brand information before updating");
            System.out.println(brandList.get(pos));
            System.out.println("Updating..........");
            //thu thập thông tin mới trước khi update
            String name = Inputter.getString("Input new BrandName", "That field not required");
            String sound = Inputter.getString("Input new sound", "That field not required");

            double price;
            do {
                price = Inputter.getADouble("Input new price", "That field not required");

                if (price < 0) {
                    System.out.println("Price must to Positive real number");
                }
                
                //độ Inputter? lớn hơn 0?
            } while (price < 0);
            //xong
            //update
            brandList.get(pos).setBrandName(name);
            brandList.get(pos).setSoundBrand(sound);
            brandList.get(pos).setPrice(price);
            //
            System.out.println("Brand updating is successful");
        }
    }

    //hàm searchBrand
    public void searchBrand() {
        //không update id
        String keyId = Inputter.getString("Input Id you want find", "That field not required");

        //this là ám chỉ class chứa nó => gọi đến class BrandList => method searchID
        int pos = this.searchID(keyId);

        if (pos == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Brand information before updating");
            System.out.println(brandList.get(pos));
        }
    }

    //hàm đứng giữa trung gian kêu thằng ref_getChoice 
    //kêu thằng ref_getChoice để in ra cái menu 
    public Brand getUserChoice() {
        Menu menuBrand = new Menu("<---Menu BrandList---> ");
        return menuBrand.ref_getChoice(brandList);
    }
}
