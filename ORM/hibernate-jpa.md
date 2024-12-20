# Associations

| Annotation     | Description                                                                                              | When to Use                                                                                              |
|----------------|----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| @OneToMany     | Specifies a one-to-many relationship between two entities.                                               | When an entity has a collection of another entity type. Example: A `Department` has many `Employees`.    |
| @ManyToOne     | Specifies a many-to-one relationship between two entities.                                               | When multiple instances of an entity are related to a single instance of another entity. Example: Many `Employees` belong to one `Department`. |
| @OneToOne      | Specifies a one-to-one relationship between two entities.                                                | When an entity is related to exactly one instance of another entity. Example: An `Employee` has one `ParkingSpot`. |
| @ManyToMany    | Specifies a many-to-many relationship between two entities.                                              | When multiple instances of an entity are related to multiple instances of another entity. Example: `Students` enroll in many `Courses` and `Courses` have many `Students`. |

# Cascade

| CascadeType         | Description                                                                                              | When to Use                                                                                              |
|---------------------|----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| CascadeType.ALL     | All operations (PERSIST, MERGE, REMOVE, REFRESH, DETACH) are cascaded to the associated entity.          | When you want all operations on the parent entity to be cascaded to the child entities.                  |
| CascadeType.PERSIST | The persist operation is cascaded to the associated entity.                                              | When you want the child entities to be persisted when the parent entity is persisted.                    |
| CascadeType.MERGE   | The merge operation is cascaded to the associated entity.                                                | When you want the child entities to be merged when the parent entity is merged.                          |
| CascadeType.DETACH  | The detach operation is cascaded to the associated entity.                                               | When you want the child entities to be detached when the parent entity is detached.                      |
| CascadeType.REFRESH | The refresh operation is cascaded to the associated entity.                                              | When you want the child entities to be refreshed when the parent entity is refreshed.                    |
| CascadeType.REMOVE  | The remove operation is cascaded to the associated entity.                                               | When you want the child entities to be removed when the parent entity is removed.                        |

# GeneratedValue

| Strategy                            | Description                                                                                              | When to Use                                                                                              |
|-------------------------------------|----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| @GeneratedValue(strategy = GenerationType.IDENTITY) | The persistence provider must assign primary keys for the entity using a database identity column.      | When you want the database to automatically generate a unique identifier for each new entity.            |
| @GeneratedValue(strategy = GenerationType.SEQUENCE) | Uses a database sequence to generate unique primary keys.                                                | When you need a more customizable primary key generation strategy, often for databases like Oracle.      |
| @GeneratedValue(strategy = GenerationType.TABLE)    | Uses a table to ensure uniqueness across multiple entity types.                                          | When you want a table-based primary key generation strategy, often used for compatibility across different databases. |
| @GeneratedValue(strategy = GenerationType.AUTO)     | The persistence provider will choose an appropriate strategy for the particular database.                | When you want the persistence provider to automatically choose the generation strategy based on the database dialect. |

