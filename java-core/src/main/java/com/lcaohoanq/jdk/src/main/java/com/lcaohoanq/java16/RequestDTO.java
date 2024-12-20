package com.lcaohoanq.jdk.src.main.java.com.lcaohoanq.java16;

public interface RequestDTO {

    record UserDTO(String username, String password) {
    }
    
    record ProductDTO(String name, double price) {
    }
    
}