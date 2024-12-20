package com.lcaohoanq.fundamental.exam;
/*
    Car là cái khuôn chuyên đúc ra các chiếc xe
    trong description thì car được mô tả brand ID
    nhưng file trong class Car thì cô lại lưu Brand brand => lưu nguyên một thằng độ xe
    => tốn dữ liệu
*/
public class Car implements Comparable<Car>{
    //props
    private String carID;
    private Brand  brand; //
    private String color;
    private String frameID;
    private String engineID;
    
    //constructor
    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public Car() {
    }
    
    //getter
    public String getCarID() {
        return carID;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getFrameID() {
        return frameID;
    }

    public String getEngineID() {
        return engineID;
    }
    
    //setter
    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }
    //follow theo cái description
    //<ID,brand ID, color, frameID, engineID>
    //brand ?
    //lưu thì sẽ lưu brand => in ra thì in mã của hãng độ xe thôi
    @Override
    public String toString(){
        String str = String.format("%-10s, %-30s, %-15s, %6s, %6s", 
                                    carID,brand.getBrandID(),color,frameID,engineID);
        return str;
    }
    public String screenString(){
        String str = String.format("%-10s,\n%-30s, %-15s, %6s, %6s", 
                                carID, brand.getBrandID(),color,frameID,engineID);
        return str;
    }
    //
    
    //sửa tên parameter
    //so sánh xe this và xe that theo thứ tự tăng dần
    //sắp xếp tên của các hãng độ xe dựa vào tên của hãng (getBrandName) của Car
    //nếu cùng hãng thì dựa vào ID của Car(getCarID)
    @Override
    public int compareTo(Car that) {
        //tạo so sánh xe this và xe that
        
        //vào trong cái xe this => lấy ra hãng độ => lấy ra tên
        String brandNameThis = this.brand.getBrandName();
        
        //vào trong cái xe that => lấy ra hãng độ => lấy ra tên
        String brandNameThat = this.brand.getBrandName();
        
        //nếu tên của hãng độ this > that -> return 1
        if(brandNameThis.compareTo(brandNameThat) > 0){
            //nếu this > that thì ta sẽ swap
            return 1;
        }//nếu 2 tên bằng nhau thì sẽ so qua cái mã của chiếc xe
        
        else if(brandNameThis.compareTo(brandNameThat) == 0){
            //trường hợp 2 cái getBrandName = nhau
            //ta so sánh getCarID
            if(this.getCarID().compareTo(that.getCarID()) > 0){
                return 1;
            }
        }
        return -1;
    }
}
