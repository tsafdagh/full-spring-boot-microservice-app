package com.example.billingservice;

import com.example.billingservice.data.Bill;
import com.example.billingservice.data.ProductItem;
import com.example.billingservice.repository.BillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(BillRepository billRepository){
		return args ->{
			billRepository.save(new Bill(null, List.of(new ProductItem(null, 1, 1000.5, 10.30, null, null), new ProductItem(null, 3, 100.5, 8.30, null, null)),new Date(),1,null));
			billRepository.save(new Bill(null, List.of(new ProductItem(null, 2, 300, 18, null, null), new ProductItem(null, 2, 500, 3, null, null)),new Date(),2,null));
			billRepository.save(new Bill(null, List.of(new ProductItem(null, 1, 5480, 5, null, null), new ProductItem(null, 3, 458, 5, null, null)),new Date(),3,null));
			//billRepository.findAll().forEach(System.out::println);
		};
	}
}
