package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication // This annotation tells Spring that this is the main class
@RestController // This annotation tells Spring that this is a controller
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    @GetMapping("/") //Get request at the root path
//    public String greet() {
//        return "Home Page";
//    }

    @GetMapping("/hello") //Get request at the localhost:4000/hello
    public HelloResponse hello() {
        return new HelloResponse(
                "Hello World",
                List.of("Java", "Kotlin", "C++"),
                new Person("Huy", 20, 1000.0));
    }

    record Person(String name, int age, double savings) {}

    record HelloResponse(
            String message,
            List<String> favProgrammingLanguages,
            Person person) {

    }

/*    class HelloResponse {
        private final String message;

        public HelloResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return "HelloResponse{" +
                    "message='" + message + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HelloResponse that = (HelloResponse) o;
            return Objects.equals(message, that.message);
        }

        @Override
        public int hashCode() {
            return Objects.hash(message);
        }
    }*/
    // 2 method trên đều là một cách để trả về một JSON object
    //Trong Maven thì có thư viện Jackson để convert object sang JSON
    //Jakson sẽ convert object sang JSON bằng cách gọi getter của object
    //Jakson là JSON for Java

    //Tại sao ta lại nhận được respone, vì có getter
    //nếu không có getter thì sẽ không nhận được respone
}
