package com.geek.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.geek.model.Product;

@Service
public class ProductService {
	public List<Product> allProducts() {
		Product p1 = new Product(1, "Shoes", 2000);
		Product p2 = new Product(2, "Bat", 1500);
		Product p3 = new Product(3, "Ball", 200);
		Product p4 = new Product(4, "Gloves", 1200);
		Product p5 = new Product(5, "Helmet", 2500);
		List<Product> plist = new ArrayList<>();
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		plist.add(p4);
		plist.add(p5);
		return plist;
	}
}
