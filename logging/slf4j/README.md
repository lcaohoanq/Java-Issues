- Without Lombok, Slf4j need to declare a logger object in each class 
```java
private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Main.class);
```
- With Lombok, we can use @Slf4j annotation to generate a logger object.