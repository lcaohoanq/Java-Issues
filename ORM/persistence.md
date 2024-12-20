# persistence.xml

- Place at `src/main/resources/META-INF/persistence.xml`
- Spring Boot project will config in `application.properties`

- Sample with H2 database

```java
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="https://jakarta.ee/xml/ns/persistence" version="3.1">
  <persistence-unit name="my-persistence-unit"  transaction-type="RESOURCE_LOCAL">
    <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
    <class>onetoone.Department</class> 
    <class>onetoone.Employee</class>
    <properties>
      <property name="jakarta.persistence.jdbc.url" value="jdbc:h2:mem:testdb" />
      <property name="jakarta.persistence.jdbc.user" value="sa" />
      <property name="jakarta.persistence.jdbc.password" value="" />
      <property name="jakarta.persistence.jdbc.driver" value="org.h2.Driver" />
      <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect" />
      <property name="hibernate.hbm2ddl.auto" value="create-drop" />
      <property name="hibernate.show_sql" value="true" />
      <property name="hibernate.format_sql" value="true" />
    </properties>
  </persistence-unit>
</persistence>
```

## hibernate.show_sql

- true | false: show | hide all sql query while hibernate, jpa fetching, manipulating data 

## hibernate.hbm2ddl.auto

| Value       | Action                                                                                  | Use Case                                           |
|-------------|-----------------------------------------------------------------------------------------|----------------------------------------------------|
| `none`      | No action                                                                               | Manual schema management                           |
| `validate`  | Validate the schema against entity mappings                                             | Production validation without altering schema      |
| `update`    | Update the schema to match entity mappings (add new tables/columns, don't remove)       | Development environments to apply changes incrementally |
| `create`    | Drop the existing schema and create a new one                                           | Fresh schema for each run, losing all existing data |
| `create-drop` | Create schema at startup and drop it at shutdown                                       | Integration testing with automatic cleanup         |
