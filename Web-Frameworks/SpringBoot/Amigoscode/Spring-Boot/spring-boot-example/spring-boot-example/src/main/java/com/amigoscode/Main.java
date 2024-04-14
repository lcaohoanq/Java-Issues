package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//special annotation that tells Spring Boot that this is the starting point of the application
//without this annotation, Spring Boot will not know where to start
@SpringBootApplication

// @springbootapplication = @configuration + @enableautoconfiguration +
// @componentscan
// annotation @configuration: class nay chua cac bean
// annotation @enableautoconfiguration: spring boot tu dong config cac bean
// annotation @componentscan: chi dinh cac package de scan cac bean
// @ComponentScan(basePackages = "com.amigoscode")

@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Server đang chạy trên PORT 8080");
    }

    // tao 1 method de test, annotation @GetMapping("/hello") de map method nay voi
    // url /hello
    // another annotation @RestController de bao Spring Boot rang day la 1
    // controller
    // path: / -> Home
    @GetMapping("/")
    public String home() {
        return "Home";
    }

    // path: /hello -> Hello World
    @GetMapping("/hello")
    public GreetResponse greet() {
        return new GreetResponse("Hello World");
    }

    record GreetResponse(String message) {
    }
}
