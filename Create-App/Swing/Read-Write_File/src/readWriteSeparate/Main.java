package readWriteSeparate;

public class Main {
    public static void main(String[] args) {
        StudentManagement stum = new StudentManagement();
        
        String url1 = "src/readWriteSeparate/st.txt";
        
        String url2 = "src/readWriteSeparate/st2.txt";
        
        stum.loadFromFile(url1);
        
        stum.writeToFile(url2);
    }
}
