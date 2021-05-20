package com.sid.payservice.api.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.payservice.api.model.Payment;
import com.sid.payservice.api.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	
	@PostMapping("/pay")
	public Payment makePayment(@RequestBody Payment payment) {
		payment.setPaymentStatus(paymentProcessed());
		return service.doPayment(payment);
	}

	@GetMapping("/{orderId}")
	public Payment findPaymentByOrderId(@PathVariable int orderId) {
		return service.findPayByOrderId(orderId);
	}
	
	public static String paymentProcessed() {
		return new Random().nextBoolean()? "Success" : "false";
	}
}
