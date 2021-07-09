package com.shobhit.payment.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shobhit.payment.dao.PaymentDao;
import com.shobhit.payment.entity.PaymentEntity;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	public PaymentEntity save(PaymentEntity payment) {
		String paymentStatus = makeThirdPartyPayment();

		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(paymentStatus);
		payment = paymentDao.save(payment);

		return payment;
	}

	public PaymentEntity getPaymentById(int id) {
		return paymentDao.findById(id).orElse(null);
	}

	private String makeThirdPartyPayment() {
		boolean payment = new Random().nextBoolean();
		return (payment) ? "SUCCESS" : "FAILURE";
	}
}