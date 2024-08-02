package com.example.LearningJPA.repositories;

import com.example.LearningJPA.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findBySku(String sku);

    List<Product> findByOrderByPriceDesc();
}
