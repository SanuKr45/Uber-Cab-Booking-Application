package com.coding.project.uber.uberApp.dto;

import com.coding.project.uber.uberApp.entities.User;
import com.coding.project.uber.uberApp.entities.WalletTransaction;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto {

    private Long Id;

    private UserDto user;

    private Double balance;

    private List<WalletTransactionDto> transaction;

}
