package runtime;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TheArrays {

  public static void main(String[] args) {
    String[] names = new String[3];
    names[0] = "John";
    names[1] = "Mary";
    names[2] = "Hoàng";

    System.out.println(names.toString());
    System.out.println(names); //in địa chỉ
    System.out.println(Arrays.toString(names));

    System.out.println("Duyệt xuôi bằng for");
    for(int i = 0; i <= names.length - 1; i++){
      //i < names.length
      System.out.println(names[i]);
    }

    System.out.println("Duyệt ngược bằng for");
    for(int i = names.length-1; i >= 0; i--){
      System.out.println(names[i]);
    }

    System.out.println("Duyệt bằng forEach");
    //for (Data type | name : Current Arrays)
    for(String item: names){
      System.out.println(item);
    }

    System.out.println("Traversal by stream");
    Arrays.stream(names).forEach(System.out::println);
  }
}
