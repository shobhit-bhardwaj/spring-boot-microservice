package com.shobhit.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shobhit.order.bean.OrderRequestBean;
import com.shobhit.order.bean.OrderResponseBean;
import com.shobhit.order.entity.OrderEntity;
import com.shobhit.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public OrderResponseBean saveOrder(@RequestBody OrderRequestBean requestBean) {
		OrderResponseBean responseBean = orderService.saveOrder(requestBean);
		return responseBean;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public OrderEntity getOrderById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}
}