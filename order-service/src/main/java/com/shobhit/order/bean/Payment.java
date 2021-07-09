package com.shobhit.order.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	private int orderId;
	private double amount;
	private String transactionId;
	private String paymentStatus;
}