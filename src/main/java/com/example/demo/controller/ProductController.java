package com.example.demo.controller;


import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@JsonAutoDetect
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private final  ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/products")
    public ResponseEntity<?> create(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(value = "/products")
    public ResponseEntity<?> update(@RequestBody Product newProduct) {
        Product product = productService.find(newProduct.getId());
        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        product.setPrice(newProduct.getPrice());
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Product product = productService.find(id);
        productService.delete(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> findAll() {
        final List<Product> productList = productService.findAll();

        return productList != null && !productList.isEmpty()
                ? new ResponseEntity<>(productList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> find(@PathVariable(name = "id") Long id) {
        final Product product = productService.find(id);

        return product != null
                ? new ResponseEntity<>(product, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
