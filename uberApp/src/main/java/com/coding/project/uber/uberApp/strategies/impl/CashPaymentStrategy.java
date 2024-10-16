package com.coding.project.uber.uberApp.strategies.impl;

import com.coding.project.uber.uberApp.entities.Driver;
import com.coding.project.uber.uberApp.entities.Payment;
import com.coding.project.uber.uberApp.entities.enums.PaymentStatus;
import com.coding.project.uber.uberApp.entities.enums.TransactionMethod;
import com.coding.project.uber.uberApp.repositories.PaymentRepository;
import com.coding.project.uber.uberApp.services.PaymentService;
import com.coding.project.uber.uberApp.services.WalletService;
import com.coding.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// driver received 100 rs cash from rider
// now we have to charge the platform fee from the driver
// we will initialize the hard core value in the PaymentStrategy
// According to the value initialized ->
//                  calculate the commission and deduct it from the drivers wallet

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {

        Driver driver = payment.getRide().getDriver();

        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission,
                null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
