# Java Bean

A JavaBean is just a standard. It is a regular Java class, except it follows certain conventions:

- All properties are private
- Public getters/setters
- A public no-argument constructor (public all-argument constructor, optional)
- Implements Serializable.

```java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable  {
  private int age;
  private String name;
}
```

## So, why we need to follow:
  - The 'beans' of JavaBeans are classes that encapsulate one or more objects into a single standardized object (the bean).
This standardization allows the beans to be handled in a more generic fashion, allowing easier code reuse and introspection

# POJO

- What is POJO?
 - Can't Extend anything
 - Can't Implement anything
 - No outside annotaion

```java
public class Cat {

  int age;
  String name;

}
```

```java
public class Cat implements Animals {

  int age;
  String name;

  @Override
  public void run(){
    System.out.println(String.format("%s can be run", this.name));
  }

}
```
# DTO (Data Transfer Object)
