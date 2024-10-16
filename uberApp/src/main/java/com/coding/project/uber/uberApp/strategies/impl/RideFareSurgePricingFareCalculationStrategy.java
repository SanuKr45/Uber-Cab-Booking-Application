package com.coding.project.uber.uberApp.strategies.impl;

import com.coding.project.uber.uberApp.dto.RideRequestDto;
import com.coding.project.uber.uberApp.entities.RideRequest;
import com.coding.project.uber.uberApp.services.DistanceService;
import com.coding.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;
    private static final double SURGE_PRICE=2;
    // TODO -> CAN CALL SURGING FACTOR LIKE WEATHER
    //         ->IF RAINING TWICE THE PRICE


    public double calculateFare(RideRequest rideRequest) {
        Double distance = distanceService.calculateDistance(rideRequest.getPickUpLocation(),
                rideRequest.getDropOffLocation());
        return distance*RIDE_FARE_MULTIPLIER*SURGE_PRICE;

    }
}
