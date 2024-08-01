package com.example.LearningJPA;

import com.example.LearningJPA.entities.Product;
import com.example.LearningJPA.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class LearningJpaApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		Product product=Product.builder().sku("nestles")
						.title("nestle chochlate").price(BigDecimal.valueOf(23.42))
						.quantity(1).build();
		Product savedProduct=productRepository.save(product);
		System.out.println(savedProduct);
	}

	@Test
	void getAllProduct(){
		List<Product> productList=productRepository.findAll();
		System.out.println(productList);
	}

	@Test
	void getBySKU(){
		Product product=productRepository.findBySku("nestles");
		System.out.println(product);
	}


}
