package runtime;
/*
    trong 1 file java có thể có nhiều class
    nhưng chỉ có 1 class được trùng tên file và phải public
*/
public class Program {

    public static void main(String[] args) {
        Human h1 = () -> {
            System.out.println("Ahihi");
        };
        h1.show();
        
        //cách 1
        Math m1 = (int a, int b) -> {
            return a + b;
        };
        System.out.println(m1.add(5, 7));
        //cách 2
        Math m2 = (a, b) -> (a + b);
        System.out.println(m2.add(5, 7));
        
    }
}
//inner class
@FunctionalInterface
interface Human{
    public void show();
    //là một abs method vì nằm trong class interface
}

interface Math{
    public int add(int a,int b);
}