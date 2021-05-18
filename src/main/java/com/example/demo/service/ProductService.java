package com.example.demo.service;


import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(Product product) { productRepository.delete(product);}

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product find(Long id) {
        return productRepository.findById(id).get();
    }
}
