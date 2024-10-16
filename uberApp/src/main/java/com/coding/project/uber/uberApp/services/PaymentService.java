package com.coding.project.uber.uberApp.services;

import com.coding.project.uber.uberApp.entities.Payment;
import com.coding.project.uber.uberApp.entities.Ride;
import com.coding.project.uber.uberApp.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment crateNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);

}
