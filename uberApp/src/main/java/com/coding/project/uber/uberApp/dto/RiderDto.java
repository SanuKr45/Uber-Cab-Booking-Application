package com.coding.project.uber.uberApp.dto;

import com.coding.project.uber.uberApp.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiderDto {

    private Long id;
    private UserDto user;
    private Double rating;
}
