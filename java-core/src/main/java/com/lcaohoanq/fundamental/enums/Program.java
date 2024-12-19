package com.lcaohoanq.fundamental.enums;

//enum đặt tên theo UpperCammelCase
//enum được kế thừa java.lang.Enum
enum PizzaStatus{
    DAT_HANG(5),
    CHUAN_BI(15),
    GIAO_HANG(10); //kết thúc bằng dấu semicolon
    
    //thêm các trường final vào Enum, ta cần phải tạo constructor để đúc trường đó
    //và phải bổ sung các trường đó vào Enum ()
    
    final int thoiGian;

    private PizzaStatus(int thoiGian) {
        this.thoiGian = thoiGian;
    }
    
    
}

public class Program {
    
    public static void main(String[] args) {
        PizzaStatus status = PizzaStatus.DAT_HANG; //truy cập trực tiếp tới DAT_HANG
        if(status == PizzaStatus.DAT_HANG){
            System.out.println("Pizza đã được đặt");
        }
        for (PizzaStatus item : PizzaStatus.values()) {
            System.out.println(item); 
            /*
            DAT_HANG
            CHUAN_BI
            GIAO_HANG
            */
        }
        
        System.out.println(PizzaStatus.GIAO_HANG.thoiGian);
        
        System.out.println("My Enum");
        for (MyEnum item : MyEnum.values()) {
            System.out.println(item + " " + item.getThoiGian());
        }
    }
    
}
