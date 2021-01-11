package com.ms.bootcamp.entity;

import javax.persistence.*;


@Entity @IdClass(PrimaryKey.class)
@Table(name= "Cart")
public class CartEntity {
	
	 @Id
	private int userId;
    
	@Id
    private int productId;    
   
    private int quantity;    
    private String productname;   
    private double price_per_unit;
	private String unit;
	private String category;
	private double price;

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

