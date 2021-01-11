package com.ms.bootcamp.dto;


public class CartResponseDTO {

	private int userId;   	
    private int productId;       
    private int quantity;    
    private String productname;   
    private double price_per_unit;
	private String unit;
	private String category;
	private double price;

	public CartResponseDTO() {}
	
    public CartResponseDTO(int userId, int productId, int quantity, String productname, double price_per_unit,
			String unit, String category, double price) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.productname = productname;
		this.price_per_unit = price_per_unit;
		this.unit = unit;
		this.category = category;
		this.price = price;
	}

	public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

	@Override
	public String toString() {
		return "CartEntity [productId=" + productId + ", userId=" + userId + ", quantity=" + quantity + ", productname="
				+ productname + ", price=" + price + ", price_per_unit=" + price_per_unit + ", unit=" + unit
				+ ", category=" + category + "]";
	}
    
    
}

