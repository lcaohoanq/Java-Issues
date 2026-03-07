package com.example.springbootobservabilitydemo.repository;

import com.example.springbootobservabilitydemo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {


}
