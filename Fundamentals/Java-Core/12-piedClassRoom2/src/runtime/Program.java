package runtime;

import data.Herbivore;
import data.Horse;
import data.Hunter;
import data.Monkey;
import data.StudentEnthusiasts;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Monkey m1 = new Monkey("Rafiki", 1998, 2.1);
        Monkey m2 = new Monkey("Abu", 1994, 1.2);
        Horse h1 = new Horse("Rarity", 2015, 9, "none");
        Herbivore h2 = new Horse("Roach", 2019, 170, "Grey");
        Hunter hun1 = new Hunter("Thợ săn vượn", 1999, 65, "Nỏ");
        
        //Dấu <> (generic) biểu hiện khả năng tùy biến của mảng
        ArrayList<StudentEnthusiasts> stuList = new ArrayList<>(); 
        
        stuList.add(h1);
        stuList.add((Horse)h2);
        stuList.add(hun1);
        
        //có một học sinh mới đến, đó là con lười
        //tưởng mới mà lại cũ 
        //con lười này là con trùm kín mít
        //1. tạo class Sloth, rồi dùng class Sloth implements studentEnthu
        // dùng class Sloth tạo con lười [tạm]
        // Tất cả con lười đều sẽ ham học - vô lý
        
        //2. tránh ảnh hưởng giống loài tạo ra chú lười đặc biệt
        //      từ hội ham học, thay vì dùng class Sloth
        
        StudentEnthusiasts xxx = new StudentEnthusiasts() {
            @Override
            public double studyHard() {
                return 80 * 1.5;
            }

            @Override
            public void showProfile() {
                String str = String.format("Sloth        |%-15s|%4d|%6.2f|%6.2f",
                                            "Flash", 2017, 12.7f, studyHard());
                System.out.println(str);
            }
        };
        
        stuList.add(xxx);
        
        for (StudentEnthusiasts item : stuList) {
            item.showProfile();
        }
        
    }
}
