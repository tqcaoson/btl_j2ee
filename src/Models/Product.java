package com.productstore;

public class Product {
	private int id;
	private String productName;
	private String code;
	private int number;
	private int priceInt;
	private int priceOut;
	
	
	public Product() {
	}
	
	public Product(int id, String productName, String code, int number, int priceInt, int priceOut) {

		this.id = id;
		this.productName = productName;
		this.code = code;
		this.number = number;
		this.priceInt = priceInt;
		this.priceOut = priceOut;
	}
	

	public Product(String productName, String code, int number, int priceInt, int priceOut) {
		
		this.productName = productName;
		this.code = code;
		this.number = number;
		this.priceInt = priceInt;
		this.priceOut = priceOut;
	}
	

	public Product(int id) {
		
		this.id = id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPriceInt() {
		return priceInt;
	}
	public void setPriceInt(int priceInt) {
		this.priceInt = priceInt;
	}
	public int getPriceOut() {
		return priceOut;
	}
	public void setPriceOut(int priceOut) {
		this.priceOut = priceOut;
	}
	
	
	
}

