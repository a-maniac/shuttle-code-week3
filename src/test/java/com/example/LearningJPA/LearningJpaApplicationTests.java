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
		Product product=Product.builder().sku("nestle")
						.title("nestle chochlate").price(BigDecimal.valueOf(13.22))
						.quantity(4).build();
		Product savedProduct=productRepository.save(product);
		System.out.println(savedProduct);
	}

	@Test
	void getAllProduct(){
		List<Product> productList=productRepository.findAll();
		System.out.println(productList);
	}

}
