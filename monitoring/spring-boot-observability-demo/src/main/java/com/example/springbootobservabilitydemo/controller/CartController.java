package com.example.springbootobservabilitydemo.controller;

import com.example.springbootobservabilitydemo.dto.AddToCartResult;
import com.example.springbootobservabilitydemo.model.Cart;
import com.example.springbootobservabilitydemo.model.CartItem;
import com.example.springbootobservabilitydemo.repository.CartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartRepository cartRepository;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Cart> createCart() {
        Cart cart = new Cart();
        cartRepository.save(cart);
        return ResponseEntity.ok(cart);
    }

    @GetMapping(path = "")
    public ResponseEntity<Iterable<Cart>> getAllCarts() {
        Iterable<Cart> carts = cartRepository.findAll();
        return ResponseEntity.ok(carts);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Cart> getCart(@PathVariable("id") Long id) {
        Cart cart = cartRepository.findById(id).orElse(null);
        System.out.println();

        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Expects application/x-www-form-urlencoded
    // e.g. sku=123&quantity=2
    @PostMapping(path = "/{id}/items", consumes = "application/x-www-form-urlencoded",
            produces = "application/json",
            params = {"sku", "quantity"})
    public ResponseEntity<Cart> addItemToCart(@PathVariable("id") Long id,
                                                         @RequestParam("sku") String sku,
                                                         @RequestParam("quantity") int quantity) {
        logger.info("Adding item to cart, cart={} sku={} quantity={}", id, sku, quantity);

        Cart cart = cartRepository.findById(id).orElse(null);

        if (cart != null) {
            CartItem item = new CartItem();
            item.setSku(sku);
            item.setQuantity(quantity);
            cart.addItem(item);
            cartRepository.save(cart);

            logger.info("Cart {}", cart);
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}/items/{itemId}", produces = "application/json")
    public ResponseEntity<Cart> deleteItemFromCart(@PathVariable("id") Long id,
                                                   @PathVariable("itemId") Long itemId) {
        Cart cart = cartRepository.findById(id).orElse(null);

        if (cart != null) {
            CartItem item = cart.getItems().stream().filter(i -> i.getId().equals(itemId)).findFirst().orElse(null);

            if (item != null) {
                cart.getItems().remove(item);
                cartRepository.save(cart);
                return ResponseEntity.ok(cart);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Cart> deleteCart(@PathVariable("id") Long id) {
        Cart cart = cartRepository.findById(id).orElse(null);

        if (cart != null) {
            cartRepository.delete(cart);
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
