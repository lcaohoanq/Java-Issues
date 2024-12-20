# Required 
- MySQL Connector Java 
- MySQL Connector/J
- Dotenv Java `3.0.0`
```
/media/lcaohoanq/DATA/PERSONAL/java/Others/connect-to-dbms/maven/mysql-connector/src/main/java/EnvUtils.java
java: cannot access io.github.cdimascio.dotenv.Dotenv
  bad class file: /home/lcaohoanq/.m2/repository/io/github/cdimascio/dotenv-java/3.0.0/dotenv-java-3.0.0.jar!/io/github/cdimascio/dotenv/Dotenv.class
    class file has wrong version 55.0, should be 52.0
    Please remove or make sure it appears in the correct subdirectory of the classpath.
```
## Cause this error when using Dotenv with Java 8
- You can upgrade your Java version to 11 or higher, i'm choosing the version `18`
- Or you can use the older version of Dotenv, follow the author
> https://github.com/cdimascio/dotenv-java
