package runtime;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;


public class TheQueues {

  public static class Person {

    String name;
    int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return "Person{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }

  public static void main(String[] args) {
//    playWithQueue();
    playWithLinkedList();
  }

  private static void playWithQueue(){
    Queue<Person> superMarket = new LinkedList<>();
    superMarket.add(new Person("Hoang",19));
    superMarket.add(new Person("Ngoc",5));
    superMarket.add(new Person("Lien",42));

    System.out.println("Size " + superMarket.size()); //3
    System.out.println("Using peek " + superMarket.peek().toString()); //Lay ra thang dau tien
    System.out.println("Using poll " + superMarket.poll().toString()); //xoa thang dau tien, return no
    System.out.println("Size " + superMarket.size()); //2

    //? poll giong remove
    //? nhung remove se throw exception if queue is empty
    //Chi can dung mot thoi duoc roi, ta se dung poll roi check isEmpty

    //! offer: dung trong van de capacity restrictions queue
  }
  private static void playWithLinkedList(){
    LinkedList<Person> linkedList = new LinkedList<>();
    linkedList.add(new Person("Alex",21));
    linkedList.add(new Person("Hoang",19));
    linkedList.addFirst(new Person("Vy",19));
    ListIterator<Person> personListIterator = linkedList.listIterator();
    //hasNext, hasPrevious
    while(personListIterator.hasNext()){
      System.out.println(personListIterator.next());
    }
    while(personListIterator.hasPrevious()){
      System.out.println(personListIterator.previous());
    }

  }

}
