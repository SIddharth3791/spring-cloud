package com.sid.orderservice.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sid.orderservice.api.common.Payment;
import com.sid.orderservice.api.common.TransactionRequest;
import com.sid.orderservice.api.common.TransactionResponse;
import com.sid.orderservice.api.model.Order;
import com.sid.orderservice.api.repo.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo repo;
	
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/pay", payment, Payment.class);
		
		repo.save(order);
		
		String message = paymentResponse.getPaymentStatus().equals("Success")? "Good" : "Bad";
				
		
		return new TransactionResponse(order, payment.getAmount(), paymentResponse.getTransactionId(), message );
	}

}
