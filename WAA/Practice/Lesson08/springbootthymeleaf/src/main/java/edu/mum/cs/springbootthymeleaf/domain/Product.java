package edu.mum.cs.springbootthymeleaf.domain;

public class Product {

	private String name;
	private double price;
	private boolean inStock;

	public Product(String name, double price, boolean inStock) {
		this.name = name;
		this.price = price;
		this.inStock = inStock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

}
