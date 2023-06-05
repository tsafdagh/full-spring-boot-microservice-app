package com.example.billingservice.controller;

import com.example.billingservice.data.Bill;
import com.example.billingservice.openFeignClient.CustomerServiceClient;
import com.example.billingservice.openFeignClient.InventoryServiceClient;
import com.example.billingservice.repository.BillRepository;
import com.example.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {

    @Autowired private BillRepository billRepository;

    @Autowired private ProductItemRepository productItemRepository;

    @Autowired private CustomerServiceClient customerServiceClient;

    @Autowired private InventoryServiceClient inventoryServiceClient;

    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable(name = "id") Long id){

        Bill bill = billRepository.findById(id).get();

        bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerId()));

        bill.setProductItems(productItemRepository.findByBillId(id));

        bill.getProductItems().forEach(pi->{
            pi.setProduct(inventoryServiceClient.findProductById(pi.getProductId()));
        });

        return bill;
    }
}
