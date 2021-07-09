package com.shobhit.payment.entity;

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
@Table(name = "PAYMENT_TBL")
public class PaymentEntity {

	@Id
	@GeneratedValue
	private int id;

	private int orderId;
	private double amount;
	private String transactionId;
	private String paymentStatus;
}