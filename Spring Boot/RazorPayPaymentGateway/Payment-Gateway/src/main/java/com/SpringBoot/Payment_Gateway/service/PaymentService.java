package com.SpringBoot.Payment_Gateway.service;

import com.SpringBoot.Payment_Gateway.entity.PaymentOrder;
import com.SpringBoot.Payment_Gateway.repository.PaymentRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    @Value("${razorpay.key_id}")
    private String keyId;

    @Value("${razorpay.key_secret}")
    private String keySecret;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private EmailService emailService;



    public String createOrder(PaymentOrder orderDetails) throws RazorpayException {

        RazorpayClient razorpayClient = new RazorpayClient(keyId , keySecret);

        //json
        JSONObject orderRequest=  new JSONObject();
        orderRequest.put("amount" , (int)(orderDetails.getAmount()*100));
        orderRequest.put("currency","INR");
        orderRequest.put("receipt" , "txn_"+ UUID.randomUUID());

        Order razorpayOrder=razorpayClient.orders.create(orderRequest);

        System.out.println(razorpayOrder.toString());

        orderDetails.setOrderId(razorpayOrder.get("id"));
        orderDetails.setStatus("CREATED");
        orderDetails.setCreatedAt(LocalDateTime.now());

        paymentRepository.save(orderDetails);

        return razorpayOrder.toString();

//        System.out.println("Simulated Razorpay order");
//        orderDetails.setOrderId("order_dummy_12345");
//        orderDetails.setStatus("CREATED");
//        orderDetails.setCreatedAt(LocalDateTime.now());
//        paymentRepository.save(orderDetails);
//        return "Simulated Order Created";



    }

    public void updateOrderStatus(String paymentId, String orderId, String status)
    {
        PaymentOrder order = paymentRepository.findByOrderId(orderId);
        order.setPaymentId(paymentId);
        order.setStatus(status);
        paymentRepository.save(order);

        if("SUCCESS".equalsIgnoreCase(status))
        {
            emailService.sendEmail(order.getEmail() , order.getName() , order.getCourseName() , order.getAmount());
        }

    }
}
