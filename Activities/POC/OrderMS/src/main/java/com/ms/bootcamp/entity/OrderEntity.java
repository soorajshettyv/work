package com.ms.bootcamp.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity @IdClass(PrimaryKey.class)
@Table(name= "Order_Details")
public class OrderEntity {
	
	@Id
	private long orderId;
	
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	
    private LocalDateTime timeStamp;
	
    public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
	
	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "OrderEntry [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId + ", quantity="
				+ quantity + ", productname=" + productname + ", price_per_unit=" + price_per_unit + ", unit=" + unit
				+ ", category=" + category + ", price=" + price + ", orderDate=" + orderDate + ", timeStamp="
				+ timeStamp + "]";
	}

	
    
    
}

