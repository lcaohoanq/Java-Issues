FROM docker.io/library/maven:3.8.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy the pom and just one file from the source to cache the maven dependencies
# If you change the pom, the dependencies will be re-downloaded
COPY pom.xml .
COPY src/main/java/com/example/springbootobservabilitydemo/SpringBootObservabilityDemoApplication.java /app/src/main/java/com/example/springbootobservabilitydemo/SpringBootObservabilityDemoApplication.java
RUN mvn package

# Copy the rest of the source files
# .dockerignore is set to ignore the "target" directory, if it already exists
COPY . .
RUN mvn package -DskipTests=true

# ---
# The final image
FROM docker.io/library/eclipse-temurin:17-jre

WORKDIR /app

RUN curl -o /app/opentelemetry-javaagent.jar -L https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.29.0/opentelemetry-javaagent.jar

ENV JAVA_OPTS=-javaagent:/app/opentelemetry-javaagent.jar
ENV OTEL_SERVICE_NAME=supershop-cart

# Copy the compiled backend files from the backend-build stage
COPY --from=build /app/target/spring-boot-observability-demo*.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "app.jar"]
