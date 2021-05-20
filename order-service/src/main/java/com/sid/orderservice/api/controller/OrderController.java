package com.sid.orderservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.orderservice.api.common.TransactionRequest;
import com.sid.orderservice.api.common.TransactionResponse;
import com.sid.orderservice.api.model.Order;
import com.sid.orderservice.api.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	
	@PostMapping("/save")
	public TransactionResponse saveOrder(@RequestBody TransactionRequest request) {
		return service.saveOrder(request);
	}

}
