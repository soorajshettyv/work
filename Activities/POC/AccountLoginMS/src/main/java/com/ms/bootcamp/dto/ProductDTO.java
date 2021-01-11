package com.ms.bootcamp.dto;

public class ProductDTO {
	private int productId;
	   
	private String productname;
	private double price_per_unit;
	private String unit;// (kg/piece)
	private int  inventory;
	private String category;
	
	
	public ProductDTO() {};
	
	public ProductDTO(int productId, String productname, double price_per_unit, String unit, int inventory, String category) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.price_per_unit = price_per_unit;
		this.unit = unit;
		this.inventory = inventory;
		this.category = category;
	}
	
	public double getPrice_per_unit() {
		return price_per_unit;
	}
	public void setPrice_per_unit(double price_per_unit) {
		this.price_per_unit = price_per_unit;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}
	

}

