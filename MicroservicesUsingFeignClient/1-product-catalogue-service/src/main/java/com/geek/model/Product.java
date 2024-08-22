package com.geek.model;

public class Product {
	private int id;
	private String prodName;
	private float price;
	private int port;
	
	public Product() {
		
	}
	
	public Product(int id, String prodName, float price) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.price = price;
	}
	
	public Product(int id, String prodName, float price, int port) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.price = price;
		this.port = port;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
}
