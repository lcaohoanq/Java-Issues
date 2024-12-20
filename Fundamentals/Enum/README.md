# Persisting Enum in JPAs (https://www.baeldung.com/jpa-persisting-enums-in-jpa)

- When using Spring Boot, you can use `@Enumerated` annotation to map enum type to database column.

```java

@Entity
@Table(name = "users")
public class User {
    @Enumerated(EnumType.STRING) //When using EnumType.STRING, the enum value will be stored as a string in the database
    @Enumerated(EnumType.ORDINAL) //When using EnumType.ORDINAL, the enum value will be stored as an integer in the database
    private Role role;
}

public enum Role {
    ADMIN, USER
}

@Getter
@AllArgsConstructor
public enum RoleWithDescription {
    ADMIN("Administrator"),
    USER("User");
    
    private final String description;
}
```


```java
User user = new User();
user.setRole(Role.ADMIN); //0: EnumType.ORDINAL, ADMIN: EnumType.STRING
```

- Problem when using EnumType.Ordinal:
    - If you add a new enum value in the middle of the enum list, the ordinal value of the existing enum values will change.
    - If you remove an enum value, the ordinal value of the existing enum values will change.
    - If you change the order of the enum values, the ordinal value of the existing enum values will change.
    - If you use EnumType.ORDINAL, you should not change the order of the enum values or remove any enum value.
- Solution: Use EnumType.STRING
- When using EnumType.STRING, the enum value will be stored as a string in the database. This approach is more flexible than EnumType.ORDINAL because it does not depend on the order of the enum values.
- But it has a disadvantage: 
    - the string value is less efficient than the integer value, take up more space in the database, and are slower to compare.
    - cannot change the string value after the persisted in the database.