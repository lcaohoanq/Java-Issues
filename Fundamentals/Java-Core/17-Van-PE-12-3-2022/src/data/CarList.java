package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import tool.ConsoleColors;
import tool.Inputter;

/*
CarList: người quản lí "danh sách các chiếc xe"
        và quản lí 1 thằng "quản lí danh sách những hãng độ xe"
carList: danh sách những chiếc xe
 */
public class CarList {

    //danh sách quản lí những chiếc xe
    ArrayList<Car> carList = new ArrayList<>();
    //người quản lý danh sách các hãng độ xe
    BrandList brandList; //CarList sở hữu danh sách carList và thằng BrandList brandList

    //ta đã có 1 danh sách brandList 
    //giờ là một biến brandList khác ở class CarList này
    //có nghĩa là tên thằng quản lí trùng tên với danh sách nó quản lí
    //mỗi khi cần truy cập các giá trị của brandList through CarList thì phải kêu 2 lần
    //Vd: lấy phần tử brandList ở vị trí thứ 3 => brandList.brandList.get(3)
    
    //method giúp quản lý danh sách
    //nếu như muốn đưa thằng này lên làm quản lí thì phải đưa
    //lính của mình cho nó
    public CarList(BrandList bList) {
        this.brandList = bList;
    }

    //đọc file car
    public boolean loadFromFile(String url) {
        File f = new File(url);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            //nếu không đọc được nữa thì sẽ trả ra null
            //nếu khác null -> xử lí dòng đó: Obj -> lưu
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                //xử lí dòng
                String cid = st.nextToken().trim();
                String brandId = st.nextToken().trim(); //ta đang băm cái brandID
                String color = st.nextToken().trim();
                String fId = st.nextToken().trim();
                String eId = st.nextToken().trim();
                //nếu muốn tạo một chiếc xe từ các dữ liệu đã băm thì
                //không tận dụng được brandId 
                //mà phải từ cái mã brandId ta phải tìm một cái hãng độ xe tương ứng

                int pos = brandList.searchID(brandId);
                //thằng quản lí tên là brandList vô danh sách brandList tìm vị trí thứ pos
                
                //nếu tìm thấy thằng brandId, ta hứng vị trí của nó
                //tạo một object brand mới từ vị trí đã hứng
                Brand brand = brandList.brandList.get(pos);

                //tạo
                Car nCar = new Car(cid, brand, color, fId, eId);
                //tạo xong phải nhét vô
                carList.add(nCar);

                line = reader.readLine();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Car error" + e);
            return false;
        }

    }
    
    //in ra danh sách các chiếc xe
    public void listCars() {
        if (carList.isEmpty()) {
            System.out.println("Car List nothing to print");
            return;
        }
        Collections.sort(carList);
        System.out.println("__________________________________CarList____________________________________");

        for (Car item : carList) {
            System.out.println(item.screenString());
        }
    }

    //tìm vị trí xe theo mã carId
    public int searchID(String carID) {
        for (int i = 0; i <= carList.size() - 1; i++) {
            if (carList.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;
    }

    //tìm vị trí xe theo mã fId
    public int searchFrame(String fID) {
        for (int i = 0; i <= carList.size() - 1; i++) {
            if (carList.get(i).getFrameID().equals(fID)) {
                return i;
            }
        }
        return -1;
    }

    //tìm vị trí xe theo mã eId
    public int searchEngine(String eID) {
        for (int i = 0; i <= carList.size() - 1; i++) {
            if (carList.get(i).getEngineID().equals(eID)) {
                return i;
            }
        }
        return -1;
    }

    //thêm một chiếc xe
    //tạo
    //lưu
    //thông báo
    /*cid(cấm trùng), 
            brandid, 
            color, 
            fid(cấm trùng), 
            eid(cấm trùng)*/
    public void addCar() {
        //thu thập

        boolean isDup = false;
        String cid;
        do {
            isDup = false; //reset
            //nhập
            cid = Inputter.getString("Input New Car Id: ", "That field is required");

            //nếu tìm kiếm khác -1 => tìm được
            if (this.searchID(cid) != -1) {
                isDup = true;
                System.out.println(ConsoleColors.RED+"Car Id is duplicate" +ConsoleColors.RESET);
            }

            //check trùng
        } while (isDup);

        //brand
        //ý nghĩa của cái này là gì?
        //tạo một object là brand (nhét vào phễu của Car thôi)
        //là kêu cái mảng brandList đi tìm cái Brand từ hàm getUserChoice(hàm này sẽ list ra các brand, và báo người dùng nhập vào brand tương ứng của car)
        Brand brand = brandList.getUserChoice();

        //color
        String color = Inputter.getString("Input New color", "That field is required");

        //frameID
        String fid;
        do {
            isDup = false; //reset
            //nhập
            fid = Inputter.getString("Input New Frame Id: ", "FID must be match FXXXXX", "F\\d{5}");

            //nếu tìm kiếm khác -1 => tìm được
            if (this.searchFrame(fid) != -1) {
                isDup = true;
                System.out.println(ConsoleColors.RED+"Frame Id is duplicate" +ConsoleColors.RESET);
            }
            //check trùng
        } while (isDup);

        //EngineID
        String eid;
        do {
            isDup = false; //reset
            //nhập
            eid = Inputter.getString("Input New Engine Id: ", "EID must be match FXXXXX", "E\\d{5}");

            //nếu tìm kiếm khác -1 => tìm được
            if (this.searchEngine(eid) != -1) {
                isDup = true;
                System.out.println(ConsoleColors.RED+"Engine Id is duplicate" +ConsoleColors.RESET);
            }

            //check trùng
        } while (isDup);

        //tạo một chiếc xe từ các thông tin đã có
        Car nCar = new Car(cid, brand, color, fid, eid);
        carList.add(nCar);
        System.out.println(ConsoleColors.GREEN+ "Car Adding Is Successful" +ConsoleColors.RESET);
    }

    public void printBaseBrandName() {
        String key = Inputter.getString("Input a part of BrandName: ", "That field is required");

        //duyệt danh sách các chiếc xe
        //xe nào có brandName chứa key là in ra
        //tìm một cách tương đối
        int count = 0;
        for (Car car : carList) {
            //tìm thấy nên mới khác -1
            if (car.getBrand().getBrandName().contains(key)) {
                System.out.println(car.screenString());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No car is detected");
        }
    }

    //đừng có cãi nghe chưa
    //hàm REMOVE
    public boolean removeCar() {
        String keyId = Inputter.getString("Input CarId you wana remove: ", "That field is required");

        int pos = this.searchID(keyId);

        if (pos == -1) {
            System.out.println("Not found");
            return false;
        }
        System.out.println("Car information before removing");
        System.out.println(carList.get(pos).screenString());

        carList.remove(pos);

        System.out.println("Car removing is Successful");

        return true;

    }

    //
    public boolean updateCar() {
        String keyId = Inputter.getString("Input CarId you wana update: ", "That field is required");

        int pos = this.searchID(keyId);

        if (pos == -1) {
            System.out.println("Not found");
            return false;
        }
        System.out.println("Car information before updating");
        System.out.println(carList.get(pos).screenString());

        boolean isDup = false;
        //thu thập 
        //copy trong addCar
        //brand
        Brand brand = brandList.getUserChoice();

        //color
        String color = Inputter.getString("Input New color", "That field is required");

        //fid
        String fid;
        do {
            isDup = false; //reset
            //nhập
            fid = Inputter.getString("Input New Frame Id: ", "FID must be match FXXXXX", "F\\d{5}");

            //nếu tìm kiếm khác -1 => tìm được
            if (this.searchFrame(fid) != -1) {
                isDup = true;
                System.out.println("Frame Id is duplicate");
            }

            //check trùng
        } while (isDup);

        //eid
        String eid;
        do {
            isDup = false; //reset
            //nhập
            eid = Inputter.getString("Input New Engine Id: ", "EID must be match FXXXXX", "E\\d{5}");

            //nếu tìm kiếm khác -1 => tìm được
            if (this.searchEngine(eid) != -1) {
                isDup = true;
                System.out.println("Engine Id is duplicate");
            }

            //check trùng
        } while (isDup);

        //cập nhật
        carList.get(pos).setBrand(brand);
        carList.get(pos).setColor(color);
        carList.get(pos).setEngineID(eid);
        carList.get(pos).setFrameID(fid);

        System.out.println("Car updating successful");

        return true;

    }

    //hàm lưu file làm cuối cùng
    public boolean saveToFile(String url) {
        File f = new File(url);
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            for (Car item : carList) {
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
}
