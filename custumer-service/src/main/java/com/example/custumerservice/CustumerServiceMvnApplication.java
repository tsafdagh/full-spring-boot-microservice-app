package com.example.custumerservice;

import com.example.custumerservice.data.Customer;
import com.example.custumerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustumerServiceMvnApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustumerServiceMvnApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args ->{
			customerRepository.save(new Customer(null, "Enset", "tsafic1@gmail.com"));
			customerRepository.save(new Customer(null, "tsafix", "tsafic1@gmail.com"));
			customerRepository.save(new Customer(null, "tsafdagh", "tsafic1@gmail.com"));
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
