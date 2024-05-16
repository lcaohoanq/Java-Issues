package runtime;

import data.Herbivore;
import data.Horse;
import data.Hunter;
import data.Monkey;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Monkey m1 = new Monkey("Rafiki", 1998, 210);
        Monkey m2 = new Monkey("Abu", 1994, 30);
        Horse h1 = new Horse("Rarity", 2015, 9,"none");
        Herbivore h2 = new Horse("Roach", 2019, 170, "Grey");
        //Đúc một động vật ăn cỏ từ khuôn ngựa
        
//        Herbivore stuList[] = {m1,m2,h1,h2}; //mảng nguyên thủy, size = 4
        
//        Herbivore stuList[] = new Herbivore[4];
//        stuList[0] = m1;
//        stuList[1] = m2;
        
        ArrayList<Herbivore> stuList = new ArrayList<>();
        
        stuList.add(m1);
        stuList.add(m2);
        stuList.add(h1);
        stuList.add(h2);
        
//        for (Herbivore item : stuList) {
//            item.showLearningOutcomes();
//        }
        
        //bàn riêng về nhà Herbivore
        //trong một ngày trời lạnh vô cùng
        //các bạn học đang lạnh co ro
        //thì có 1 bạn thú nhỏ, chậm chạp đi vào
        //vì lạnh nên bạn mặc kín mít, không biết bạn là con gì
        //nhưng mà bạn chậm chạp thì mình nghĩ bạn hiền
        //bạn chỉ ăn lá cây thôi, đích thị bạn là động vật ăn cỏ
        
        //đoán được sương sương, không biết là con gì
        
        //dùng annonymous để tạo cho nhanh => vì biết nó là con gì đâu
        
        Herbivore xxx = new Herbivore("Con chậm chạp", 2021, 10) {
            @Override
            public double study() {
                return 80;
            }
            
            @Override
            public void showLearningOutcomes() {
                String str = String.format("XXX       |%-15s|%4d|%6.2f|%6.2f",
                                        name,yob,weight,study());
                System.out.println(str);
            }
        }; //nhớ đóng hàm
        
        stuList.add(xxx);
        
        //lớp học có thêm bạn mới, lớp học trở trở nên sôi động
        //lập tức có một người đến học => BÁC THỢ SĂN
        //cần phải lưu trữ bác thợ săn
        
        Hunter hun1 = new Hunter("Thợ săn vượn", 1999, 0, "Nỏ");
        Hunter hun2 = new Hunter("Mắt diều hâu", 1999, 0, "Cung");
        
        //2:00:55
        
        
    }
}
