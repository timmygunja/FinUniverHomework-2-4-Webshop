package com.example.demo.service;


import com.example.demo.entity.CartProduct;
import com.example.demo.repository.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartProductService {
    @Autowired
    private CartProductRepository cartProductRepository;

    public void save(CartProduct cartProduct) {
        cartProductRepository.save(cartProduct);
    }

    public void delete(CartProduct cartProduct) { cartProductRepository.delete(cartProduct);}

    public List<CartProduct> findAll() {
        return cartProductRepository.findAll();
    }

    public CartProduct find(Long id) {
        return cartProductRepository.findById(id).get();
    }
}
