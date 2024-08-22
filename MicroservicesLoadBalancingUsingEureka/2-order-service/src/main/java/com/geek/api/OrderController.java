package com.geek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.geek.model.Order;
import com.geek.proxy.ProductServiceProxy;

@RestController
public class OrderController {
	
	@Autowired
	private ProductServiceProxy proxy;
	
	@GetMapping("/orderFeign/{id}/{quantity}")
	public Order placeOrderWithFeign(@PathVariable int id,@PathVariable int quantity) {
		// String url = "http://localhost:8000/"+id;
		// We will not use the above url
		Order order = proxy.getProduct(id);
		order.setQuantity(quantity);
		order.setPrice(order.getPrice()*quantity);
		return order;
	}
}
