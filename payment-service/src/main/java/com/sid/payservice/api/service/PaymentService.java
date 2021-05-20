package com.sid.payservice.api.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.payservice.api.model.Payment;
import com.sid.payservice.api.repo.PaymentRepo;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepo repo;
	
	public Payment doPayment(Payment payment) {
		payment.setTransactionId(UUID.randomUUID().toString());
		return repo.save(payment);
	}
	
	public Payment findPayByOrderId(int orderId) {
		return repo.findByOrderId(orderId);
	}

}
