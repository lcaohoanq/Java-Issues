package com.lcaohoanq.fundamental.exam;
/*
    Brand là khuôn đúc ra các hãng độ xe
    +: public 
    _: private
    $: protected
*/
public class Brand {
    //props
    private String brandID;
    private String brandName;
    private String soundBrand;
    private double price;

    public Brand(String brandID, String brandName, String soundBrand, double price) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }
    
    //empty constructor
    public Brand() {
    }
    
    //getter
    public String getBrandID() {
        return brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public double getPrice() {
        return price;
    }
    
    //setter
    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    ///toString
    @Override
    public String toString() {
        String str = String.format("%-10s, %-30s, %-15s: %.3f", brandID,brandName,soundBrand,price);
        return str;
    }
}
