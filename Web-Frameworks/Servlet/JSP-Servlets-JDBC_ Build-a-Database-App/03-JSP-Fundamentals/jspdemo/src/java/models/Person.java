package models;

public class Person {
    private String name;
    private int yob;

    public Person(String name, int yob) {
        this.name = name;
        this.yob = yob;
    }

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", yob=" + yob + '}';
    }
    
    
}