package com.sathya.springbootmvc.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
public class Productentity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	private String name;
	private String brand;
	private String madeIn;
	private double price;
	private int Quantity;
	private double taxrate;
	private double discountrate;
	private double discountprice;	
	private double offerprice;
	private double finalprice;
	private double stockvalue;
	

}
