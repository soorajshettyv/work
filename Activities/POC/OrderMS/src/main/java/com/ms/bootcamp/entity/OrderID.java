package com.ms.bootcamp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="order_list")
public class OrderID {

	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private int id;
	    
	    private long orderId;
	    
	    private int userId;
	    
	    private double orderCost;
	   
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public long getOrderId() {
			return orderId;
		}
		public void setOrderId(long orderId) {
			this.orderId = orderId;
		}
				
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public double getOrderCost() {
			return orderCost;
		}
		public void setOrderCost(double orderCost) {
			this.orderCost = orderCost;
		}
		@Override
		public String toString() {
			return "OrderID [id=" + id + ", orderId=" + orderId + ", userId=" + userId + ", orderCost=" + orderCost
					+ "]";
		}
		
		
		

		

}
