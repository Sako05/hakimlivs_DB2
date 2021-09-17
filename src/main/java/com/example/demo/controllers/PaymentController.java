package com.example.demo.controllers;

import com.example.demo.model.Payment;
import com.example.demo.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import com.example.demo.model.Payment;
import com.example.demo.model.Product;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.OrdersRepository;
import com.example.demo.repositories.PaymentRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping(path ="/add/{reference}/{status}")
    public String addOrUpdatePayment(@PathVariable String reference, @PathVariable String status){

            Payment payment = paymentRepository.findByReference(reference)
                    .orElse(new Payment(reference, status));

            payment.setStatus(status);
            paymentRepository.save(payment);

        return "Payment was added";
    }




    @GetMapping(path="/all")
    public @ResponseBody Iterable<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }







}
