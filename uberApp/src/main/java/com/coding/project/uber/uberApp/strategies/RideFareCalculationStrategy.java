package com.coding.project.uber.uberApp.strategies;

import com.coding.project.uber.uberApp.dto.RideRequestDto;
import com.coding.project.uber.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    static final double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);

}
