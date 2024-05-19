package runtime;

/**
 *
 * @author Admin
 */
public class Student {
    private String id;
    private String name;
    private int yob;

    public Student() {
    }

    public Student(String id, String name, int yob) {
        this.id = id;
        this.name = name;
        this.yob = yob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", yob=" + yob + '}';
    }
    
    
}
