# Prometheus, Grafana, and Spring Boot Setup Guide
## 1. Spring Boot Configuration
   Ensure your pom.xml includes the necessary dependencies:
```xml
   <dependencies>
       <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-actuator</artifactId>
       </dependency>
       <dependency>
          <groupId>io.micrometer</groupId>
          <artifactId>micrometer-registry-prometheus</artifactId>
       </dependency>
   </dependencies>
```
## 2. Docker Compose

Create a docker-compose.yml file in the root of your project:
```yaml
services:
  prometheus:
    image: prom/prometheus
    container_name: prometheus-container
    ports:
      - "9090:9090"
    volumes:
      - ./config/prometheus:/etc/prometheus
    networks:
      - prometheus-grafana-network

  grafana:
    image: grafana/grafana
    container_name: grafana-container
    ports:
      - "3000:3000"
    environment:
      - GF_SECURITY_ADMIN_USER=admin
      - GF_SECURITY_ADMIN_PASSWORD=admin
    networks:
      - prometheus-grafana-network

networks:
  prometheus-grafana-network:
```

## 3. Prometheus Configuration
Ensure `prometheus.yml` it's located in ./config/prometheus/prometheus.yml relative to your docker-compose.yml.
## 4. Grafana Configuration
   Create a datasources.yml file in ./config/grafana/provisioning/datasources/:
```yaml
apiVersion: 1

datasources:
- name: Prometheus
  type: prometheus
  access: proxy
  url: http://prometheus:9090
  isDefault: true
```
## 5. Start the Services
```bash
docker-compose up -d
```

## 6. Access Grafana

Open a web browser and go to http://localhost:3000
Log in with username admin and password admin
You'll be prompted to change the password on first login

## 7. Import Dashboard

In Grafana, click on the "+" icon in the left sidebar and select "Import"
- Enter dashboard ID `4701` for a JVM Micrometer dashboard
Select "Prometheus" as the data source
Click "Import"

- Or import directly json file `config/jvm-micrometer.json`

## 8. View Metrics

Start your Spring Boot application
Make some requests to your /test endpoint
Wait a few minutes for data to be collected
Refresh your Grafana dashboard to see the metrics

Troubleshooting

If you don't see any data, check that your Spring Boot app is exposing metrics at http://localhost:8080/actuator/prometheus
Ensure Prometheus can reach your Spring Boot app. You might need to adjust the targets in prometheus.yml based on your network setup
Check Prometheus targets at http://localhost:9090/targets to ensure it's scraping data successfully