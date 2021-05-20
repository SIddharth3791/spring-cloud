package com.sid.orderservice.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.orderservice.api.model.Order;

public interface OrderRepo  extends JpaRepository<Order, Integer>{

}
