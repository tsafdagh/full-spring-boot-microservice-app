package com.example.inventoryservice.data;

import org.springframework.data.rest.core.config.Projection;


@Projection(name = "fullProductr", types = Product.class)
public interface ProductProjection extends Projection {
    public Long getId();
    public String getName();
    public double getPrice();
}
