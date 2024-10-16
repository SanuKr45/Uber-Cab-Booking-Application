package com.coding.project.uber.uberApp.repositories;

import com.coding.project.uber.uberApp.entities.Payment;
import com.coding.project.uber.uberApp.entities.Ride;
import com.coding.project.uber.uberApp.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByRide(Ride ride);
}
