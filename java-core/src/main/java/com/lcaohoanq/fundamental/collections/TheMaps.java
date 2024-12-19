package com.lcaohoanq.fundamental.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TheMaps {

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

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Person person = (Person) o;
      return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, age);
    }
  }
  public static class Diamond{
    String type;
    public Diamond(String type){
      this.type= type;
    }
    public String getType() {
      return type;
    }
    public void setType(String type) {
      this.type = type;
    }

    @Override
    public String toString() {
      return "Diamond{" +
          "type='" + type + '\'' +
          '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Diamond diamond = (Diamond) o;
      return Objects.equals(type, diamond.type);
    }

    @Override
    public int hashCode() {
      return Objects.hash(type);
    }
  }

  public static void main(String[] args) {
//    maps();
    Map<Person,Diamond> map = new HashMap<>();
    map.put(new Person("Hoang",0612),new Diamond("Asia"));
    System.out.println(new Person("Hoang",0612).hashCode()); //will be same -2128157608
    System.out.println(new Person("Hoang",0612).hashCode()); //will be same -2128157608
    System.out.println(map.get(new Person("Hoang",0612))); //Diamond{type='Asia'}
    //!null? vi chua override hashcode, also auto override equals
    //? ta override lai hashCode va su dung no nhu tren khi tao object
    //? se gan cho no mot CCCD
  }
  private static void maps(){
    Map<Integer,Person> map = new HashMap<>();
    map.put(1,new Person("Alex", 19));
    map.put(2,new Person("B", 21));
    map.put(3,new Person("C", 39));
    //! if there have duplicate key, map will take the last element
//    map.put(3,new Person("C", 40));

    System.out.println(map);
    System.out.println(map.size());
    System.out.println(map.get(1)); //Alex, get(key)
    System.out.println(map.containsKey(4)); //false
    map.remove(3);
    System.out.println(map.keySet()); //duyet key
    //[1, 2, 3]
    System.out.println(map.entrySet()); //duyet het
    // [1=Person{name='Alex', age=19}, 2=Person{name='B', age=21}, 3=Person{name='C', age=39}]
    map.entrySet().forEach(System.out::println); //
    map.entrySet().forEach(x -> System.out.println(x.getKey() + ":" + x.getValue()));
    map.forEach((key,person)->{
      System.out.println(key + "-" + person);
    });

    System.out.println(map.get(3)); //null
    System.out.println(map.getOrDefault(3,new Person("default",0)));
    System.out.println(map.values());
  }
}
