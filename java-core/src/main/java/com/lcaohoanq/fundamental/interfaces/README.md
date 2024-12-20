# Interface

- An interface is a reference type in Java. It is similar to class. It is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface.

## Interface's Properties
- Cannot initialize
- No constructors
- All fields are implicitly `public`, `static`, `final`
- All method are implicitly`abstract`
- Can not be inherited by a class, but can be implemented by a class
- Can be inherited by another interface

## Marker (Tagged) Interface

- Tạo một cha chung: Như với EventListener interface, mà được kế thừa bởi hàng tá các interface khác trong Java API, bạn có thể sử dụng một tagging interface để tạo một cha chung cho một nhóm interface. Ví dụ, khi một interface kế thừa EventListener, thì JVM biết rằng interface cụ thể này đang được sử dụng trong một event.
- Thêm một kiểu dữ liệu tới một class: Đó là khái niệm tagging. Một class mà triển khai một tagging interface không cần định nghĩa bất kỳ phương thức nào, nhưng class trở thành một kiểu interface thông qua tính đa hình (polymorphism).

```java
public interface Serializable {
}

```

## Nested Interface

- An interface can be declared a member of a class or another interface. Such an interface is called a member interface or a nested interface.

```java

interface Showable {
    void show();
    interface Message {
        void msg();
    }
}

```