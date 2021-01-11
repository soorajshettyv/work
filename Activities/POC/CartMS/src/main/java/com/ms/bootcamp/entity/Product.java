package com.ms.bootcamp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="product")
public class Product {

	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private int id;
	   
		private String name;
		private Double price_per_unit;
		private String unit;// (kg/piece)
		private int  quantity;
		private String category;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getPrice_per_unit() {
			return price_per_unit;
		}
		public void setPrice_per_unit(Double price_per_unit) {
			this.price_per_unit = price_per_unit;
		}
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}


}
