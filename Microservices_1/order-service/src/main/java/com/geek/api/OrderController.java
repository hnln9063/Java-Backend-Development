package com.geek.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import com.geek.model.Order;

@RestController
public class OrderController {
	
	@GetMapping("/order/{id}/{quantity}")
	public Order placeOrder(@PathVariable int id,@PathVariable int quantity) {
		String url = "http://localhost:8000/"+id;
		ResponseEntity<Order> response = new RestTemplate().getForEntity(url, Order.class); //Order.class is return type
		// client use restTemplate to 
		Order order = response.getBody();
		order.setPrice(order.getPrice()*quantity);
		order.setQuantity(quantity);
		return order;
	}
}
