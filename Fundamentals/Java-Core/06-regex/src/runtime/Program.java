
package runtime;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Program {

    public static void main(String[] args) {
//        
//        Pattern pattern = Pattern.compile("[a-zA-Z]{3}");
//        Matcher matcher = pattern.matcher("The hackerrank team is on a mission to flatten the world by restructuring the DNA of every company on the planet. We rank programmers based on their coding skills, helping companies source great programmers and reduce the time to hire. As a result, we are revolutionizing the way companies discover and evaluate talented engineers. The hackerrank platform is the destination for the best engineers to hone their skills and companies to find top engineers.");
        
//        TestString ts = new TestString();
        
//       sử dụng global flag (multiple line)
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }

        Scanner sc = new Scanner(System.in);
        
        Pattern p = Pattern.compile("^[A-Z]{5}[\\d]{4}[A-Z]{1}$");

        
        while(true){
            String str = sc.nextLine();
            if(str.length() == 10){
                if(p.matcher(str).find()){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
        
        
        
    }
    
}
