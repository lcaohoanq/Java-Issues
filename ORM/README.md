# Setup

- Include the dependencies

```java
 <dependencies>
    <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.30</version>
      <scope>provided</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
    <dependency>
      <groupId>org.hibernate.orm</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>6.5.2.Final</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/jakarta.persistence/jakarta.persistence-api -->
    <dependency>
      <groupId>jakarta.persistence</groupId>
      <artifactId>jakarta.persistence-api</artifactId>
      <version>3.1.0</version>
    </dependency>
    <!-- H2 Database -->
    <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <version>2.1.214</version>
    </dependency>
  </dependencies>
```

- Config build for `persistence.xml`

```java
<build>
    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <filtering>false</filtering>
        <includes>
          <include>**/persistence.xml</include>
        </includes>
        <targetPath>${project.build.outputDirectory}</targetPath>
      </resource>
    </resources>
    <pluginManagement>
      <plugins>
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
          <executions>
            <execution>
              <id>copy-resources</id>
              <phase>process-resources</phase>
              <goals>
                <goal>copy-resources</goal>
              </goals>
              <configuration>
                <outputDirectory>${project.build.outputDirectory}</outputDirectory>
                <resources>
                  <resource>
                    <directory>${project.basedir}</directory>
                    <includes>
                      <include>.env</include>
                    </includes>
                  </resource>
                </resources>
              </configuration>
            </execution>
          </executions>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
```

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

## hibernate.hbm2ddl.auto
| Value       | Action                                                                                  | Use Case                                           |
|-------------|-----------------------------------------------------------------------------------------|----------------------------------------------------|
| `none`      | No action                                                                               | Manual schema management                           |
| `validate`  | Validate the schema against entity mappings                                             | Production validation without altering schema      |
| `update`    | Update the schema to match entity mappings (add new tables/columns, don't remove)       | Development environments to apply changes incrementally |
| `create`    | Drop the existing schema and create a new one                                           | Fresh schema for each run, losing all existing data |
| `create-drop` | Create schema at startup and drop it at shutdown                                       | Integration testing with automatic cleanup         |