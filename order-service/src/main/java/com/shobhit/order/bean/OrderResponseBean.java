package com.shobhit.order.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseBean {
	private int orderId;
	private String name;
	private int quantity;
	private double price;
	private String orderStatus;
	private String transactionId;
	private String paymentStatus;
}