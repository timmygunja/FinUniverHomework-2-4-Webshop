package com.example.demo.controller;


import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@JsonAutoDetect
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "/carts")
    public ResponseEntity<?> create(@RequestBody Cart cart) {
        cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(value = "/carts")
    public ResponseEntity<?> update(@RequestBody Cart newCart) {
        Cart cart = cartService.find(newCart.getId());
        cart.setProfile(newCart.getProfile());
        cart.setProductList(newCart.getProductList());
        cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/carts/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Cart cart = cartService.find(id);
        cartService.delete(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/carts")
    public ResponseEntity<List<Cart>> findAll() {
        final List<Cart> cartList = cartService.findAll();

        return cartList != null && !cartList.isEmpty()
                ? new ResponseEntity<>(cartList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/carts/{id}")
    public ResponseEntity<Cart> find(@PathVariable(name = "id") Long id) {
        final Cart cart = cartService.find(id);

        return cart != null
                ? new ResponseEntity<>(cart, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
