package com.SpringBoot.Payment_Gateway.repository;

import com.SpringBoot.Payment_Gateway.entity.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentOrder , Long> {

    PaymentOrder findByOrderId(String orderId);

}
