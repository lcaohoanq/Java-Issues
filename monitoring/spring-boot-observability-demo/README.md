# Spring Boot Observability Demo (with Grafana Cloud)

This repository contains a demo app that showcases how to configure a Java Spring Boot application to send metrics, logs and traces to Grafana Cloud (with OpenTelemetry).

## Prerequisites

To run the included all-in-one demo with Compose, you'll need:

- [Docker](https://www.docker.com/) or [Podman](https://podman.io/)

Optionally, to hack on the app and build it yourself:

- [Java 17](https://whichjdk.com/)
- [Maven](https://maven.apache.org/)

## Getting started, using Grafana Cloud

1. Clone this repository

1. Create a [Grafana Cloud](https://grafana.com/products/cloud/) account
 
1. Create a new [Grafana Cloud API key](https://grafana.com/docs/grafana-cloud/account-management/authentication-and-permissions/create-api-key/)

1. Using the included `.env.example` file as an example, create a new `.env` file for Compose in the root of the repository and fill in the values for your Grafana Cloud API key and Logs/Metrics/Traces usernames:

    ```
    cp .env.example .env
    vi .env
    ```

1. Bring up the app, database and Grafana Agent with Compose:

    ```
    docker-compose up -d
   
    # or, if you prefer podman
    podman-compose up -d
    ```
   
    When the app is starting up, you may see some errors from Spring Boot in the logs. This is normal and will go away once PostgreSQL has started up.

1.  Test the app. Create a cart and add some items, then view the cart:

    ```
    curl -X POST localhost:8080/api/carts
    
    curl -X POST localhost:8080/api/carts/1/items -d sku=FISH -d quantity=7
    curl -X POST localhost:8080/api/carts/1/items -d sku=POTATOES -d quantity=55
    
    curl localhost:8080/api/carts/1
    ```

    Or, if you have k6 installed, you can run the included script to simulate some traffic to your app!

    ```
    k6 run loadtest/script.js
    ```
    
## Just running the API

If you just want to run the API without any telemetry or connection to Grafana Cloud, you can do so by running:

```
SPRING_PROFILES_ACTIVE=local mvn clean spring-boot:run
```

This will start the API on port 8080, and use an in-memory H2 database (instead of PostgreSQL).
