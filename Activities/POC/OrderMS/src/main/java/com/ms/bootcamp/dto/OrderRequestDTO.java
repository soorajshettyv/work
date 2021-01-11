package com.ms.bootcamp.dto;

public class OrderRequestDTO {
	private int userId;
    private int productId;
    private int quantity;        
    private String productname;
    private double price_per_unit;
    private String unit;
    private String category;      
    private double price;
	
	public OrderRequestDTO(){

    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderRequestDTO [productId=" + productId + ", quantity=" + quantity + ", userId=" + userId
				+ ", productname=" + productname + ", price=" + price + ", price_per_unit=" + price_per_unit + ", unit="
				+ unit + ", category=" + category + "]";
	}

	
    
}