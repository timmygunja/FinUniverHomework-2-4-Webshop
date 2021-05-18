package com.example.demo.service;


import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    public void delete(Cart cart) { cartRepository.delete(cart);}

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Cart find(Long id) {
        return cartRepository.findById(id).get();
    }
}
