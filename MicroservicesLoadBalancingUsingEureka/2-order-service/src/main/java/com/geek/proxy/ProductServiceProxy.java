package com.geek.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.geek.model.Order;

//@FeignClient(name="product-catalogue-service",url="http://localhost:8000")
@FeignClient(name="product-catalogue-service") // Load Balancing
public interface ProductServiceProxy {
	@GetMapping("/{id}")
	public Order getProduct(@PathVariable int id);
}
