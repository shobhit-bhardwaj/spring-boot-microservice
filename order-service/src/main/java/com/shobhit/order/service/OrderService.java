package com.shobhit.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shobhit.order.bean.OrderRequestBean;
import com.shobhit.order.bean.OrderResponseBean;
import com.shobhit.order.bean.Payment;
import com.shobhit.order.dao.OrderDao;
import com.shobhit.order.entity.OrderEntity;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private RestTemplate restTemplate;

	public OrderResponseBean saveOrder(OrderRequestBean requestBean) {
		OrderEntity order = new OrderEntity();
		order.setName(requestBean.getName());
		order.setQuantity(requestBean.getQuantity());
		order.setPrice(requestBean.getPrice());
		order = orderDao.save(order);

		Payment paymentRequest = new Payment();
		paymentRequest.setOrderId(order.getId());
		paymentRequest.setAmount(order.getPrice());
		Payment paymentResponse = restTemplate.postForObject("http://payment-service/PaymentService/payment/save", paymentRequest, Payment.class);

		order.setStatus(paymentResponse.getPaymentStatus());
		order = orderDao.save(order);

		OrderResponseBean responseBean = new OrderResponseBean();
		responseBean.setOrderId(order.getId());
		responseBean.setName(order.getName());
		responseBean.setQuantity(order.getQuantity());
		responseBean.setPrice(order.getPrice());
		responseBean.setOrderStatus(order.getStatus());
		responseBean.setTransactionId(paymentResponse.getTransactionId());
		responseBean.setPaymentStatus(paymentResponse.getPaymentStatus());

		return responseBean;
	}

	public OrderEntity getOrderById(int id) {
		return orderDao.findById(id).orElse(null);
	}
}