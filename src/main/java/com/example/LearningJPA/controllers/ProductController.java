package com.example.LearningJPA.controllers;


import com.example.LearningJPA.entities.Product;
import com.example.LearningJPA.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(path="/usingSortBy")
    List<Product> getProductUsingSortBY(@RequestParam(defaultValue = "id") String sortBy){
        return productRepository.findAll(Sort.by(Sort.Order.desc(String.valueOf(sortBy))));
    }

    @GetMapping(path="/findAll")
    Page<Product> getAllProducts(){

        Pageable pageable= PageRequest.of(1,2);
        return productRepository.findAll(pageable);
    }
}
