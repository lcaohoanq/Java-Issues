package runtime;

public enum MyEnum {
    DAT_HANG(5),
    CHUAN_BI(15),
    GIAO_HANG(10); //kết thúc bằng dấu semicolon
    
    //thêm các trường final vào Enum, ta cần phải tạo constructor để đúc trường đó
    //và phải bổ sung các trường đó vào Enum ()
    
    final int thoiGian;

    MyEnum(int thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getThoiGian() {
        return thoiGian;
    }
    
    
    
}
