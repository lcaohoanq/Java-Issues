- Java is tough, sometimes

# Naming Convention

- Packages:
  - Always lower case
  - Package names should be unique
  - Use your internet domain name, reversed, as a prefix for the package name
    - Domain name components that are Java keywords should have that component start with an underscore
- Classes:
  - PascalCase
  - Class names should be nouns (they represend things)
  - Should start with a capital letter
  - Each word in the name should also start with a capital (LinkedList...)
- Interfaces
  - PascalCase
  - Should start with a capital letter
  - Consider what object implementing the interface will become of what they will be able to do
- Methods
  - camelCase
  - often verb
  - reflect the function performed or the result returned
- Constants
  - ALL UPPER_CASE
  - "final" keyword
- Variables:

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
