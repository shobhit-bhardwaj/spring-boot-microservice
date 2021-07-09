package com.shobhit.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shobhit.payment.entity.PaymentEntity;
import com.shobhit.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public PaymentEntity saveOrder(@RequestBody PaymentEntity payment) {
		return paymentService.save(payment);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public PaymentEntity getPaymentById(@PathVariable int id) {
		return paymentService.getPaymentById(id);
	}
}