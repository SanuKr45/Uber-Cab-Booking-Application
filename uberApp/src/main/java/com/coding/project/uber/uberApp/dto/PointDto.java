package com.coding.project.uber.uberApp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PointDto {
    public PointDto(double[] coordinates) {
        this.coordinates = coordinates;

    }

    private double[] coordinates;
    private String type = "Point";
}
