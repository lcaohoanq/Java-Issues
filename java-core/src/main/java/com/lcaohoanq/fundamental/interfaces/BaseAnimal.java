public abstract class BaseAnimal {
    protected String name;
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    abstract void getColor();

    @Override
    public String toString() {
        return "BaseAnimal{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
