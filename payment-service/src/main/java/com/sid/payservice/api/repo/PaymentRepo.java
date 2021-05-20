package com.sid.payservice.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.payservice.api.model.Payment;

public interface PaymentRepo  extends JpaRepository<Payment, Integer>{

	Payment findByOrderId(int orderId);

}
