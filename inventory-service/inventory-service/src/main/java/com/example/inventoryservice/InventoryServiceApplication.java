package com.example.inventoryservice;

import com.example.inventoryservice.data.Product;
import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args ->{
			productRepository.save(new Product(null, "Computer", 10));
			productRepository.save(new Product(null, "Television", 500));
			productRepository.save(new Product(null, "Air conditional", 4500));
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
