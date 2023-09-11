package com.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.modal.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
