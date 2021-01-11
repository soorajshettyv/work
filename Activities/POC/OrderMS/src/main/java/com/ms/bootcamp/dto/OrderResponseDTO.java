package com.ms.bootcamp.dto;

import java.util.List;

import com.ms.bootcamp.entity.OrderEntity;

public class OrderResponseDTO {
	
	List<OrderEntity> orderEntity;
	
    private double orderCost;

    public OrderResponseDTO() {}
    
    
    
	public OrderResponseDTO(List<OrderEntity> orderEntity, double orderCost) {
		super();
		this.orderEntity = orderEntity;
		this.orderCost = orderCost;
	}



	public List<OrderEntity> getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(List<OrderEntity> orderEntity) {
		this.orderEntity = orderEntity;
	}

	public double getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}

	@Override
	public String toString() {
		return "[order entries=" + orderEntity.toString() + ", orderCost=" + orderCost + "]";
	}

	
    
    
    
	
	
    
}