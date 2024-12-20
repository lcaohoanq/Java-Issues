package com.lcaohoanq;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})
public class MyConfiguration {
    // Your custom configuration beans or other configurations can go here
}
