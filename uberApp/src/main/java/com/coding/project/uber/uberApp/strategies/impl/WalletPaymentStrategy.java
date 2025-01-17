package com.coding.project.uber.uberApp.strategies.impl;

import com.coding.project.uber.uberApp.entities.Driver;
import com.coding.project.uber.uberApp.entities.Payment;
import com.coding.project.uber.uberApp.entities.Rider;
import com.coding.project.uber.uberApp.entities.enums.PaymentStatus;
import com.coding.project.uber.uberApp.entities.enums.TransactionMethod;
import com.coding.project.uber.uberApp.repositories.PaymentRepository;
import com.coding.project.uber.uberApp.services.PaymentService;
import com.coding.project.uber.uberApp.services.WalletService;
import com.coding.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Rider had 232, Driver had 500
// Ride fare = 100, platformCommission = 30
// driver -> 500 + (100 - 30) = 570
//rider -> 232 - 100 = 132


@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {

        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(), payment.getAmount(),
                null,payment.getRide(), TransactionMethod.RIDE);

        double driverCut = payment.getAmount() * (1-PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(),driverCut,
                null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);

    }
}
