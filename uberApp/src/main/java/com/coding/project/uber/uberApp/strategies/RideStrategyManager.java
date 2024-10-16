package com.coding.project.uber.uberApp.strategies;

import com.coding.project.uber.uberApp.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.coding.project.uber.uberApp.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.coding.project.uber.uberApp.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import com.coding.project.uber.uberApp.strategies.impl.RiderFareDefaultFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final RiderFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;
    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;


    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if (riderRating>4.5){
            return highestRatedDriverStrategy;
        }else{
            return nearestDriverStrategy;
        }

    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){

        // price can surged between a particular time
        // 6 pm to 9 pm

        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if (isSurgeTime) {
            return surgePricingFareCalculationStrategy;
        }
        else{
            return defaultFareCalculationStrategy;
            }
        }


    }


