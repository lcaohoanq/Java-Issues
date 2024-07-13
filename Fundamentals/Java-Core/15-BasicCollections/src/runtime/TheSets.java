package runtime;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TheSets {

  public static class Ball {
    String ball;

    public Ball(String ball) {
      this.ball = ball;
    }

    public String getBall() {
      return ball;
    }

    public void setBall(String ball) {
      this.ball = ball;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Ball ball1 = (Ball) o;
      return Objects.equals(ball, ball1.ball);
    }

    @Override
    public int hashCode() {
      return Objects.hash(ball);
    }

    @Override
    public String toString() {
      return "Ball{" +
          "ball='" + ball + '\'' +
          '}';
    }
  }

  public static class Student {
    String name;
    int age;

    public Student(String name, int age) {
      this.name = name;
      this.age = age;
    }

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

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Student student = (Student) o;
      return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name);
    }

    @Override
    public String toString() {
      return "Student{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }

  }

  public static void main(String[] args) {
    // playWithBall();
    playWithStudent();
  }

  public static void playWithBall() {
    Set<Ball> balls = new HashSet<>();
    // TreeSet -> TreeMap
    // HashSet -> HashMap
    balls.add(new Ball("blue"));
    balls.add(new Ball("blue"));
    balls.add(new Ball("yellow"));
    balls.add(new Ball("red"));
    // ! Theo lí thuyet, set cam loai trung, nen ket qua se = 3 nhung ket qua = 4,
    // vì sao
    System.out.println(balls.size()); // 4
    // ? Vi ta chua override method equals trong class Ball
    // Trong jdk 16 se co record -> ta khong can phai lam

    balls.remove(new Ball("blue"));

    // TODO if you notice the order -> use TreeSet

    // !balls.get -> cannot use
    balls.forEach(System.out::println); // auto goi thang toString
  }

  public static void playWithStudent() {
    Set<Student> studentsList = new HashSet<>();
    studentsList.add(new Student("A", 20));
    studentsList.add(new Student("B", 21));
    studentsList.add(new Student("C", 22));
    studentsList.add(new Student("A", 23));

    System.out.println("Size = " + studentsList.size());
    for (Student item : studentsList) {
      System.out.println(item);
    }
  }

}
