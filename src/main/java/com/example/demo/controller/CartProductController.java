package com.example.demo.controller;


import com.example.demo.entity.CartProduct;
import com.example.demo.service.CartProductService;
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
public class CartProductController {
    private final CartProductService cartProductService;

    @Autowired
    public CartProductController(CartProductService cartProductService) {
        this.cartProductService = cartProductService;
    }

    @PostMapping(value = "/cartproducts")
    public ResponseEntity<?> create(@RequestBody CartProduct cartProduct) {
        cartProductService.save(cartProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(value = "/cartproducts")
    public ResponseEntity<?> update(@RequestBody CartProduct newCartProduct) {
        CartProduct cartProduct = cartProductService.find(newCartProduct.getId());
        cartProduct.setQuantity(newCartProduct.getQuantity());
        cartProduct.setProduct(newCartProduct.getProduct());
        cartProductService.save(cartProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/cartproducts/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        CartProduct cartProduct = cartProductService.find(id);
        cartProductService.delete(cartProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/cartproducts")
    public ResponseEntity<List<CartProduct>> findAll() {
        final List<CartProduct> cartProductList = cartProductService.findAll();

        return cartProductList != null && !cartProductList.isEmpty()
                ? new ResponseEntity<>(cartProductList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/cartproducts/{id}")
    public ResponseEntity<CartProduct> find(@PathVariable(name = "id") Long id) {
        final CartProduct cartProduct = cartProductService.find(id);

        return cartProduct != null
                ? new ResponseEntity<>(cartProduct, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
