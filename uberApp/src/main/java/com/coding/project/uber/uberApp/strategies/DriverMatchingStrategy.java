package com.coding.project.uber.uberApp.strategies;

import com.coding.project.uber.uberApp.entities.Driver;
import com.coding.project.uber.uberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {


    List<Driver> findMatchingDrivers(RideRequest rideRequest);
}
