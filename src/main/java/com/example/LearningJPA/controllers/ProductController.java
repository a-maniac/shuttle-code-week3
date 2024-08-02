package com.example.LearningJPA.controllers;


import com.example.LearningJPA.entities.Product;
import com.example.LearningJPA.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/product")
public class ProductController {

    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path="/")
    List<Product> getProduct(){
        return productRepository.findByOrderByPriceDesc();
    }
}
