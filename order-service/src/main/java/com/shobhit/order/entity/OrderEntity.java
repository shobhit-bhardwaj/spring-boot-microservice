package com.shobhit.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ORDER_TBL")
public class OrderEntity {

	@Id
	@GeneratedValue
	private int id;

	private String name;
	private int quantity;
	private double price;
	private String status;
}
